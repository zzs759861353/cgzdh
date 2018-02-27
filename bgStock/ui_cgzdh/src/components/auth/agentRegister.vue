<template>
<div id='accountregister'>
  <img :src='hhh'/>
  <div style="text-align:left;">
<img src="./images/logo-l.png" class='head_logo' @click='goLogin' style='margin:5% 0 2% 5%;cursor:pointer'></img>
  </div>



  <el-row >

  <div class='divcss5'>

    <el-card class="box-card">
  <el-tabs v-model="activeName2" type="card" >
  <el-tab-pane label="个人代理" name="first">
          <el-form :inline="true" class="demo-ruleForm" :model="unitRegistDto" :rules="rules" ref="unitRegistDto" label-width="80px" labelPosition='right'>
            <el-form-item  prop="userName">
          <input type="text" v-model="unitRegistDto.userName" class="kuang_txt phone" placeholder="账号">
            </el-form-item>
            <el-form-item  prop="name">
          <input type="text" v-model="unitRegistDto.name" class="kuang_txt names" placeholder="姓名">
            </el-form-item>
            <el-form-item >
              <input  type="text" class="kuang_txt yanzm" v-model="unitRegistDto.idNumber" placeholder="身份证号">
            </el-form-item>
            <el-form-item >
              <input  type="text" class="kuang_txt yanzm" v-model="unitRegistDto.mobile" placeholder="手机号">
            </el-form-item>
                <el-form-item  prop="password">
                  <input name="" type="password" v-model="unitRegistDto.password" class="kuang_txt possword" placeholder="密码">

                </el-form-item>
                <el-form-item  prop="confirmpassword">
                  <input name="" type="password" v-model="unitRegistDto.confirmpassword" class="kuang_txt possword" placeholder="确认密码">
                </el-form-item>

                <el-form-item>

                    <el-checkbox v-model='xy'style='float:left'>
                    </el-checkbox>
    <span style='margin-left:10px;font-size:12px'>已阅读并同意<a @click="dialogVisible = true" target="_blank"><span class="lan">《搏格量化大师使用协议》</span></a></span>
    <el-dialog title="搏格量化大师注册及软件产品许可使用协议" :visible.sync="dialogVisible" center style='min-width:800px;text-align:center;padding:0;margin:0'>
      <div id='div'  style='text-align:left;padding:0 40px;font-size:12px'>
    <h3>软件代理授权合同</h3>
    <h4>特别提醒：</h4>
  本合同由乙方（又称“贵公司”、“您”）和深圳市搏格教育咨询有限公司（又称“甲方”）<p>于{{nowtime.getFullYear()}}年{{nowtime.getMonth()+1}}月{{nowtime.getDate()}}日,共同签署，</p>
  本协议适用乙方代理甲方软件（搏格量化大师），线上线下的全部活动。双方均认可该软件协议的法律效力。为保障乙方的合法权益，在确定签署之前，请乙方务必仔细阅读合同所有条款，特别是以粗体标注的条款。请乙方在确认前务必咨询确认核对，如有任何异议，请立即停止后续确认签署行为并即时与客服联系。
  本合同以数据电文形式订立，一旦乙方确认本合同，即意味着乙方已充分理解本同，即意味着乙方已充分理解本合同所有条款的含义及相应的法律后果，同意受约束。
  <p>甲方：深圳市搏格教育咨询有限公司</p>
  <p>乙方（贵公司）：{{unitRegistDto.name}}</p>
  <p>身份证号：{{unitRegistDto.idNumber}}</p>
  <p>手机号：{{unitRegistDto.mobile}}</p>
  本着诚实信用、互惠互利的原则，经双方友好协商，并根据中华人民共和国法律、法规，在平等互利的基础上签署本经销协议。
  <h4>第一条，产品、要求及期限：</h4>
  <p>1．乙方为甲方产品《_搏格量化大师软件》的代理商。</p>
  <p>2．乙方代理甲方提供的《搏格量化大师软件》，并从事产品的售后服务和宣传促销等合法商业活动。</p>
  <p>3．乙方为甲方代理产品的期限为：</p>
  <p>自{{nowtime.getFullYear()}}年{{nowtime.getMonth()+1}}月{{nowtime.getDate()}}日起</p>
  <p>至{{nowtime.getFullYear()+1}}年{{nowtime.getMonth()+1}}月{{nowtime.getDate()}}日止。</p> 　　
  <h4>第二条，合作方式：</h4>
  <p>1．乙方为甲方的搏格量化大师代理商，具备软件的销售权和营销权，但乙方不能对甲方的软件进行反编译或进行软件破解，任何违反国家知识产权法的行为甲方将追究法律责任。</p>
  <p>2、甲方为乙方提供独立的管理界面，具备独立的客户注册链接。</p>
  <p>3、甲乙双方的任何一方对另一方的商业行为和法律行为及经营损失不承担责任。<p>
  <h4>第三条，甲方的责任，权利和义务</h4>
  <p>1、甲方为乙方提供销售所需的技术资料及宣传资料。</p>
  <p>2、指导协调乙方的销售行为，最大限度地占领市场。</p>
  <p>3、负责产品的市场推广及销售策划工作，积极配合乙方做好市场宣传活动。</p>
  <p>4、如果甲方调整代理产品市场零售价格，甲方将给予乙方价格保护。</p>
  <p>5、代理产品的价格制定权，发布权在甲方，甲乙双方均有保守价格的责任。</p>
  <h4>第四条，乙方的责任、权利和义务</h4>
  <p>1、乙方保证严格尊重产品版权及商标权，保证不以任何方式重做、复制、拷贝或泄露、传播、散布所代理产品及序列号，保证不以任何方式对所代理产品进行解剖、汇编、反汇编。</p>
  <p>2、乙方不得销售代理产品的非法渠道版本，否则一经发现将撤消其代理资格，并扣除所有返利作为罚金。甲方保留追究其法律责任的权利</p>
  <h4>第五条，结算：</h4>
  <p>1．甲方按照乙方税后销售额等级进行支付乙方收益。</p>
  <p>支付比例如下：</p>
  <p>乙方月销售额＜50万元，则收益为税销售额 50%</p>
  <p>50万元＜乙方月销售额 <100万元，则收益比例为税后销售额60%</p>
  <p>乙方月销售额＞100万元，则收益比例为税后销售额65%</p>
  <p>2、甲方于每月1号，支付上个月收益于乙方</p>  　　
  <h4>第六条，售后服务：</h4>
  1．甲方为《搏格量化大师软件》提供使用期内免费升级和网上支持  　　
  <h4>第七条，合同的变更和终止：</h4>
  <p>1．经双方协商一致，可另行签订补充条款，对本合同进行修改。</p>
  <p>2．未经甲方书面同意，乙方不得将本合同中任何权利转让第三方。</p>
  <p>3．本合同所定的销售期满，本合同即予终止。乙方如要续约，须于合同期满前30天内  向甲方提出申请，经甲方同意后，双方另签合同；若未于该期限内提出续约申请，则依本合同期限规定终止本合同。<p>
  <h4>第八条</h4>
  <p>1、本协议的签订、履行、终止、解释均适用中华人民共合国法律。</p>
  <p>2、本协议在履行过程中，如果发生任何争执或纠纷，双方应友好协商解决；若协商不成，任何一方均有权向甲方所在地的人民法院提起诉讼。</p>　　
  <h4>第九条，其他：</h4>
  <p>1、各方可以书面协议方式对本协议作出修改和补充。经过各方协议签署的有关本协议的修改协议和补充协议是本协议的组成部分，具有与本协议同等的法律效力。</p>
  <p>2、本协议可以一份或者多份并且每一份具有同等的法律效力，并永远保存在甲方为此设立的专用服务器上备查和保管。</p>
  <h3>合同签署</h3>
  <p>甲方：深圳市搏格教育咨询有限公司，于{{nowtime.getFullYear()}}年{{nowtime.getMonth()+1}}月{{nowtime.getDate()}}日，签署本合同。</p>
  <p>乙方：{{unitRegistDto.name}}，身份证号：{{unitRegistDto.idNumber}}，于{{nowtime.getFullYear()}}年{{nowtime.getMonth()+1}}月{{nowtime.getDate()}}日，签署本合同</p>
  </div>
        <el-button type="primary" style='float:right;margin:40px 0' @click="cutDiv">确 定</el-button>
    </el-dialog>


        </el-form-item>
            <el-form-item >
          <input name="返回" type="button" @click='goLogin' class="btn_zhuce" value="返回"><input name="注册" type="button" @click='addUser(1)' style='margin-left:10px' class="btn_zhuce" value="注册">
        </el-form-item>
          </el-form>


  </el-tab-pane>
  <el-tab-pane label="企业代理" name="second">





          <el-form :inline="true" class="demo-ruleForm" :model="unitRegistDto" :rules="rules" ref="unitRegistDto" label-width="80px" labelPosition='right'>


            <el-form-item  prop="userName">
          <input type="text" v-model="unitRegistDto.userName" class="kuang_txt phone" placeholder="账号">
            </el-form-item>
            <el-form-item  prop="name">
          <input type="text" v-model="unitRegistDto.name" class="kuang_txt names" placeholder="企业名称">
            </el-form-item>
                <el-form-item  prop="password">
                  <input name="" type="password" v-model="unitRegistDto.password" class="kuang_txt possword" placeholder="密码">

                </el-form-item>


                <el-form-item  prop="confirmpassword">
                  <input name="" type="password" v-model="unitRegistDto.confirmpassword" class="kuang_txt possword" placeholder="确认密码">
                </el-form-item>

                <el-form-item >
          <input  type="text" class="kuang_txt yanzm" placeholder="邀请码">
        </el-form-item>

                <el-form-item>

                    <el-checkbox v-model='xy'style='float:left'>
                    </el-checkbox>
    <span style='margin-left:10px;font-size:12px'>已阅读并同意<a @click="dialogVisible = true" target="_blank"><span class="lan">《搏格量化大师代理协议》</span></a></span>
    <el-dialog title="" :visible.sync="dialogVisible" center style='min-width:800px;text-align:center;padding:0;margin:0'>

    <div id='div'  style='text-align:left;padding:0 40px;font-size:12px'>
  <h3>软件代理授权合同</h3>
  <h4>特别提醒：</h4>
