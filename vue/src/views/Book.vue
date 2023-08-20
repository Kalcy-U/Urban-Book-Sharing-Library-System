<template>
  <div class="home" style ="padding: 10px">

    <!-- 搜索-->
    <div style="margin: 10px 0;">
      <el-form inline="true" size="small">
        <el-form-item label="图书驿站" >
          <el-input v-model="search1" placeholder="请输入图书驿站"  clearable>
            <template #prefix><el-icon class="el-input__icon"><search/></el-icon></template>
          </el-input>
        </el-form-item >
        <el-form-item label="图书信息" >
          <el-input v-model="search2" placeholder="按关键词搜索图书"  clearable>
            <template #prefix><el-icon class="el-input__icon"><search /></el-icon></template>
          </el-input>
        </el-form-item >
        
        <el-form-item>
          <el-button type="primary" style="margin-left: 1%" @click="load" size="mini" >
            <svg-icon iconClass="search"/>查询</el-button>
        </el-form-item>
        <el-form-item>
          <el-button size="mini"  type="danger" @click="clear">重置</el-button>
        </el-form-item>
        <el-form-item style="float: right" v-if="numOfOutDataBook!=0">
          <el-popconfirm
              confirm-button-text="查看"
              cancel-button-text="取消"
              :icon="InfoFilled"
              icon-color="red"
              title="您有图书已逾期，请尽快归还"
              @confirm="toLook"
          >
            <template #reference>
              <el-button  type="warning">逾期通知</el-button>
            </template>
          </el-popconfirm>
        </el-form-item>
      </el-form>
    </div>
    <!-- 按钮-->
    <div style="margin: 10px 0;" >
      <el-button type="primary" @click = "add" v-if="user.role == 1">新增图书</el-button>
      <!-- <el-popconfirm title="确认删除?" @confirm="deleteBatch" v-if="user.role == 1">
        <template #reference>
          <el-button type="danger" size="mini" >批量删除</el-button>
        </template>
      </el-popconfirm> -->
    </div>
    <!-- 数据字段-->
    <el-table :data="tableData" stripe border="true" @selection-change="handleSelectionChange">
      <!-- <el-table-column v-if="user.role ==1"
                       type="selection"
                       width="55"> -->
      <!-- </el-table-column> -->
      <el-table-column prop="bid" label="图书ID" sortable />
      <el-table-column prop="isbn" label="ISBN" sortable />
      <el-table-column prop="name" label="图书名称" />
      <el-table-column prop="author" label="作者" />
      <el-table-column prop="publish" label="出版社" />
      <el-table-column prop="atstation" label="驿站ID" sortable/>
      <el-table-column prop="status" label="状态">
        <template v-slot="scope">
          <el-tag v-if="scope.row.status == '外借'" type="normal">外借</el-tag>
          <el-tag v-else-if="scope.row.status == '待审核'" type="warning">待审核</el-tag>
          <el-tag v-else-if="scope.row.status == '逾期未还'" type="error">逾期未还</el-tag>
          <el-tag v-else type="success">在馆</el-tag>
        </template>
      </el-table-column>
      <el-table-column fixed="right" label="操作" >
        <template v-slot="scope">
          <el-button  size="mini" @click ="handleEdit(scope.row)" v-if="user.role == 1">修改</el-button>
          <el-popconfirm title="确认删除?" @confirm="handleDelete(scope.row.bid)" v-if="user.role == 1">
            <template #reference>
              <el-button type="danger" size="mini" >删除</el-button>
            </template>
          </el-popconfirm>
          <el-button  size="mini" @click ="handlelend(scope.row.bid)"  :disabled="scope.row.status != '在馆'">借阅</el-button>
          <!-- <el-popconfirm title="确认借阅?" @confirm="handlereturn(scope.row.bid)"  :disabled="scope.row.status  != '在馆'">
            <template #reference>
              <el-button type="danger" size="mini" :disabled="(this.isbnArray.indexOf(scope.row.isbn)) == -1 ||scope.row.status == 1" >还书</el-button>
            </template>
          </el-popconfirm> -->
        </template>
      </el-table-column>
    </el-table>
