export default {
  install(Vue, options) {
    Vue.mixin({
      methods: {
        getNewData() {
          console.log('我是插件中的方法');
          return 'getNewData:我是插件中的方法';
        }
      }
    })
  }
}
