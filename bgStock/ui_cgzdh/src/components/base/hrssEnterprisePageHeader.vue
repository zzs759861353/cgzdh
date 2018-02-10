<template>
<div id="hrssEnterprisePageHeader">
<div class="topnav"  style="background:#285890; position:absolute;z-index:899; top:0;  height:30px;">
  <div class="userinfo">
    <span class="right_span">欢迎您，{{aab004}}</span>
    <el-button type="text" @click="doQuit()" style="color:#fff;font-size:12px;">退出</el-button>
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
      aab004: ''
    }
  },
  mounted: function () {
    this.aab004 = this.getuserDetail().name;
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
      this.$axios.get('/auth/api/v0/tuser/layOut').then((response) => {
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
  padding-right:12px;
  text-align:right;
  border-right:1px solid #fafafa;
  position: absolute;
}



</style>