<!--测试,通知对话框-->
    <el-dialog
        v-model="dialogVisible3"
        v-if="numOfOutDataBook!=0"
        title="逾期详情"
        width="50%"
        :before-close="handleClose"
    >
        <el-table :data="outDateBook" style="width: 100%">
          <el-table-column prop="isbn" label="ISBN" />
          <el-table-column prop="bookName" label="书名" />
          <el-table-column prop="lendtime" label="借阅日期" />
          <el-table-column prop="deadtime" label="截至日期" />
        </el-table>

      <template #footer>
      <span class="dialog-footer">
        <el-button type="primary" @click="dialogVisible3 = false"
        >确认</el-button>
      </span>
      </template>
    </el-dialog>
    <!--    分页-->
    <div style="margin: 10px 0">
      <el-pagination
          v-model:currentPage="currentPage"
          :page-sizes="[5, 10, 20]"
          :page-size="pageSize"
          layout="total, sizes, prev, pager, next, jumper"
          :total="total"
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
      >
      </el-pagination>

      <el-dialog v-model="dialogVisible" title="新增书籍" width="30%">
        <el-form :model="form" label-width="120px">

          <el-form-item label="ISBN">
              <el-input style="width: 80%" v-model="form.isbn"></el-input>
            </el-form-item>
            <el-form-item label="图书名称">
              <el-input style="width: 80%" v-model="form.name"></el-input>
            </el-form-item>
            
            <el-form-item label="作者">
              <el-input style="width: 80%" v-model="form.author"></el-input>
            </el-form-item>
            <el-form-item label="出版社">
              <el-input style="width: 80%" v-model="form.publish"></el-input>
            </el-form-item>
            <el-form-item label="图书驿站">
                <el-input style="width: 80%" v-model="form.atstation" ></el-input>
            </el-form-item>
            <el-form-item label="书籍简介">
                  <el-input style="width: 80%" v-model="form.introduction" ></el-input>
            </el-form-item>
            
        </el-form>
        <template #footer>
      <span class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="save">确 定</el-button>
      </span>
        </template>
      </el-dialog>

      <el-dialog v-model="dialogVisible2" title="修改书籍信息" width="30%">
        <el-form :model="form" label-width="120px">

         
          <el-form-item label="图书名称">
            <el-input style="width: 80%" v-model="form.name"></el-input>
          </el-form-item>
          <el-form-item label="价格">
            <el-input style="width: 80%" v-model="form.price" type="number"></el-input>
          </el-form-item>
          <el-form-item label="作者">
            <el-input style="width: 80%" v-model="form.author"></el-input>
          </el-form-item>
          <el-form-item label="出版社">
            <el-input style="width: 80%" v-model="form.publish"></el-input>
          </el-form-item>
          <el-form-item label="图书驿站">
              <el-input style="width: 80%" v-model="form.atstation" type="number" ></el-input>
          </el-form-item>
          <el-form-item label="书籍简介">
                <el-input style="width: 80%" v-model="form.introduction" ></el-input>
            </el-form-item>
          <el-form-item label="书籍状态">
          <div>
            <el-radio v-model="form.status" label="在馆" :diable ="form.status!='待审核'">在馆</el-radio>
            <el-radio v-model="form.status" label="待审核" >待审核</el-radio>
            <el-radio v-model="form.status" label="外借" :diable ="form.status != '待审核'">外借</el-radio>
            <el-radio v-model ="form.status" label = "逾期未还" :diable ="form.status != '待审核'">逾期未还</el-radio>
          </div>
        </el-form-item>
        </el-form>
        <template #footer>
      <span class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="save">确 定</el-button>
      </span>
        </template>
      </el-dialog>
    </div>
  </div>
</template>

