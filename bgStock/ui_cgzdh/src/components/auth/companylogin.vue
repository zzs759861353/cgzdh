<template>
<div id='companylogin' >
  <div style="height:90px;line-height:110px;text-align:left;">
    <img src="././images/logo-l.png" class='head_logo' style='margin:5% 0 0 5%'></img>
  </div>
<div class='login-box'>
    <passwordlogin></passwordlogin>
</div>


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
      msg: 'Welcome to Your companylogin.js App'
    }
  },
  components: {
    'passwordlogin': passwordlogin
  }
}
</script>
<style scoped>
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
