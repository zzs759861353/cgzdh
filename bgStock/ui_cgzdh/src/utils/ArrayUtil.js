export default {
  install(Vue, options) {
    Vue.mixin({
      data: function() {
        return {
          ArrayUtil: {
            indexOf: function(array, val) {
              for (var i = 0; i < array.length; i++) {
                if (array[i] === val) return i;
              }
              return -1;
            },
            remove: function(array, val) {
              var index = array.indexOf(val);
              if (index > -1) {
                array.splice(index, 1);
              }
            }

          }
        }
      }
    })
  }
}
