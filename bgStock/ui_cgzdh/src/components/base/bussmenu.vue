<template>
<div id='menu'>
  <aside class="db-menu-wrapper" id="menuid">
    <el-menu class="db-menu-bar" unique-opened v-bind:router="true">
      <template v-if="menuData.children&&menuData.children.length>0">
         <template v-for="(menu,index) in menuData.children">
           <template v-if="menu.children.length==0">
             <el-menu-item :index="menu.url==null?unauthorized:menu.url" >{{menu.name}}</el-menu-item>
           </template>
           <template v-else>
             <el-submenu :index="menu.name">
               <template slot="title">{{menu.name}}
               </template>
             <el-menu-item :index="submenu.url==null?unauthorized:submenu.url"    v-for="(submenu,ind) in menu.children" v-on:click='doSelectMenu' :menuid='submenu.id'>{{submenu.name}}</el-menu-item>
            </el-submenu>
          </template>
         </template>
       </template>
<template v-else>
  <el-menu-item :index="unauthorized">
  {{title}}</el-menu-item>
</template>
    </el-menu>
  </aside>
</div>
</template>
<script>
export default {
  name: 'menu',
  data() {
    return {
      msg: 'this is menu',
      activeMenu: '',
      title: '请配置子菜单',
      unauthorized: '/base/unauthorized',
      breadcrumbitems: [],
      currentbreadcrumbitems: [],
      dismenu: true
    }
  },
  props: ['menuData'],
  watch: {
    'menuData': function() {
      this.breadcrumbitems.length = 0;
      var rootName = this.menuData.name;
      var tempChildren = this.menuData.children;
      for (var i = 0; i < tempChildren.length; i++) {
        var child = tempChildren[i];
        if (child.url === null) {
          var submenus = child.children;
          for (var index = 0; index < submenus.length; index++) {
            var submenu = submenus[index];
            this.breadcrumbitems.push({
              'url': submenu.url,
              'items': [rootName, child.name, submenu.name]
            });
          }
        } else {
          this.breadcrumbitems.push({
            'url': child.url,
            'breadcrumbitems': [rootName, child.name]
          });
        }
      }
    }
  },
  methods: {
    doSelectMenu(menuItem) {
      var tmpbreadcrumbitems = this.breadcrumbitems.filter(function(item) {
        return item.url === menuItem.index;
      });
      if (tmpbreadcrumbitems.length > 0) {
        this.currentbreadcrumbitems = tmpbreadcrumbitems[0].items;
        this.$root.eventHub.$emit('on_set_breadcrumbitems', this.currentbreadcrumbitems);
        return true;
      } else {
        return false;
      }
    }
  }
}
</script>
<style scoped>

</style>
