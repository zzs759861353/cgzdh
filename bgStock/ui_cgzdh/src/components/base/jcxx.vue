<template>
<div style='width:500px ;margin:0 auto'>
  <el-form :model="userForm" :rules="rules" ref="userForm" label-width="100px" class="demo-userForm">
  <el-form-item label="用户姓名" prop="name">
    <el-input v-model="userForm.name" disabled></el-input>
  </el-form-item>
  <el-form-item label="充值帐号" prop="account">
    <el-input v-model="userForm.account" disabled></el-input>
  </el-form-item>
  <el-form-item label="购买时长" prop="region">
    <el-select  placeholder="请选择" v-model='gmje' >
      <el-option
        v-for="item in gmsc"
        :key="item.value"
        :label="item.label"
        :value="item.value"
        >
      </el-option>
    </el-select>
    </el-form-item>
    <el-form-item label="充值金额" prop="account">
      <el-input v-model="gmje" disabled></el-input>
    </el-form-item>
    <el-form-item label="到期时间" prop="account">
      <el-input v-model="gmje" disabled></el-input>
    </el-form-item>
  <el-form-item>
    <el-button type="primary" @click="submitForm('userForm')">立即创建</el-button>
    <el-button @click="resetForm('userForm')">重置</el-button>
  </el-form-item>
</el-form>
  </div>
  </template>
  <script>
  export default {
    mounted: function () {
      this.userForm = this.getuserDetail();
      alert(this.g_if(true,1,2));
    },
   data() {
     return {
       gmje:'',
       userForm: {},
       gmsc:[
            {label:'一个月',value:200},
            {label:'三个月',value:600},
            {label:'六个月',value:1200}
          ],
       rules: {
         name: [
           { required: true, message: '请输入活动名称', trigger: 'blur' },
           { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
         ],
         region: [
           { required: true, message: '请选择活动区域', trigger: 'change' }
         ],
         date1: [
           { type: 'date', required: true, message: '请选择日期', trigger: 'change' }
         ],
         date2: [
           { type: 'date', required: true, message: '请选择时间', trigger: 'change' }
         ],
         type: [
           { type: 'array', required: true, message: '请至少选择一个活动性质', trigger: 'change' }
         ],
         resource: [
           { required: true, message: '请选择活动资源', trigger: 'change' }
         ],
         desc: [
           { required: true, message: '请填写活动形式', trigger: 'blur' }
         ]
       }
     };
   },
   methods: {
     gmsj(v){


     },
     submitForm(formName) {
       this.$refs[formName].validate((valid) => {
         if (valid) {
           alert('submit!');
         } else {
           console.log('error submit!!');
           return false;
         }
       });
     },
     resetForm(formName) {
       this.$refs[formName].resetFields();
     }
   }
 }
  </script>
  <style>

  .knLable{text-align: left;line-height: 40px;color:#ffffff;padding:4px;font-size: 16px}
    .knlist{text-align: left;line-height: 32px;color:#ffffff;padding-left: 6px;font-size: 15px}
  .el-row {
  margin-bottom: 20px;
  &:last-child {
    margin-bottom: 0;
  }
}
label{float: right;}
.el-col {
  border-radius: 4px;
}
.bg-purple-dark {
  background: #40adf5;
}

.bg-purple {
  background: #d3dce6;
}
.bg-purple-light {
  background: #e5e9f2;
}
.grid-content {
  border-radius: 4px;
  min-height: 36px;
}
.grid-content-small {
  border-radius: 4px;
  height: 30px;
}
.row-bg {
  padding: 10px 0;
  background-color: #f9fafc;
}
  </style>
