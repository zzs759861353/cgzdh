<template >

    <el-form :inline="true" :model="companyloginDto" :rules="rules" ref="companyloginDto"  labelPosition='right'>

        <el-form-item label="" prop="userName">
          <el-input v-model="companyloginDto.userName" size='small' placeholder="请输入用户名"></el-input>
        </el-form-item>

      <el-form-item label="" prop="password">
        <el-input type="password" size='small' v-model="companyloginDto.password" placeholder="请输入密码"></el-input>
      </el-form-item>


      <el-form-item >
      <el-button type="primary" @click='checkUser'>登录</el-button>
      <el-button type="primary" @click='registerkUser'>注册</el-button>
      </el-form-item>

</el-form>

</template>
<script>
export default {
  name: 'passwordlogin',
  data() {
    return {
      msg: 'Welcome to Your passwordlogin.js App',
      loadingInstance: {},
      account_enabled: false,
      styleObject: {
        width: '300px',
        marginTop: '129px'
      },
      companyloginDto: {
        userName: '',
        password: ''
      },
      rules: {
        userName: [{
          required: true,
          message: '请输入用户名',
          trigger: 'blur'
        }],
        password: [{
          required: true,
          message: '请输入密码',
          trigger: 'blur'
        }]
      }
    }
  },
  methods: {
    registerkUser: function(){
      this.$router.push({
        name: 'accountregister'
      });
    },
    checkUser: function() {
      var _self = this;
      _self.$refs.companyloginDto.validate((valid) => {
        if (valid) {
          _self.loadingInstance = _self.$loading({
            fullscreen: true
          });
          _self.loadingInstance.text = '验证用户信息，请稍等！';
          _self.$axios.post('/cgzdh/auth/tuser/check', _self.companyloginDto).then((response) => {
            _self.setToken(response.data);
            _self.loaduser();
          }).catch(function(err) {
            _self.loadingInstance.close();
            _self.$message({
              showClose: true,
              message: err.response.data.errorMsg,
              type: 'error'
            });
          });
        }
      });
    },

    dologin: function() {
      var _self = this;
      _self.loadingInstance.text = '登录系统，请稍等！';
      _self.$axios.all([_self.loadMenus()])
        .then(_self.$axios.spread(function(userMenusResponse) {

          _self.setUserMenus(userMenusResponse.data);
          sessionStorage.setItem('clientId','');
          sessionStorage.setItem('selfzj',[]);
          sessionStorage.setItem('gplist',[]);
          _self.loadingInstance.close();
          _self.$router.push({
            name: 'BaseWelcome'
          });
        })).catch(function(err) {

          _self.loadingInstance.close();
          _self.$message({
            showClose: true,
            message: err.response.data.errorMsg,
            type: 'error'
          });
        });
    },
    loaduser: function() {
      var _self = this;
      _self.loadingInstance.text = '验证加载用户信息，请稍等！';
      _self.$axios.get('/cgzdh/auth/tuser/' + this.companyloginDto.userName).then((response) => {
        var nowtime=new Date().getTime();
if(nowtime>response.data.amount){
        _self.$alert('该会员已到期，为避免耽误您的使用，请登陆后及时续费！', '时间提醒', {
                  confirmButtonText: '确定',
                  type: 'warning'
                });
}else{
  _self.$message({
           message:'会员时长还有'+ _self.formatDuring(response.data.amount-nowtime),
           type: 'success'
         });

}
        _self.setuserDetail(response.data);
        _self.userid = response.data.id;
        _self.dologin();
      }).catch(function(err) {
        _self.$message({
          showClose: true,
          message: err.response.data.errorMsg,
          type: 'error'
        });
        _self.loadingInstance.close();
      });
    },
    loadMenus: function() {
      return this.$axios.get('/cgzdh/auth/tresources');
    }
  }
}
</script>
<style scoped>

</style>
