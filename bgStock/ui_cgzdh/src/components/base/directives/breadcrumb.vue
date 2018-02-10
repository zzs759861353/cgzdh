<template>
<div id='breadcrumb'>
  <div style='margin:10px'>
    <el-breadcrumb separator="/">
      <el-breadcrumb-item :to="{ path: '/base/welcome' }">首页</el-breadcrumb-item>
      <template v-for="(item,index) in items">
        <el-breadcrumb-item :to="{ path: item.url }" >{{item.name}}</el-breadcrumb-item>
      </template>
    </el-breadcrumb>
  </div>
</div>
</template>
<script>
export default {
  name: 'breadcrumb',
  data() {
    return {
      msg: 'this is breadcrumb'
    }
  },
  props: {
    items: {
      type: Array,
      default: []  // 这样可以指定默认的值
    }
  }
}
</script>




<style scoped></style>
