<template >

    <el-row >
      <el-col :xs="22" :sm="12" :md="12" :lg="12" class="bj_bai">
        <p class='tatleP'>登录</p>
            <el-form :inline="true" :model="companyloginDto" :rules="rules" ref="companyloginDto"  labelPosition='right'>
              <el-form-item label="" prop="userName" style='margin-top:-16px'>
                <input name="" type="text"  v-model="companyloginDto.userName" class="kuang_txt" placeholder="账号">
              </el-form-item>
              <el-form-item label="" prop="password">
                <input name="" type="password"  v-model="companyloginDto.password"  class="kuang_txt" placeholder="密码">
              </el-form-item>

              <el-form-item label="" prop="">
            <input name="登录" type="button" class="btn_zhuce" @click='checkUser' value="登录">            </el-form-item>


            </el-form>
        </el-col>
      <el-col :xs="22" :sm="12" :md="12" :lg="12" class="bj_right">
          <p>立即注册，加入我们</p>
            <span @click='registerkUser' class="zhuce_qq">个人注册</span>
            <span @click="agentRegister" class="zhuce_wx">代理注册</span>

              <!-- <span href="#" style='font-size:14px;color:#a0a0a0'>忘记密码？</span> -->
<span style='font-size:13px;color:#b0b0b0'>
  客服联系方式：<br />QQ:3190229319
</span>
        </el-col>
        </el-row>
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
    agentRegister:function(){
      this.$router.push({
        name: 'agentRegister'
      });
    },
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
      var available=0;
      switch (this.getuserDetail().userType) {
        case 1:
          available=1
          break;
          case 2:
            available=2
            break;
            case 3:
              available=2
              break;


      }
      _self.$axios.all([_self.loadMenus(available),_self.findBroker()])
        .then(_self.$axios.spread(function(userMenusResponse,findBrokerResponse) {
          _self.setBroker(findBrokerResponse.data);
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
        if(response.data.userType==1){
          _self.$axios.get('/cgzdh/auth/getTime').then((res) => {
            var nowtime=res.data;
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
              message: '获取时间失败',
              type: 'error'
            });
            _self.loadingInstance.close();
          });
        }else{
          if(response.data.status==1){
              _self.loadingInstance.close();
            _self.$message({
                     message:'该代理账户尚未审核，请联系管理员',
                     type: 'error'
                   });
          }else if(response.data.status==2){
              _self.loadingInstance.close();
            _self.$message({
                     message:'该账户尚未交付代理费用',
                     type: 'error'
                   });
          }else{
            _self.setuserDetail(response.data);
            _self.userid = response.data.id;
            _self.dologin();
          }

        }
      }).catch(function(err) {
        _self.$message({
          showClose: true,
          message: err.response.data.errorMsg,
          type: 'error'
        });
        _self.loadingInstance.close();
      });

    },
    loadMenus: function(available) {
      return this.$axios.get('/cgzdh/auth/tresources',{params:{available}});
    },
    findBroker: function() {
      return this.$axios.get('/cgzdh/auth/findBroker');
    }
  }
}
</script>
<style scoped>
.el-col{border-radius: 0px;}
</style>
