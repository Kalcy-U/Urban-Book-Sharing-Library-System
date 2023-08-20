<template>
  <div class="home" style ="padding: 10px">
<!-- 按钮-->
<!-- 搜索-->
    <div style="margin: 10px 0;">
      <el-form inline="true" size="small">
        <el-form-item label="读者ID" >
      <el-input v-model="search1" placeholder="请输入读者ID"  clearable>
        <template #prefix><el-icon class="el-input__icon"><search/></el-icon></template>
      </el-input>
          </el-form-item >
        <el-form-item label="姓名" >
          <el-input v-model="search2" placeholder="请输入姓名"  clearable>
            <template #prefix><el-icon class="el-input__icon"><search /></el-icon></template>
          </el-input>
        </el-form-item >
        <el-form-item label="电话号码" >
          <el-input v-model="search3" placeholder="请输入电话号码"  clearable>
            <template #prefix><el-icon class="el-input__icon"><search /></el-icon></template>
          </el-input>
        </el-form-item >
        <el-form-item label="信用最小值" >
          <el-input v-model="search4" placeholder="请输入信用值范围最小值"  clearable>
            <template #prefix><el-icon class="el-input__icon"><search /></el-icon></template>
          </el-input>
        </el-form-item >
        <el-form-item label="信用最大值" >
            <el-input v-model="search5" placeholder="请输入信用值范围最大值"  clearable>
              <template #prefix><el-icon class="el-input__icon"><search /></el-icon></template>
            </el-input>
          </el-form-item >
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
    <el-table :data="tableData" stripe border="true"  @selection-change="handleSelectionChange" >
      <!-- <el-table-column v-if="user.role ==1 "
                       type="selection"
                       width="55">
      </el-table-column> -->
      <el-table-column prop="uid" label="读者编号" sortable />
      <el-table-column prop="username" label="用户名" />
     
      <el-table-column prop="phonenumber" label="电话号码" />
      <el-table-column prop="discription" label="简介" />
      <el-table-column prop="isvolunteer" label="角色" >
        
      <template v-slot="scope">
            <el-tag v-if="scope.row.isvolunteer == true" type="success" >志愿者</el-tag>
            <el-tag v-else >用户</el-tag>
          </template>
          </el-table-column>
      <el-table-column prop="credict" label="信用" />
       <el-table-column prop="ustatus" label="状态" >
        
        <template v-slot="scope">
              <el-tag v-if="scope.row.ustatus == '正常'"  type="success">正常</el-tag>
              <el-tag v-else-if="scope.row.ustatus == '审查'"  type="warning" >审查</el-tag>
              <el-tag v-else-if="scope.row.ustatus == '禁封'"  type="error" >禁封</el-tag>
            </template>
            </el-table-column>
      <el-table-column fixed="right" label="操作" >
        <template v-slot="scope">
          <el-button  size="mini" @click ="handleEdit(scope.row)">编辑</el-button>
          <el-popconfirm title="确认删除?" @confirm="handleDelete(scope.row.uid)">
            <template #reference>
              <el-button type="danger" size="mini" >删除</el-button>
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

      <el-dialog v-model="dialogVisible" title="编辑读者信息" width="30%">
        <el-form :model="form" label-width="120px">
          <el-form-item label="用户名">
            <el-input style="width: 80%" v-model="form.username"></el-input>
          </el-form-item>
          
          <el-form-item label="电话号码">
            <el-input style="width: 80%" v-model="form.phonenumber"></el-input>
          </el-form-item>
          <el-form-item label="简介">
              <el-input style="width: 80%" v-model="form.discription"></el-input>
            </el-form-item>
            <el-form-item label="信用">
                <el-input style="width: 80%" v-model.number="form.credict" type="number" ></el-input>
              </el-form-item>
          <el-form-item label="账号状态">
            <div>
              <el-radio v-model="form.ustatus" label="正常">正常</el-radio>
              <el-radio v-model="form.ustatus" label="禁封">禁封</el-radio>
            </div>
          </el-form-item>
          <el-form-item label="角色">
              <div>
                <el-radio v-model="form.isvolunteer" label=true>志愿者</el-radio>
                <el-radio v-model="form.isvolunteer" label=false>普通用户</el-radio>
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

export default {
  created(){
    this.load()
    let userStr = sessionStorage.getItem("user") ||"{}"
    this.user = JSON.parse(userStr)
  },
  name: 'User',
  methods: {
    handleSelectionChange(val){
      this.ids = val.map(v => v.id)
    },
    deleteBatch(){
      if (!this.ids.length) {
        ElMessage.warning("请选择数据！")
        return
      }
      //  一个小优化，直接发送这个数组，而不是一个一个的提交删除
      request.post("/user/deleteBatch",this.ids).then(res =>{
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
      request.get("user/usersearch",{
        params:{
          pageNum: this.currentPage,
          pageSize: this.pageSize,
          search1: this.search1,
          search2: this.search2,
          search3: this.search3,
          search4: this.search4,
          search5: this.search5,
        }
      }).then(res =>{
        console.log(res)
        this.tableData = res.data.records
        this.total = res.data.total
      })
    },
    clear(){
      this.search1 = "";
      this.search2 = "";
      this.search3 = "";
      this.search4 = "";
      this.search5 = ""
      this.load()
    },

    handleDelete(id){
      request.delete("user/" + id ).then(res =>{
        console.log(res)
        if(res.code == 0 ){
          ElMessage.success("删除成功")
        }
        else
          ElMessage.error(res.msg)
        this.load()
      })
    },


    add(){
      this.dialogVisible= true
      this.form ={}
    },
    save(){
      if (this.form.uid) {
        if (this.form.isvolunteer==="true") this.form.isvolunteer=true;
        else this.form.isvolunteer=false;
        request.post("/user/update",this.form).then(res =>{
          console.log(res)
          if(res.code == 0){
            ElMessage({
              message: '更新成功',
              type: 'success',
            })
          }
          else {
            ElMessage.error(res.msg)
          }

          this.load() //不知道为啥，更新必须要放在这里面
          this.dialogVisible = false
        })
      }
      else {
        request.post("/user/insert",this.form).then(res =>{
          console.log(res)
          if(res.code == 0){
            ElMessage.success('添加成功')
          }
          else {
            ElMessage.error(res.msg)
          }
          this.load()
          this.dialogVisible = false
        })
      }

    },


    handleEdit(row){
      this.form = JSON.parse(JSON.stringify(row))
      this.dialogVisible = true
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
      dialogVisible : false,
      search1:'',
      search2:'',
      search3:'',
      search4: '',
      search5: '',
      total:10,
      currentPage:1,
      pageSize: 10,
      tableData: [

      ],
      user:{},
      ids:[],
    }
  },
}
</script>
