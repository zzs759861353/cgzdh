export default {
  install(Vue, options) {
    Vue.mixin({
      data: function() {
        return {
          StringUtil: {

            // 去掉字符两端的空白字符
            Trim: function(_str) {
              return _str.replace(/(^[/t/n/r]*)|([/t/n/r]*$)/g, '');
            },

            // 去掉字符左边的空白字符
            LTrim: function(_str) {
              return _str.replace(/^[/t/n/r]/g, '');
            },

            // 去掉字符右边的空白字符
            RTrim: function(_str) {
              return _str.replace(/[/t/n/r]*$/g, '');
            },

            startWith: function(_str, _startStr) {
              return _str.indexOf(_startStr) === 0;
            },

            endWith: function(_str, _endStr) {
              return _str.lastIndexOf(_endStr) === _str.length - _endStr.length;
            },

            getName: function(_str) {
              return _str;
            }
          }
        }
      }
    })
  }
}
