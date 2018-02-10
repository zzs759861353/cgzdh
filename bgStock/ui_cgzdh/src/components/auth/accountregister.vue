<template>


<div id='accountregister'>
  <el-row style="height:100px">
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
      <div class="text item">
        <el-form :inline="true" class="demo-ruleForm" :model="unitRegistDto" :rules="rules" ref="unitRegistDto" label-width="120px" labelPosition='right'>
          <el-form-item label="帐号" prop="account">
            <el-input v-model="unitRegistDto.account" placeholder="请输入帐号"></el-input>
          </el-form-item>
          <el-form-item label="姓名" prop="name">
            <el-input v-model="unitRegistDto.name" placeholder="请输入姓名"></el-input>
          </el-form-item>
          <el-form-item label="密码" prop="password">
            <el-input type="password" v-model="unitRegistDto.password" placeholder="请输入密码"></el-input>
          </el-form-item>
          <el-form-item label="确认密码" prop="confirmpassword">
            <el-input type="password" v-model="unitRegistDto.confirmpassword" placeholder="请输入确认密码"></el-input>
          </el-form-item>

        </el-form>
        <el-form :inline="true" class="demo-form-inline">
          <el-button type="primary" @click='addUser'>用户注册</el-button>
        </el-form>
      </div>
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
        id: '',
        type: '1',
        account: '',
        activated: '1',
        realNameAuthed: '0',
        idType: '',
        idNumber: '',
        cakey: '',
        email: '',
        accountLockedReason: '',
        mobile: '',
        headimgurl: '',
        name: '',
        password: '',
        confirmpassword: '',
        salt: '',
        description: '',
        orgId: ''
      },
      rules: {
        account: [{
          required: true,
          message: '请输入账号',
          trigger: 'blur'
        }, {
          validator: (rule, value, callback) => {
            var _self = this;
            _self.$axios.get('/auth/api/v0/tuser/account/' + value).then((response) => {
              if (response.data.id !== null) {
                callback(new Error('该账户已经注册，请更换账户名'));
                // callback();
              } else {
                callback();
              }
            }).catch(function(err) {
              callback(new Error('检测账户信息失败' + err));
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
          alert('请录入相关信息！');
        }
      });
    },
    putUser() {
      var _self = this;
      _self.loadingInstance = _self.$loading({
        fullscreen: true
      });
      _self.loadingInstance.text = '正在注册账户';
      _self.$axios.put('/auth/api/v0/tuser', _self.unitRegistDto).then((response) => {
        _self.loadingInstance.close();
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
  width: 700px
}

input.el-input__inner {
  margin-top: 5px
}
</style>>
