<template>

  <div class="home" style ="padding: 10px">
    <el-h1  v-if="user.role">我的借阅</el-h1>
    <!-- <el-h1 v-else>读者借阅</el-h1> -->
    <!-- 搜索-->
    <div style="margin: 10px 0;">

      <el-form inline="true" size="small" >
        <el-form-item label="图书编号" >
          <el-input v-model="search1" placeholder="请输入图书编号"  clearable>
            <template #prefix><el-icon class="el-input__icon"><search/></el-icon></template>
          </el-input>
        </el-form-item >
        <el-form-item label="图书名称" >
          <el-input v-model="search2" placeholder="请输入图书名称"  clearable>
            <template #prefix><el-icon class="el-input__icon"><search /></el-icon></template>
          </el-input>
        </el-form-item >
        <!-- <el-form-item label="借阅者" v-if="user.role == 1">
          <el-input v-model="search3" placeholder="请输入借阅者ID"  clearable>
            <template #prefix><el-icon class="el-input__icon"><search /></el-icon></template>
          </el-input>
        </el-form-item > -->
        <el-form-item>
          <el-button type="primary" style="margin-left: 1%" @click="load" size="mini">查询</el-button>
        </el-form-item>
        <el-form-item>
          <el-button size="mini"  type="danger" @click="clear">重置</el-button>
        </el-form-item>
      </el-form>
    </div>
    <!-- 按钮-->
    <!-- <div style="margin: 10px 0;" >
      <el-popconfirm title="确认删除?" @confirm="deleteBatch" v-if="user.role == 1">
        <template #reference>
          <el-button type="danger" size="mini" >批量删除</el-button>
        </template>
      </el-popconfirm>
    </div> -->
    <!-- 数据字段-->
    <el-table :data="tableData" stripe border="true" @selection-change="handleSelectionChange">
      <!-- <el-table-column v-if="user.role ==1"
          type="selection"
          width="55"> 
      </el-table-column>-->
        <el-table-column prop="borrowid" label="借阅编号" sortable/>
         <el-table-column prop="bid" label="图书编号" sortable/>
        <el-table-column prop="isbn" label="ISBN" sortable />
        <el-table-column prop="name" label="图书名称" />
        <!-- <el-table-column prop="uid" label="读者编号" sortable/> -->
        <el-table-column prop="borrowtime" label="借阅时间" sortable/>
        <el-table-column prop="duetime" label="应还时间" sortable/>
        <el-table-column prop="returntime" label="归还时间" sortable/>
        <el-table-column prop="renewal" label="续借次数" sortable/>
        <el-table-column prop="borrowstatus" label="状态" >
          <template v-slot="scope">
            <el-tag v-if="scope.row.borrowstatus == '未归还'" type="warning">未归还</el-tag>
            <el-tag v-else-if="scope.row.borrowstatus == '逾期未还'" type="error">未归还</el-tag>
            <el-tag v-else type="success">已归还</el-tag>
          </template>
        </el-table-column>
      <el-table-column fixed="right" label="操作"  style="min-width:40px" >
        <template v-slot="scope">
            
          <el-button  size="mini" @click="returnwindow(scope.row.borrowid)" :disabled="scope.row.borrowstatus != '未归还'" >还书</el-button>
          <el-popconfirm title="确认续借(续借一次延长30天)?" @confirm="handlereProlong(scope.row)" :disabled="scope.row.renewal >= 5|| scope.row.borrowstatus != '未归还'">
            <template #reference>
              <el-button type="dangrous" size="mini" :disabled="scope.row.renewal >=5|| scope.row.borrowstatus != '未归还'" >续借</el-button>
            </template>
          </el-popconfirm>
        </template>
      </el-table-column>
    </el-table>
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

        <el-dialog v-model="dialogVisible" title="归还图书" width="30%">
          <el-form :model="form2" label-width="120px">
              <el-h1>请确认您位于所选择的图书驿站附近，按下确认后等待归还仓门打开，放入要归还的图书。</el-h1>
              <el-form-item label="图书驿站编号">
                  <el-input style="width: 80%" v-model="form2.atstation" ></el-input>
              </el-form-item>
          </el-form>
          <template #footer>
        <span class="dialog-footer">
          <el-button @click="dialogVisible = false">取 消</el-button>
          <el-button type="primary" @click="handlereturn">确 定</el-button>
        </span>
          </template>
        </el-dialog>
      <!-- <el-dialog v-model="dialogVisible2" title="修改借阅信息" width="30%">
        <el-form :model="form" label-width="120px">

          <el-form-item label="图书编号">
            <el-input style="width: 80%" v-model="form.isbn"></el-input>
          </el-form-item>
          <el-form-item label="图书名称">
            <el-input style="width: 80%" v-model="form.bookName"></el-input>
          </el-form-item>
          <el-form-item label="借阅者">
            <el-input style="width: 80%" v-model="form.nickName"></el-input>
          </el-form-item>
          <el-form-item label="续借次数">
            <el-input style="width: 80%" v-model="form.renewal"></el-input>
          </el-form-item>
        </el-form>
        <template #footer>
      <span class="dialog-footer">
        <el-button @click="dialogVisible2 = false">取 消</el-button>
        <el-button type="primary" @click="save">确 定</el-button>
      </span>
        </template>
      </el-dialog> -->

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
  name: 'bookwithuser',
  methods: {

    handleSelectionChange(val){
      this.forms = val
    },
    deleteBatch(){
      if (!this.forms.length) {
        ElMessage.warning("请选择数据！")
        return
      }
    //  一个小优化，直接发送这个数组，而不是一个一个的提交删除
      request.post("book/deleteRecords",this.forms).then(res =>{
        if(res.code === '0'){
          ElMessage.success("批量删除成功")
          this.load()
        }
        else {
          ElMessage.error(res.msg)
        }
      })
    },
    returnwindow(borrowid)
    {
      
      this.dialogVisible = true;
      // this.atstation = 0;
      this.form2 = {};
      this.form2.borrowid = borrowid;
    },
    load(){
      if(0){
        request.get("/book/userborrow",{
          params:{
            pageNum: this.currentPage,
            pageSize: this.pageSize,
            search1: this.search1,
            search2: this.search2,
            search3: this.search3,
          }
        }).then(res =>{
          console.log(res)
          this.tableData = res.data.records
          this.total = res.data.total
        })
      }
      /*普通读者 */
      else {
        request.get("/book/userborrow",{
          params:{
            pageNum: this.currentPage,
            pageSize: this.pageSize,
            search1: this.search1,
            search2: this.search2,
            search3: this.user.uid,
          }
        }).then(res =>{
          console.log(res)
          this.tableData = res.data.records
          this.total = res.data.total
        })
      }
    },
    clear(){
      this.search1 = ""
      this.search2 = ""
      this.search3 = ""
      this.load()
    },
    
    handlereProlong(row){
      
      request.get("book/renewal/"+row.borrowid).then(res =>{
        console.log(res)
        if(res.code == 0){
          ElMessage({
            message: '续借成功',
            type: 'success',
          })
        }
        else {
          ElMessage.error(res.msg)
        }
        this.load()
        this.dialogVisible2 = false
      })
    },

    handlereturn() {

      request.get("/book/return/"+ this.form2.borrowid+"/"+this.form2.atstation).then(res => {
        console.log(res)
        if (res.code == 0) {
          ElMessage({
            message: '开始还书，请将要归还的图书放入仓门',
            type: 'success',
          })
        }
        else {
          ElMessage.error(res.msg)
        }
        this.load()
        this.dialogVisible2 = false
      })
    },
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

  },
  data() {
    return {
      form: {},
      form2:{},
      form3:{},
      dialogVisible: false,
      dialogVisible2: false,
      stationid: -1,
      search1:'',
      search2:'',
      search3:'',
      total:10,
      currentPage:1,
      pageSize: 10,
      tableData: [],
      user:{},
      forms:[],
    }
  },
}
</script>
