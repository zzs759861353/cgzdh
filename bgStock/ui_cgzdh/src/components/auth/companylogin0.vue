<template>
<div id='companylogin' >
  <div style="height:90px;line-height:110px;text-align:left;">
    <img src="././images/logo-l.png" class='head_logo' style='margin:5% 0 0 5%'></img>
  </div>
  <el-row class='logincss'>
    <el-col>
      <el-tabs type="border-card" class='login-box' v-bind:style="styleObject">
        <el-tab-pane label="账户登录">
          <passwordlogin></passwordlogin>
        </el-tab-pane>
      </el-tabs>
    </el-col>
  </el-row>
</div>
</template>
<script>
import passwordlogin from '@/components/auth/directives/passwordlogin.vue'
export default {
  name: 'companylogin',
  created: function() {

  },
  mounted: function() {
    this.clearSession();
  },
  data() {
    return {
      msg: 'Welcome to Your companylogin.js App',
      styleObject: {
        width: '300px',
        height:"240px"

      }
    }
  },
  components: {
    'passwordlogin': passwordlogin
  }
}
</script>
<style scoped>
body {
  text-align: center;
  background: red !Important;
}

.bodycss {
  margin-top: 0px;
  margin-right: 0px;
  margin-bottom: 0px;
  margin-left: 0px;
  /*background-color:blue;*/
  overflow-y: hidden;
}

.divcss5 {
  margin: 0 auto;
  margin-top: 100px;
  width: 400px;
}

input.el-input__inner {
  margin-top: 5px
}
</style>