本合同由乙方（又称“贵公司”、“您”）和深圳市搏格教育咨询有限公司（又称“甲方”）<p>于{{nowtime.getFullYear()}}年{{nowtime.getMonth()+1}}月{{nowtime.getDate()}}日,共同签署，</p>
本协议适用乙方代理甲方软件（搏格量化大师），线上线下的全部活动。双方均认可该软件协议的法律效力。为保障乙方的合法权益，在确定签署之前，请乙方务必仔细阅读合同所有条款，特别是以粗体标注的条款。请乙方在确认前务必咨询确认核对，如有任何异议，请立即停止后续确认签署行为并即时与客服联系。
本合同以数据电文形式订立，一旦乙方确认本合同，即意味着乙方已充分理解本同，即意味着乙方已充分理解本合同所有条款的含义及相应的法律后果，同意受约束。
<p>甲方：深圳市搏格教育咨询有限公司</p>
<p>乙方（贵公司）：{{unitRegistDto.name}}</p>
本着诚实信用、互惠互利的原则，经双方友好协商，并根据中华人民共和国法律、法规，在平等互利的基础上签署本经销协议。
<h4>第一条，产品、要求及期限：</h4>
<p>1．乙方为甲方产品《_搏格量化大师软件》的代理商。</p>
<p>2．乙方代理甲方提供的《搏格量化大师软件》，并从事产品的售后服务和宣传促销等合法商业活动。</p>
<p>3．乙方为甲方代理产品的期限为：</p>
<p>自{{nowtime.getFullYear()}}年{{nowtime.getMonth()+1}}月{{nowtime.getDate()}}日起</p>
<p>至{{nowtime.getFullYear()+1}}年{{nowtime.getMonth()+1}}月{{nowtime.getDate()}}日止。</p> 　　
<h4>第二条，合作方式：</h4>
<p>1．乙方为甲方的搏格量化大师代理商，具备软件的销售权和营销权，但乙方不能对甲方的软件进行反编译或进行软件破解，任何违反国家知识产权法的行为甲方将追究法律责任。</p>
<p>2、甲方为乙方提供独立的管理界面，具备独立的客户注册链接。</p>
<p>3、甲乙双方的任何一方对另一方的商业行为和法律行为及经营损失不承担责任。<p>
<h4>第三条，甲方的责任，权利和义务</h4>
<p>1、甲方为乙方提供销售所需的技术资料及宣传资料。</p>
<p>2、指导协调乙方的销售行为，最大限度地占领市场。</p>
<p>3、负责产品的市场推广及销售策划工作，积极配合乙方做好市场宣传活动。</p>
<p>4、如果甲方调整代理产品市场零售价格，甲方将给予乙方价格保护。</p>
<p>5、代理产品的价格制定权，发布权在甲方，甲乙双方均有保守价格的责任。</p>
<h4>第四条，乙方的责任、权利和义务</h4>
<p>1、乙方保证严格尊重产品版权及商标权，保证不以任何方式重做、复制、拷贝或泄露、传播、散布所代理产品及序列号，保证不以任何方式对所代理产品进行解剖、汇编、反汇编。</p>
<p>2、乙方不得销售代理产品的非法渠道版本，否则一经发现将撤消其代理资格，并扣除所有返利作为罚金。甲方保留追究其法律责任的权利</p>
<h4>第五条，结算：</h4>
<p>1．甲方按照乙方税后销售额等级进行支付乙方收益。</p>
<p>支付比例如下：</p>
<p>乙方月销售额＜50万元，则收益为税销售额 50%</p>
<p>50万元＜乙方月销售额 <100万元，则收益比例为税后销售额60%</p>
<p>乙方月销售额＞100万元，则收益比例为税后销售额65%</p>
<p>2、甲方于每月1号，支付上个月收益于乙方</p>  　　
<h4>第六条，售后服务：</h4>
1．甲方为《搏格量化大师软件》提供使用期内免费升级和网上支持  　　
<h4>第七条，合同的变更和终止：</h4>
<p>1．经双方协商一致，可另行签订补充条款，对本合同进行修改。</p>
<p>2．未经甲方书面同意，乙方不得将本合同中任何权利转让第三方。</p>
<p>3．本合同所定的销售期满，本合同即予终止。乙方如要续约，须于合同期满前30天内  向甲方提出申请，经甲方同意后，双方另签合同；若未于该期限内提出续约申请，则依本合同期限规定终止本合同。<p>
<h4>第八条</h4>
<p>1、本协议的签订、履行、终止、解释均适用中华人民共合国法律。</p>
<p>2、本协议在履行过程中，如果发生任何争执或纠纷，双方应友好协商解决；若协商不成，任何一方均有权向甲方所在地的人民法院提起诉讼。</p>　　
<h4>第九条，其他：</h4>
<p>1、各方可以书面协议方式对本协议作出修改和补充。经过各方协议签署的有关本协议的修改协议和补充协议是本协议的组成部分，具有与本协议同等的法律效力。</p>
<p>2、本协议可以一份或者多份并且每一份具有同等的法律效力，并永远保存在甲方为此设立的专用服务器上备查和保管。</p>
<h3>合同签署</h3>
<p>甲方：深圳市搏格教育咨询有限公司，于{{nowtime.getFullYear()}}年{{nowtime.getMonth()+1}}月{{nowtime.getDate()}}日，签署本合同。</p>
<p>乙方：{{unitRegistDto.name}}，于{{nowtime.getFullYear()}}年{{nowtime.getMonth()+1}}月{{nowtime.getDate()}}日，签署本合同</p>
</div>
      <el-button type="primary" style='float:right;margin:40px 0' @click="cutDiv">确 定</el-button>
    </el-dialog>


        </el-form-item>
            <el-form-item >
          <input name="返回" type="button" @click='goLogin' class="btn_zhuce"  value="返回"><input name="注册" type="button" @click='addUser(2)' style='margin-left:10px' class="btn_zhuce" value="注册">
        </el-form-item>
          </el-form>


  </el-tab-pane>

