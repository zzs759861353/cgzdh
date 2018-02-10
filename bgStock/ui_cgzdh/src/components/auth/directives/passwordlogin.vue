<template >
<div id='passwordlogin'>
  <div class="text item">
    <el-form :inline="true" class="demo-ruleForm" :model="companyloginDto" :rules="rules" ref="companyloginDto" label-width="90px" labelPosition='right'>
      <div >
        <el-form-item label="用户名" prop="account">
          <el-input v-model="companyloginDto.account" placeholder="请输入用户名"></el-input>
        </el-form-item>
      </div>
      <el-form-item label="密码" prop="password">
        <el-input type="password" v-model="companyloginDto.password" placeholder="请输入密码"></el-input>
      </el-form-item>
    </el-form>
    <el-form :inline="true" class="demo-form-inline">
      <el-button type="primary" @click='checkUser'>登录</el-button>
      <el-button type="primary" @click='registerkUser'>注册</el-button>
    </el-form>
  </div>
</div>
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
        account: '49219261-10',
        password: '123456'
      },
      rules: {
        account: [{
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
      _self.loadingInstance = _self.$loading({
        fullscreen: true
      });
      _self.loadingInstance.text = '验证用户信息，请稍等！';
      _self.$axios.post('/auth/api/v0/tuser/check', _self.companyloginDto).then((response) => {
        _self.setToken(response.data);
        _self.loaduser();
      }).catch(function(err) {
        console.info(err);
        alert('验证用户信息失败： ' + err.response.data.errorMsg);
        _self.loadingInstance.close();
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
          alert('登陆失败，错误信息：' + err);
          _self.loadingInstance.close();
        });
    },
    loaduser: function() {
      var _self = this;
      _self.loadingInstance.text = '验证加载用户信息，请稍等！';
      _self.$axios.get('/auth/api/v0/tuser/account/' + this.companyloginDto.account).then((response) => {
        console.log(response.data);
        _self.setuserDetail(response.data);
        _self.userid = response.data.id;
        _self.dologin();
      }).catch(function(err) {
        alert('加载用户信息失败' + err.response.data.errorMsg);
        _self.loadingInstance.close();
      });
    },
    loadMenus: function() {
      return this.$axios.get('/auth/api/v0//tresources');
    }
  }
}
</script>
<style scoped>

</style>
