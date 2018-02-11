<template>


<div id='accountregister'>
  <el-row >
    <img src="./images/logo-l.png" style="margin-top:35px"></img>
  </el-row>
  <el-row >

  <div class='divcss5'>

    <el-card class="box-card">

      <div slot="header" class="clearfix">

        <div style="margin-bottom:-10px;margin-top:-10px">
          <span style="line-height: 36px;">用户注册</span>
        </div>
      </div>

        <el-form :inline="true" class="demo-ruleForm" :model="unitRegistDto" :rules="rules" ref="unitRegistDto" label-width="80px" labelPosition='right'>


          <el-form-item  prop="userName">
        <input type="text" v-model="unitRegistDto.userName" class="kuang_txt phone" placeholder="账号">
          </el-form-item>
          <el-form-item  prop="name">
        <input type="text" v-model="unitRegistDto.name" class="kuang_txt names" placeholder="姓名">
          </el-form-item>


              <el-form-item  prop="password">
                <input name="" type="password" v-model="unitRegistDto.password" class="kuang_txt possword" placeholder="密码">

              </el-form-item>


              <el-form-item  prop="confirmpassword">
                <input name="" type="password" v-model="unitRegistDto.confirmpassword" class="kuang_txt possword" placeholder="确认密码">
              </el-form-item>

              <el-form-item >
        <input  type="text" class="kuang_txt yanzm" placeholder="邀请码">
      </el-form-item>

              <el-form-item >
                <el-checkbox >
<span>已阅读并同意<a href="#" target="_blank"><span class="lan">《XXXXX使用协议》</span></a></span>
                </el-checkbox>

      </el-form-item>
          <el-form-item >
        <input name="注册" type="button" @click='addUser' class="btn_zhuce" value="注册">
      </el-form-item>
        </el-form>
    </el-card>

  </div>
</el-row>
</div>
</template>
<script>
export default {
  name: 'accountregister',
  mounted: function() {

  },
  data() {
    return {
      msg: 'Welcome to Your companyregister.js App',
      unitRegistDto: {
      	userName:'',
      	name:'',
      	password:'',
      	recommendId:''
      },
      rules: {
        userName: [{
          required: true,
          message: '请输入账号',
          trigger: 'blur'
        }, {
          validator: (rule, value, callback) => {
            var _self = this;
            _self.$axios.get('/cgzdh/auth/tuser/' + value).then((response) => {
              if (response.data.id !== null) {
                callback(new Error('该账户已经注册，请更换账户名'));
                // callback();
              } else {
                callback();
              }
            }).catch(function(err) {
              if(err.response.data.errorMsg=='此账户尚未注册'){
                  callback();
              }else{
                callback(new Error('检测账户信息失败' + err.response.data.errorMsg));
              }

            });
          },
          trigger: 'blur'
        }],
        name: [{
          required: true,
          message: '请输入姓名',
          trigger: 'blur'
        }],
        password: [{
          required: true,
          message: '请输入密码',
          trigger: 'blur'
        }, {
          min: 6,
          max: 8,
          message: '密码长度在 6 到 8 个字符',
          trigger: 'blur'
        }],
        description: [{
          required: false
        }],
        confirmpassword: [{
          required: true,
          message: '请输入确认密码',
          trigger: 'blur'
        }, {
          min: 6,
          max: 8,
          message: '密码长度在 6 到 8 个字符',
          trigger: 'blur'
        }, {
          validator: (rule, value, callback) => {
            if (value !== this.unitRegistDto.password) {
              callback(new Error('密码与确认密码不一致'));
            } else {
              callback();
            }
          },
          trigger: 'blur'
        }]
      },
      loadingInstance: {},
      confirmpassword: ''
    }
  },
  methods: {
    addUser() {
      var _self = this;
      _self.$refs.unitRegistDto.validate((valid) => {
        if (valid) {
          _self.putUser();
        } else {
          _self.$message({
            showClose: true,
            message: '请录入注册信息',
            type: 'error'
          });
        }
      });
    },
    putUser() {
      var _self = this;
      _self.loadingInstance = _self.$loading({
        fullscreen: true
      });
      _self.loadingInstance.text = '正在注册账户';
      _self.$axios.post('/cgzdh/auth/userRegister', _self.unitRegistDto).then((response) => {
        _self.loadingInstance.close();
        _self.$message({
          showClose: true,
          message: '恭喜您，注册成功！',
          type: 'success'
        });
        _self.$router.push({
          name: 'companylogin'
        });
      }).catch(function(err) {
        alert('注册账户失败，错误信息：' + err.response.data.errorMsg);
        _self.loadingInstance.close();
      });
    }
  }
}
</script>
<style scoped>
body {
  margin-top: 300px;

}

.divcss5 {
  margin-top: 100px;
  margin: 0 auto;
  width:314px;
}
.kuang_txt{ width:236px; height:32px; border:1px solid #dddddd; line-height:32px; padding-left:32px; color:#b1a9a9;  margin-bottom:10px; }
input.el-input__inner {
  margin-top: 5px
}
</style>>