</el-tabs>
</el-card>

</div>
</el-row>
</div>
</template>
<script>
export default {
  name: 'accountregister',
  mounted: function() {
    var _self=this;
    this.$axios.get('/cgzdh/auth/getTime').then((res) => {
      _self.nowtime=new Date(res.data);

    }).catch(function(err) {
      _self.$message({
        showClose: true,
        message: '获取时间失败',
        type: 'error'
      });
    });
  },
  data() {
    return {
      msg: 'Welcome to Your companyregister.js App',
      activeName2: 'first',
      hhh:'',
      unitRegistDto: {
      	userName:'',
      	name:'',
      	password:'',
        userType:1,
      	recommendId:''
      },
      nowtime:'',
      dialogVisible: false,
      xy:false,
      rules: {
        userName: [{
          required: true,
          message: '请输入账号',
          trigger: 'blur'
        }, {
          validator: (rule, value, callback) => {
            var _self = this;
            _self.$axios.get('/cgzdh/auth/tuser/' + value).then((response) => {
              if (response.data.id !== null) {
                callback(new Error('该账户已经注册，请更换账户名'));
                // callback();
              } else {
                callback();
              }
            }).catch(function(err) {
              if(err.response.data.errorMsg=='此账户尚未注册'){
                  callback();
              }else{
                callback(new Error('检测账户信息失败' + err.response.data.errorMsg));
              }

            });
          },
          trigger: 'blur'
        }],
        xy: [{
          type: 'boolean',
          required: true,
          message: '注册需要同意协议',
          trigger: 'change'
        }],
        name: [{
          required: true,
          message: '请输入姓名',
          trigger: 'blur'
        }],
        password: [{
          required: true,
          message: '请输入密码',
          trigger: 'blur'
        }, {
          min: 6,
          max: 8,
          message: '密码长度在 6 到 8 个字符',
          trigger: 'blur'
        }],
        description: [{
          required: false
        }],
        confirmpassword: [{
          required: true,
          message: '请输入确认密码',
          trigger: 'blur'
        }, {
          min: 6,
          message: '密码长度需大于 6 个字符',
          trigger: 'blur'
        }, {
          validator: (rule, value, callback) => {
            if (value !== this.unitRegistDto.password) {
              callback(new Error('密码与确认密码不一致'));
            } else {
              callback();
            }
          },
          trigger: 'blur'
        }]
      },
      loadingInstance: {},
      confirmpassword: ''
    }
  },
  methods: {
    cutDiv:function(){
      this.dialogVisible = false;
    var divContent = document.getElementById("div").innerHTML;
console.log(divContent)
    var data = "data:image/svg+xml," +
    "<svg xmlns='http://www.w3.org/2000/svg' >" +
   "<foreignObject width='100%' height='100%'>" +
   "<div xmlns='http://www.w3.org/1999/xhtml' style='background-color:#fff;padding:20px 40px;font-size:12px;color:#505050'>" +
   divContent +
   "</div>" +
   "</foreignObject>" +
   "</svg>";
    var img = new Image();
    img.src = data;

    var canvas = document.createElement("canvas");
    canvas.width = "675";
    canvas.height = "1650";
    var ctx =  canvas.getContext("2d");
    img.crossOrigin="anonymous";
    ctx.drawImage(img, 0, 0);
    var type = 'png';
    var canvasbase = canvas.toDataURL(type);
    this.hhh=canvasbase;
    alert(canvasbase);
},
    addUser(userType) {
      var _self = this;
      _self.$refs.unitRegistDto.validate((valid) => {
        if (valid) {
          if(this.xy){
            this.unitRegistDto.userType=userType;
          _self.putUser();
        }else{
          _self.$message({
            showClose: true,
            message: '请先阅读并同意协议！',
            type: 'warning'
          });
        }
        } else {
          _self.$message({
            showClose: true,
            message: '请录入注册信息',
            type: 'error'
          });
        }
      });
    },
    putUser() {
      var _self = this;
      _self.loadingInstance = _self.$loading({
        fullscreen: true
      });
      _self.unitRegistDto.status=1;
      _self.loadingInstance.text = '正在注册账户';
      _self.$axios.post('/cgzdh/auth/userRegister', _self.unitRegistDto).then((response) => {
        _self.loadingInstance.close();
        _self.$message({
          showClose: true,
          message: '恭喜您，注册成功！',
          type: 'success'
        });
        _self.$router.push({
          name: 'companylogin'
        });
      }).catch(function(err) {
        alert('注册账户失败，错误信息：' + err.response.data.errorMsg);
        _self.loadingInstance.close();
      });
    }
  }
}
</script>
<style scoped>
body {
  margin-top: 300px;

}

.divcss5 {
  margin-top: 200px;
  margin: 0 auto;
  min-width:314px;
  max-width:464px;
}
.kuang_txt{ width:236px; height:32px; border:1px solid #dddddd; line-height:32px; padding-left:32px; color:#b1a9a9;  margin-bottom:10px; }
input.el-input__inner {
  margin-top: 5px
}
</style>>
