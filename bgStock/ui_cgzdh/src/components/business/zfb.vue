<template >
<div v-html='content'>

</div>


</template>
<script>

  export default {
    name: 'zfb',
  created(){
    var _self=this;
    _self.$axios.post('/cgzdh/ali/pay', JSON.parse(this.$route.params.ac)).then((response) => {
      if(response.data.object!=null){
_self.content=response.data.object;

        var  w=window.open('about:blank');
          w.document.write(_self.content);
          w.document.close();
          w.print();
      }
      // if(response.data!=null){
      //   _self.$alert('恭喜您，为会员续费成功！到期时间延长至'+_self.getSmpFormatDates(new Date(response.data.amount)), '充值成功', {
      //             confirmButtonText: '确定',
      //             type: 'success'
      //           });
      //   _self.setuserDetail(response.data);
      // }

    }).catch(function(err) {
      console.info(err);
      alert('验证用户信息失败');
      //_self.loadingInstance.close();
    });
  },
    data() {
      return {
        content:'',
        msg: 'Welcome to Your selectmenudirective.js App'

      }
    },
    methods: {

    }
  }
</script>
<style scoped>

</style>
