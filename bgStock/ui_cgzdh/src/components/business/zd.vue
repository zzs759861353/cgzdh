<template>

</template>
<script>

  export default {
    name: 'zd',
    mounted: function () {
      this.selCode();

    },
    data() {
      return {
        msg: 'Welcome to Your selectmenudirective.js App',
        options:[],
      }
    },
    props: {
      value:'',
      aaa100:'',
      ky:''
    },
    methods: {
      changeData(event){
        this.$emit("input", event);
      },
      selCode(){
        var _self = this;
        _self.$axios.get('/jykn/findAaa102AndAaa103', {params: {'aaa100': this.aaa100}}).then((response) => {
          console.log(response.data);
          _self.options=response.data;
        }).catch(function(err) {
          console.info(err);
          alert('验证用户信息失败' + err.response.data.errorMsg);
          //_self.loadingInstance.close();
        });
      }
    }
  }
</script>
<style scoped>

</style>
