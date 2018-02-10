<template>
<div id='unauthorized'>
  <div>{{msg}}</div>
</div>
</template>
<script>
export default {
  name: 'unauthorized',
  data() {
    return {
      msg: '您没有权限访问此模块'
    }
  }
}
</script>
<style>

</style>
