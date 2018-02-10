export default {
  install(Vue, options) {
    Vue.mixin({
      data: function () {
        return {
          JsonUtil: {
            extend: function (des, src, override) {
              if (src instanceof Array) {
                for (var i = 0, len = src.length; i < len; i++){
                  this.extend(des, src[i], override);
                }
              }
              for (var ind in src) {
                if (override || !(ind in des)) {
                  des[ind] = src[ind];
                }
              }
              return des;
            }
          }
        }
      }
    })
  }
}
