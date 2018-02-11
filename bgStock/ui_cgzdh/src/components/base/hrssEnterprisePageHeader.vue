<template>
<div id="hrssEnterprisePageHeader">
<div class="topnav"  style="background:#285890; position:absolute;z-index:899; top:0;  height:30px;">
  <div class="userinfo">
    <span class="right_span">欢迎您，{{name}}&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;<span type="text" style='cursor:pointer' @click="doQuit()">退出</span></span>
  </div>
</div>
    <div class="head_info_left"> <!--@click="doHome($event)"-->
      <img src="./images/home/logo-l.png" title="logo_回首页" class='head_logo' @click="onSelectMenu('sy')">
    </div>
</div>
</template>
<script>
export default {
  name: 'hrssEnterprisePageHeader',
  data() {
    return {
      name: ''
    }
  },
  mounted: function () {
    this.name = this.getuserDetail().name;
  },
  methods: {
    onSelectMenu(index) {
      this.$root.eventHub.$emit('on_select_menu', index);
    },
    doHelper: function() {
      this.$router.push('/helper');
    },
    doHome: function() {
      this.$router.push({
        name: 'welcome'
      });
    },
    doQuit: function() {
      var _self=this;
      this.$axios.get('/cgzdh/auth/tuser/layOut').then((response) => {
        _self.clearSession();
        _self.$router.push('/');
      }).catch(function(err) {
        console.info(err);
        alert('注销失败： ' + err.response.data.errorMsg);
      });

    }
  }
}
</script>
<style>
.head_info {
  width: 100%;
  height: auto;
  word-wrap: break-word;
  word-break: normal;
  margin-bottom: 20px;
  overflow: hidden;
}
#hrssEnterprisePageHeader{
  height: 69px !important;
  margin-top: 47px;
}


.head_info_left img {
  cursor: pointer;
  float: left;
  margin-top:6px;
}

  .userinfo{
    float:right;
    width:300px;
    text-align:right;
    position: relative;
    /*margin-top: 6px;*/
  }
.right_span{
  color:#fff;
  font-size:12px;
  display: block;
  top:8px;
  width: 300px;
  height: 14px;
  overflow:hidden;
  line-height: 14px;
  right:38px;
  text-align:right;
  position: absolute;
}
</style>
