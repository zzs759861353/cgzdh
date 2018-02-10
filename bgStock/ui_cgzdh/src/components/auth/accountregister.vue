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



        <el-form :inline="true" class="demo-ruleForm" :model="unitRegistDto" :rules="rules" ref="unitRegistDto" label-width="80px" labelPosition='right'>
          <el-row>
            <el-col >
          <el-form-item label="帐号" prop="userName">
            <el-input v-model="unitRegistDto.userName" placeholder="请输入帐号"></el-input>
          </el-form-item>
        </el-col>
              </el-row>
              <!-- <el-row>
        <el-col >
          <el-form-item label="姓名" prop="name">
            <el-input v-model="unitRegistDto.name" placeholder="请输入姓名"></el-input>
          </el-form-item>
        </el-col>
              </el-row> -->
              <el-row>
        <el-col >
          <el-form-item label="密码" prop="password">
            <el-input type="password" v-model="unitRegistDto.password" placeholder="请输入密码"></el-input>
          </el-form-item>
        </el-col>
              </el-row>
              <el-row>
        <el-col >
          <el-form-item label="确认密码" prop="confirmpassword">
            <el-input type="password" v-model="unitRegistDto.confirmpassword" placeholder="请输入确认密码"></el-input>
          </el-form-item>
        </el-col>
              </el-row>
              <el-row>
              <el-col >
                <el-form-item label="" prop="confirmpassword">
                  <el-button type="primary" @click='addUser'>用户注册</el-button>
                </el-form-item>
              </el-col>
                    </el-row>
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
        id: '',
        userName: '',
      	password: '',
      	account_locked_reason: '',
      	status: 1,
      	head_img_url: '',
      	id_number: '',
      	id_type: 0,
      	mobile: '',
      	org_id: 0,
      	salt: ''
      	// update_time: '',
      	// create_time: '',
      	// last_active_date: ''

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
      _self.$axios.put('/cgzdh/auth/tuser', _self.unitRegistDto).then((response) => {
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
  width:360px;
}

input.el-input__inner {
  margin-top: 5px
}
</style>>
