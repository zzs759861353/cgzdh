export default {
  install(Vue, options) {
    Vue.mixin({
      methods: {
        formatAac058: function(row, column) {
          return this.getCodeValue('AAC058', row.aac058);
        },
        formatAac004: function(row, column) {
          return this.getCodeValue('AAC004', row.aac004);
        },
        formatAac005: function(row, column) {
          return this.getCodeValue('AAC005', row.aac005);
        },
        formatAae140: function(row, column) {
          return this.getCodeValue('AAE140', row.aae140);
        },
        tocamelCase: function(s) {
          var re = /\/(\w)/g;
          return s.replace(re, function($0, $1) {
            return $1.toUpperCase();
          });
        },
        querypagedata: function() {
          var _self = this;
          var oldUrl = _self.pagedata.url;
          var url = oldUrl + '?pageNumber=' + _self.pagedata.number + '&pageSize=' + _self.pagedata.size;
          _self.loadingInstance.text = '正在加载数据，请稍等！';
          _self.$axios.get(url).then((response) => {
            _self.pagedata = response.data;
            _self.pagedata.url = oldUrl;
            _self.pagedata.number = _self.pagedata.number + 1;
            // console.info(_self.pagedata);
          }).catch(function(err) {
            alert('加载数据失败，错误信息：' + err.response.data.errorMsg);
            _self.loadingInstance.close();
          });
        },
        handleCurrentChange: function(value) {
          var _self = this;
          _self.pagedata.number = value;
          _self.querypagedata();
        },
        handleSizeChange: function(value) {
          var _self = this;
          _self.pagedata.number = 1;
          _self.pagedata.size = value;
          _self.querypagedata();
        },
        formatCodeList: function(row, column, cellValue) {
          return this.getCodeValue(column.property.toUpperCase(), cellValue);
        }
      }
    })
  }
}
