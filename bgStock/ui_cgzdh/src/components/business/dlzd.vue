<template>
<div>
  <el-table
  :data="account"
  stripe
  border
  style="font:12px/60px ''">
  <el-table-column
    prop="userName"
    label="账号"
    >
  </el-table-column>
  <el-table-column
    prop="name"
    label="姓名"
    >
  </el-table-column>
  <el-table-column
    prop="money"
    label="金额">
  </el-table-column>
  <el-table-column
    prop="createTime"
    :formatter='timeFormate'
    min-width='170'
    label="支付时间">
  </el-table-column>
</el-table>
  <el-pagination
  background
  layout="prev, pager, next"
  @current-change="handleCurrentChange"
  :total="page.total">
</el-pagination>
</div>
</template>
<script>

  export default {
    name: 'zd',
    mounted: function () {
      this.selAccount();

    },
    data() {
      return {
        msg: 'Welcome to Your selectmenudirective.js App',
        page:{size:10,nowPage:1,total:0},
        account:[]
      }
    },
    methods: {
      handleCurrentChange(val) {
            this.page.nowPage=val;
            this.selAccount();
            },
            timeFormate:function(v){
              return this.getSmpFormatDates(new Date(v.createTime), true);
            },
      selAccount(){
        var _self = this;
        _self.$axios.post('/cgzdh/account/agent/account', {userId:this.getuserDetail().id,size:this.page.size,nowPage:this.page.nowPage}).then((response) => {
          _self.account=response.data.content;
          console.log(response.data)
          _self.page.total=response.data.totalElements;
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