<script>
// @ is an alias to /src
import request from "../utils/request";
import {ElMessage} from "element-plus";
import moment from "moment";
export default {
  created(){
    let userStr = sessionStorage.getItem("user") ||"{}"
    this.user = JSON.parse(userStr)
    this.load()
  },
  name: 'Book',
  methods: {
  // (this.isbnArray.indexOf(scope.row.isbn)) == -1
    handleSelectionChange(val){
      this.ids = val.map(v =>v.id)
    },
    deleteBatch(){
      if (!this.ids.length) {
        ElMessage.warning("请选择数据！")
        return
      }
      //  一个小优化，直接发送这个数组，而不是一个一个的提交删除
      request.post("/book/deleteBatch",this.ids).then(res =>{
        if(res.code === '0'){
          ElMessage.success("批量删除成功")
          this.load()
        }
        else {
          ElMessage.error(res.msg)
        }
      })
    },
    load(){
      this.numOfOutDataBook =0;
      this.outDateBook =[];
      request.get("/book/search",{
        params:{
          pageNum: this.currentPage,
          pageSize: this.pageSize,
          search1: this.search1,
          search2: this.search2,
        }
      }).then(res =>{
        console.log(res)
        this.tableData = res.data.records;
        this.total = res.data.total;
      })
    // //
    //   if(this.user.role == 2){
    //     request.get("/bookwithuser",{
    //       params:{
    //         pageNum: "1",
    //         pageSize: this.total,
    //         search1: "",
    //         search2: "",
    //         search3: this.user.uid,
    //       }
    //     }).then(res =>{
    //       console.log(res)
    //       this.bookData = res.data.records
    //       this.number = this.bookData.length;
    //       res.data.records.forEach(record => {
    //         if (record.status === "逾期未还") this.numOfOutDataBook += 1;
    //       });
    //       console.log("in load():" +this.numOfOutDataBook );
    //     })
    //   }
      //
    },
    clear(){
      this.search1 = ""
      this.search2 = ""
      this.search3 = ""
      this.load()
    },

    handleDelete(id){
      request.post("/book/delete/"+id).then(res =>{
        console.log(res)
        if(res.code == 0 ){
          ElMessage.success("删除成功")
        }
        else
          ElMessage.error(res.msg)
        this.load()
      })
    },
   
    handlelend(bid){
      
      // this.form = {};
      // this.form.uid = this.user.uid;
      // this.form.bid = bid;
      // console.log(bn)
      request.get("/book/borrowbook/"+ bid+"/"+ this.user.uid).then(res =>{
        console.log(res)
        if(res.code == 0){
          ElMessage({
            message: '借阅成功',
            type: 'success',
          })
        }
        else {
          ElMessage.error(res.msg)
        }
      })
      this.load()
    },
    add(){
      this.dialogVisible= true
      this.form ={}
    },
    save(){
    
      if (this.form.bid) {
        let pub = { ...this.form };
        delete pub.atstation;
        delete pub.status;
        let bid = this.form.bid;
        delete pub.bid;
        pub.introduction = this.form.introduction;
        request.post("/book/update", {
            publication: pub,
            atstation: Number(this.form.atstation),
            status: this.form.status,
            bid: bid
        }).then(res =>{
          console.log(res)
          if(res.code == 0){
            ElMessage({
              message: '修改书籍信息成功',
              type: 'success',
            })
          }
          else {
            ElMessage.error(res.msg)
          }

          this.load()
          this.dialogVisible2 = false
        })
      }
      else {
        let pub = { ...this.form };
        delete pub.status;
        delete pub.atstation;
        pub.bnwid = null;
        pub.pubDate = null;
        pub.classId = null;
        pub.price = null;

        request.post("/book/insert", {
          
            publication: pub,
            atstation: Number(this.form.atstation),
            status:"在馆"
          
        }).then(res =>{
          console.log(res)
          if(res.code == 0){
            ElMessage.success('上架书籍成功')
          }
          else {
            ElMessage.error(res.msg)
          }
          this.load()
          this.dialogVisible = false
        })
      }

    },
    // formatter(row) {:formatter="formatter"
    //   return row.address
    // },

    handleEdit(row){
      this.form = JSON.parse(JSON.stringify(row))
      this.dialogVisible2 = true
    },
    handleSizeChange(pageSize){
      this.pageSize = pageSize
      this.load()
    },
    handleCurrentChange(pageNum){
      this.pageNum = pageNum
      this.load()
    },
    toLook(){
      this.dialogVisible3 =true;
    },
  },
  data() {
    return {
      form: {},
      form2:{},
      form3:{},
      dialogVisible: false,
      dialogVisible2: false,
      search1:'',
      search2:'',
      search3:'',
      total:10,
      currentPage:1,
      pageSize: 10,
      tableData: [],
      user:{},
      number:0,
      bookData:[],
      isbnArray:[],
      outDateBook:[],
      numOfOutDataBook: 0,
      dialogVisible3 : true,
    }
  },
}
</script>
