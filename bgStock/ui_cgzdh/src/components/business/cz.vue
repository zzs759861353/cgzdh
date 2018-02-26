<template>
  <div>
      <el-form :model="accountDetail"  label-width="100px" :rules="rules" ref="czForm" style='max-width:300px'>
        <el-form-item label="帐号:">
          <el-input disabled v-model="accountDetail.userName"></el-input>
        </el-form-item>
        <el-form-item label="名称:">
          <el-input disabled v-model="accountDetail.name"></el-input>
        </el-form-item>
        <el-form-item label="购买时长:" prop="czxx">
          <el-select v-model="accountDetail.czxx"  placeholder="请选择">
            <el-option
              v-for="item in options"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="购买信息:">
          <el-input disabled v-model="accountDetail.czxx">元</el-input>
        </el-form-item>
        <el-form-item label="支付渠道:" prop="radio">
          <el-radio-group v-model="accountDetail.radio">
             <el-radio label="支付宝"></el-radio>
             <el-radio label="微信"></el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item style='text-align:right'>
          <el-button type='primary' @click='pay'>充值</el-button>
        </el-form-item>
      </el-form>
      </div>
</template>
<script>

  export default {
    name: 'xx',
    created: function () {
      var user=this.getuserDetail();
      this.accountDetail.userName=user.userName;
      this.accountDetail.name=user.name;
      this.accountDetail.userId=user.id;
      this.accountDetail.orgId=user.orgId;
      this.accountDetail.userName=user.userName;
    },
    data() {
      return {
        styleObject: {
          width: '320px',

        },
        zf:'',
        loadingInstance: {},
        dialogVisible: false,
        radio: '',
        options: [{
          value: '0.01元,1个月',
          label: '一个月'
        }, {
          value: '500元,6个月',
          label: '六个月'
        }, {
          value: '900元,12个月',
          label: '12个月'
        }],
        czxx:'',
        msg: 'Welcome to Your selectmenudirective.js App',
        accountDetail:{},
        rules: {
            czxx: [
              { required: true, message: '请选择活动区域', trigger: 'change' }
            ],
            radio: [
              { required: true, message: '请选择活动资源', trigger: 'change' }
            ]
          }
      }

    },
    methods: {
      pay:function(){
        var _self = this;
        _self.$refs.czForm.validate((valid) => {
          if (valid) {
            _self.loadingInstance = _self.$loading({
              fullscreen: true
            });
              _self.loadingInstance.text = '正在生成订单信息，请稍等！';
        this.accountDetail.monthCount=parseInt(this.accountDetail.czxx.split(',')[1]);
        this.accountDetail.money=parseFloat(this.accountDetail.czxx.split(',')[0]);
        if(this.accountDetail.radio=='支付宝'){
        _self.$axios.post('/cgzdh/ali/pay', this.accountDetail).then((response) => {
          if(response.data.object!=null){
            var  w=window.open('about:blank');
              w.document.write(response.data.object);
              w.document.close();
         }
          _self.loadingInstance.close();
          // if(response.data!=null){
          //   _self.$alert('恭喜您，为会员续费成功！到期时间延长至'+_self.getSmpFormatDates(new Date(response.data.amount)), '充值成功', {
          //             confirmButtonText: '确定',
          //             type: 'success'
          //           });
          //   _self.setuserDetail(response.data);
          // }

        }).catch(function(err) {
          console.info(err);
           _self.loadingInstance.close();
          alert('验证用户信息失败');
          //_self.loadingInstance.close();
        });
      }
      }
    });
      }

    }
  }
</script>
<style scoped>

</style>
