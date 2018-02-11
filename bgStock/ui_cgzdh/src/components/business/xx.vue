<template>

      <el-form  label-width="80px" :model="formLabelAlign" style='max-width:350px'>
        <el-form-item label="帐号:">
          <el-input disabled v-model="user.userName"></el-input>
        </el-form-item>
        <el-form-item label="名称:">
          <el-input disabled v-model="user.name"></el-input>
        </el-form-item>
        <el-form-item label="邀请人:">
          <el-input disabled v-model="user.recomender"></el-input>
        </el-form-item>
        <el-form-item label="注册时间:">
          <el-date-picker
  v-model="user.createTime"
  placeholder="选择日期时间"
  type="datetime"
  disabled
  style='width:100%'>
</el-date-picker>
        </el-form-item>
        <el-form-item label="到期时间:">
          <el-date-picker
          placeholder="选择日期时间"
          v-model="user.amount"
  type="datetime"
  disabled
  style='width:100%'
  >
</el-date-picker>

        </el-form-item>
      </el-form>


</template>
<script>

  export default {
    name: 'xx',
    created: function () {
      this.user=this.getuserDetail();
    },
    data() {
      return {
        styleObject: {
          width: '320px',

        },
        msg: 'Welcome to Your selectmenudirective.js App',
        user:{},
      }
    },
    methods: {
      selCode(){
        // var _self = this;
        // _self.$axios.get('/jykn/findAaa102AndAaa103', {params: {'aaa100': this.aaa100}}).then((response) => {
        //   console.log(response.data);
        //   _self.options=response.data;
        // }).catch(function(err) {
        //   console.info(err);
        //   alert('验证用户信息失败' + err.response.data.errorMsg);
        //   //_self.loadingInstance.close();
        // });
      }
    }
  }
</script>
<style scoped>

</style>
