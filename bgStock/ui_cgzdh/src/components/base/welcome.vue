<template>
<div id='Welcome'>

    <el-row>
      <div v-for="item in items" @click="onSelectMenu(item.url,item.title)">
        <el-col :xs="8" :sm="5" :md="3" :lg="3" :xl="3">
          <div class="clearfix  fs1    cursor-pointer">
            <div class="size1of111 ">
              <img v-bind:src="item.classname" style='width:60px;height:60px'/>
            </div>
            <div class="size1of11">
              <span class="mls" style='white-space:nowrap;font-size:6px'>{{item.title}}</span>
            </div>
          </div>
        </el-col>
      </div>
    </el-row>

</div>
</template>
<script>
export default {
  name: 'Welcome',
  mounted: function() {
    this.changemenu();
  },
  data() {
    return {
      msg: 'hello',
      items: [
      //   {
      //   orderNum: '16',
      //   resourceId: '00000000',
      //   userId: '',
      //   title: '更多业务',
      //   url: '/base/menu/selectmenu',
      //   classname: '/static/style/images/morex.png'
      // }
    ]
    }
  },
  methods: {
    onSelectMenu: function(url, name) {
      this.$root.eventHub.$emit('we_select_menu', [{'name': name, 'url': url}]);
      //this.$router.push(url);
    },
    changemenu: function() {
      this.items = this.getUserMenus().concat(this.items);
    }
  }
}
</script>
<style>

</style>
