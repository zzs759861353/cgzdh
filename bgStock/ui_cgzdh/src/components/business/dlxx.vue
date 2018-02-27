<template>

      <el-form  label-width="80px" :model="formLabelAlign" style='max-width:380px'>
        <el-form-item label="帐号:">
          <el-input disabled v-model="user.userName"></el-input>
        </el-form-item>
        <el-form-item label="名称:">
          <el-input disabled v-model="user.name"></el-input>
        </el-form-item>
        <el-form-item label="代理类型:">
          <el-input disabled :value="user.userType==2?'企业代理':'个人代理'"></el-input>
        </el-form-item>
        <el-form-item label="邀请码:">
          <el-input disabled v-model="user.id"></el-input>
        </el-form-item>
        <el-form-item label="总金额:">
          <el-input disabled v-model="agentMoney.zje"></el-input>
        </el-form-item>
        <el-form-item label="本月金额:">
          <el-input disabled v-model="agentMoney.mje"></el-input>
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
      </el-form>


</template>
<script>

  export default {
    name: 'xx',
    created: function () {
      this.user=this.getuserDetail();
      this.getMoney();
    },
    data() {
      return {
        styleObject: {
          width: '320px',

        },
        msg: 'Welcome to Your selectmenudirective.js App',
        user:{},
        agentMoney:{},
      }
    },
    methods: {
      getMoney(){
        var _self = this;
        _self.$axios.post('/cgzdh/account/agent/money', {userId:this.getuserDetail().id}).then((response) => {
          _self.agentMoney=response.data;
          _self.agentMoney.zje=_self.agentMoney.zje+'元';
          _self.agentMoney.mje=_self.agentMoney.mje+'元';
        }).catch(function(err) {
          console.info(err);
          alert('验证用户信息失败' + err.response.data.errorMsg);
          //_self.loadingInstance.close();
        });
      }
    }
  }
</script>
<style scoped>

</style>
