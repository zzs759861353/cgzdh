<template>

<div id="app" >
<!--
  <el-row style='float:right'>
    <router-link to="/helper">
      <el-button :plain="true" type="primary">帮助</el-button>
    </router-link>

    <router-link to="/register">
      <el-button :plain="true" type="primary">注册</el-button>
    </router-link>

    <router-link to="/login">
      <el-button :plain="true" type="primary">登录</el-button>
    </router-link>
  </el-row>
    <div class="clear" ></div>
-->


    <router-view></router-view>
    <div style='color:#fffaa0'>
      Copyright 2017-2027 boge1688.com, All Rights Reserved<br />
      深圳市搏格教育咨询有限公司  版权所有   粤ICP备17069684号
    </div>

</div>
</template>
<script>
function window.onunload(){
  　　　　　　　　　　　　if((window.screenLeft>=10000 && window.screenTop>=10000)||event.altKey)
  　　　　　　　　　　　　{
      　　　　　　　　　　　　  //清除当前session,使用jquery 提供的方法　　

　　　　　　　　　　　　　　　　　　　　$.post("${base}/ClearSession.wp");

　　　　　　　　　　　　　　// [ ${base}/ClearSession.wp ]这是一个请求，

　　　　　　　　　　　　　　//请求到自己写的ClearSessionServlet

　　　　　　　　　　        // 在此ClearSessionServlet中重写doPost方法，
　　　　　　　　　　　　　 // 内容为 request.getSession().invalidate()

　　　　　　　　　　　　　　}
</script>
<script>
export default {
  name: 'app',
  data() {
    return {}
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
</style>
