<template>
  <div class="home">

<div id="home" >
  <div class="topdiv" id="topdiv">
  </div>

  <hrss-enterprise-page-header style='height:57px'></hrss-enterprise-page-header>
  <div style="opacity:0.9;heigh:auto;width:100%;overflow:auto;overflow-x:hidden; margin-top:2%;border-radius:12px;">
    <div style="width:100%;float:left; background: #fff;   min-height:520px; border-left: 1px solid #ddd; padding:4%;">
        <router-view></router-view>
  	</div>
  </div>
</div>
</div>
</template>
<script>

import breadcrumb from '@/components/base/directives/breadcrumb.vue'
import hrssEnterprisePageHeader from '@/components/base/hrssEnterprisePageHeader.vue'
import welcome from '@/components/base/welcome.vue'
import bussmenu from '@/components/base/bussmenu.vue'
export default {
  name: 'Home',
  // created
  mounted: function() {

  },
  created: function() {
    this.$root.eventHub.$on('on_select_menu', this.onSelectMenu);
    this.$root.eventHub.$on('we_select_menu', this.onSelectMenu);

    var h = screen.height;
  },
  // It's good to clean up event listeners before
  // a component is destroyed.
  beforeDestroy: function() {
    this.$root.eventHub.$off('on_select_menu', this.onSelectMenu);

  },
  data() {
    return {
      nomenu: '请配置子菜单',
      msg: 'hello',
      styleObject: {
        height: '200px'
      },
      activeMenu: '',
      defaultProps: {
        children: 'children',
        label: 'label'
      },
      uniqueOpened: true,
      index: '',
      breadcrumbitem: []

    }
  },
  methods: {
    onSelectMenu: function(code) {
      switch (code){
        case 'sy':this.breadcrumbitem = this.sy;this.$router.push('/base/welcome/');break;
        default:this.breadcrumbitem = code;
          this.$router.push(code[0].url);
      }
    }
  },
  components: {
    'hrssEnterprisePageHeader': hrssEnterprisePageHeader,
    'bussmenu': bussmenu,
    'breadcrumb': breadcrumb
  }
}
</script>
<style scoped>
.row {
  margin: 0px;
}

.max {
  height: 100%;
  width: 100%;
}

.companyclss {
  float: left;
  width: 100%
}
.updateclss {
  float: left;
  width: 45%
}

.quickclss .serviceclss {
  float: left;
  width: 90%;
  margin-left: 60px;
}

.serviceclss {
  float: left;
  width: 90%;
  margin-left: 60px;
}

.topdiv{
  background:#285890;
  width: 100%;
  height: 30px;
  position: absolute;
  top:0;
  left: 0;
}

</style>
