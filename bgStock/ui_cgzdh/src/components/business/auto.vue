<template>
    <div>
<div  v-show="clientId==''" style='margin:0 auto'>
  <el-form :model="loginDto" :rules="loginDtoRules" ref="loginDto" label-width="80px" class="demo-userForm">
    <el-row>
    <el-col :xs="22" :sm="8" :md="8" :lg="8">
      <el-form-item label="帐号" prop="user">
        <el-input v-model="loginDto.user" ></el-input>
      </el-form-item>
    </el-col>
    <el-col :xs="22" :sm="8" :md="8" :lg="8" >
      <el-form-item label="密码" prop="passwd">
        <el-input type='password' v-model="loginDto.passwd" ></el-input>
      </el-form-item>
    </el-col>
    <el-col :xs="22" :sm="8" :md="8" :lg="8">
      <el-form-item label="券商" prop="qs">
        <el-select v-model="loginDto.qs" placeholder="请选择" style='width:100%'>
      <el-option
        v-for="item in options"
        :key="item.value"
        :label="item.label"
        :value="item.value">
      </el-option>
    </el-select>
      </el-form-item>
    </el-col>

  </el-row>
  <el-form-item style='text-align:right'>
    <el-button type="primary" @click="gp_login">登录</el-button>
  </el-form-item>
</el-form>
  </div>
  <div  v-show="clientId!=''" style='text-align:right;margin:0 auto'>

    <el-row >
      <el-col :xs="22" :sm="12" :md="12" :lg="12">
        <el-row>
          <el-col :span="6"><div class="grid-content xs_font_size">总市值：&nbsp;</div></el-col>
          <el-col :span="6"><div class="grid-content xs_font_size" style='text-align:left'>{{zj[6]}}</div></el-col>
          <el-col :span="6"><div class="grid-content xs_font_size">可用资金：&nbsp;</div></el-col>
          <el-col :span="6"><div class="grid-content xs_font_size" style='text-align:left'>{{zj[2]}}</div></el-col>
      </el-row>
      </el-col>
      <el-col :xs="22" :sm="12" :md="12" :lg="12">
        <el-row >
          <el-col :span="6"><div class="grid-content xs_font_size">总资产：&nbsp;</div></el-col>
          <el-col :span="6"><div class="grid-content xs_font_size" style='text-align:left'>{{zj[5]}}</div></el-col>
          <el-col :span="6"><div class="grid-content xs_font_size">可取资金：&nbsp;</div></el-col>
          <el-col :span="6"><div class="grid-content xs_font_size" style='text-align:left'>{{zj[4]}}</div></el-col>
        </el-row>
      </el-col>
    </el-row>

<el-row>
  <el-row >
    <el-col :span="4"><div class="grid-content xs_font_size">证券代码</div></el-col>
    <el-col :span="4"><div class="grid-content xs_font_size">股票名称</div></el-col>
    <el-col :span="4"><div class="grid-content xs_font_size">可用数量</div></el-col>
    <el-col :span="4"><div class="grid-content xs_font_size">股票市值</div></el-col>
    <el-col :span="4"><div class="grid-content xs_font_size">股票盈亏</div></el-col>
    <el-col :span="4"><div class="grid-content xs_font_size">盈亏比例</div></el-col>
  </el-row>
  <el-row v-for='item in gpList'>
    <el-col :span="4"><div class="grid-content xs_font_size">{{item[0]}}</div></el-col>
    <el-col :span="4"><div class="grid-content xs_font_size">{{item[1]}}</div></el-col>
    <el-col :span="4"><div class="grid-content xs_font_size">{{item[3]}}</div></el-col>
    <el-col :span="4"><div class="grid-content xs_font_size">{{item[6]}}</div></el-col>
    <el-col :span="4"><div class="grid-content xs_font_size">{{item[7]}}</div></el-col>
    <el-col :span="4"><div class="grid-content xs_font_size">{{item[8]}}</div></el-col>
  </el-row>


</el-row>


    <el-button type="danger" @click="login_out">退出登录</el-button>
  <hr />
    <div >
      <el-steps :active="active" finish-status="success" style='margin:30px 0 30px 24px '>
          <el-step title="初始化"></el-step>
          <el-step title="检测"></el-step>
          <el-step title="开始"></el-step>
          <el-step title="执行中"></el-step>
    </el-steps>
    <el-form :model="jyForm" :rules="rules" ref="jyForm" label-width="120px" inline-message='true' class="demo-userForm">
      <el-row >
        <el-col :xs="22" :sm="12" :md="12" :lg="12">  <el-form-item label="股票代码：" prop="gpCode" >
            <el-select  style='width:100%' v-model="jyForm.gpCode"    :disabled='btnSta.csh' placeholder="请选择">
    <el-option
      v-for="item in gpList"
      :key="item[9]"
      :label="item[1]"
      :value="item[0]+','+item[9]">
    </el-option>
  </el-select>
      </el-form-item></el-col>
      <el-col :xs="22" :sm="12" :md="12" :lg="12"><el-form-item label="选择策略：" prop="mccl" style='text-align:left'>
        <el-select v-model="jyForm.mccl" style='width:100%' placeholder="请选择"  :disabled='btnSta.csh'>
        <el-option-group
        v-for="group in options3"
        :key="group.label"
        :label="group.label">
        <el-option
          v-for="item in group.options"
          :label="item.title"
          :value="item.id">
        </el-option>
        </el-option-group>
        </el-select>
    </el-form-item></el-col>
      </el-row>

      <el-row  >
        <el-col :xs="22" :sm="16" :md="12" :lg="12"><el-form-item label="交易数量：" prop="jyCount" style='text-align:left'>
          <el-radio-group v-model="jyForm.jyCount" :disabled='btnSta.csh'>
          <el-radio label="1">全仓</el-radio>
          <el-radio label="0.5">五成</el-radio>
          <el-radio label="0.33">三成</el-radio>
          <el-radio label="0.2">两成</el-radio>
          </el-radio-group>
        </el-form-item></el-col>
        <el-col :xs="22" :sm="8" :md="12" :lg="12">  <el-form-item label="策略数量：" >
            <el-input :disabled='btnSta.csh'
              v-model="jyForm.kmsl">
            </el-input>
      </el-form-item></el-col>


      </el-row>
      <el-row>
  <el-col :span='24'>

  <el-button style="margin-top: 12px;" type="primary" @click="csh" :disabled='btnSta.csh'>初始化</el-button>
  <el-button style="margin-top: 12px;" type="success" @click="starting" :disabled='btnSta.start'>开始</el-button>
  <el-button style="margin-top: 12px;" type="danger" @click="stopping" :disabled='btnSta.stop'>停止</el-button>
  <el-button style="margin-top: 12px;" type="warning" @click="reSet" :disabled='!btnSta.stop'>重置</el-button>

</el-col>

</el-row>


      </el-form>
    </div>
    </div>
      </div>
  </template>
  <script>

  export default {
    mounted: function () {
      this.options3[0].options=this.yhcls,
      this.options3[1].options=this.xtcls,
      this.gpList=sessionStorage.getItem('gplist').split(','),
      this.zj=sessionStorage.getItem('selfzj').split(',')
  },
   data() {
     return {
       mrcllist: [],

       mccllist: [],

       jyForm:{
         gpCode:'',
         mccl: '',
         mrcl: '',
         gddm:'',
         jyCount:'',
         kmsl:0

       }
        ,
        options3: [{
          label: '用户策略',
          options: []
          }, {
          label: '系统策略',
          options: []
        }],
       loginDto:{
        ip :'',   //服务器IP地址
        port:'',            //端口
        user:'',  //账户
        passwd:'',      //密码
        txPwd :'',             //通讯密码
        yyb :'',              //营业部
        version:'' ,      //版本号
        qs:''
      },
      btnSta:{
        csh:false,
        start:true,
        stop:true
      },
      gpList: [],

      zj:[],
      options: [{
          value: '东莞证券',
          label: '东莞证券'
        }],
        active:0,
        ds:0,
       clientId:sessionStorage.getItem('clientId'),
       rules:{
         gpCode: [
           { required: true, message: '请选择股票代码', trigger: 'change' }
         ],
         mccl: [
           { required: true, message: '请选择卖出策略', trigger: 'change' }
         ],
         mrcl: [
           { required: true, message: '请选择买入策略', trigger: 'change' }
         ],
         jyCount: [
           { required: true, message: '请选择活交易仓位', trigger: 'change' }
         ]

       },
       loginDtoRules:{
         user: [
           { required: true, message: '请输入券商账户', trigger: 'blur' }
         ],
         passwd: [
           { required: true, message: '请输入券商密码', trigger: 'blur' }
         ],
         qs: [
           { required: true, message: '请选择券商', trigger: 'change' }
         ]

       }
     }
   },
   methods: {
     reSet:function(){
         this.btnSta.start=true;
         this.btnSta.csh=false;
         this.jyForm={
           gpCode:'',
           mccl: '',
           mrcl: '',
           gddm:'',
           jyCount:'',
           kmsl:0
         },
         this.gpXqList=[],
         this.today='',
         this.yesterday='',
         this.lastMonthDay='',
         this.ssgp=[],
         this.active=0
     },
     csh:function(){
       this.$refs['jyForm'].validate((valid) => {
          if (valid) {
            // for(var j=0;j<this.gpList.length;j++){
            //   alert(this.jyForm.gpCode);
            //   alert(this.gpList[j][0]);
            //   if(this.gpList[j][0]==this.jyForm.gpCode){
            //     alert('该股票已有持仓');break;
            //   }
            // }
          if(window.localStorage){
            if(this.active<1){
                this.active++;
            }
            this.jyForm.gddm=this.jyForm.gpCode.split(',')[1];
            this.jyForm.gpCode=this.jyForm.gpCode.split(',')[0];
            this.init(this.jyForm.gpCode);
          }else{
            this.$message({
              showClose: true,
              message: "浏览暂不支持此软件，请更换推荐浏览器运行",
              type: 'error'
            });
               }

          } else {
            this.$message({
              showClose: true,
              message: "请补全信息",
              type: 'error'
            });
            return false;
          }
        })

     },
     chsFinsh:function(){
       if(!this.ssgp[3]){
         this.$message({
           showClose: true,
           message: '无此股票信息!',
           type: 'error'
         });
         return;
       }
       this.jyForm.kmsl=Math.floor(29999.98/this.ssgp[3]*this.jyForm.jyCount/100)*100;//this.zj[2]/this.ssgp[3]/100*100;
       if(this.active<2){
           this.active++;
       }
         this.btnSta.csh=true;
         this.btnSta.start=false;
     },
     starting:function(){

       this.btnSta.stop=false;
       this.btnSta.start=true;
       if(this.active<3){
           this.active++;
       }
       this.$notify({
          title: '警告',
          message: '程序正根据所选条件及策略自动执行中，期间请不要关闭以及退出本页面，'+
          '否则程序将停止工作，暂停请点击停止，重新设定条件请点击重置',
          type: 'warning'
        });
       this.ds = window.setInterval(this.auto,5000);
     },
     stopping:function(){
       window.clearInterval(this.ds);
       this.btnSta.stop=true;
       this.btnSta.start=false;
       if(this.active==4){
           this.active=2;
       }
     },
    setLoginDto: function(ip,port,yyb,txPwd,version){
      this.loginDto.ip=ip,
      this.loginDto.port=port,
      this.loginDto.yyb=yyb,
      this.loginDto.version=version,
      this.loginDto.txPwd=txPwd
    },
    loadZj: function() {
      return this.$axios.get('/cgzdh/buss/gp_query',{params:{
        clientId:this.clientId,
        user:this.loginDto.user,
              code:104

      }});
    },
    loadGp: function() {
      return this.$axios.get('/cgzdh/buss/gp_query',{params:{
        clientId:this.clientId,
        user:this.loginDto.user,
              code:1114

      }});
    },
    login_out:function(){
      sessionStorage.setItem('clientId','');
      sessionStorage.setItem('gplist',[]);
      sessionStorage.setItem('selfzj',[]);
      this.$router.go(0);
    },
    getZhxx:function(){
      var _self=this;
                _self.$axios.all([_self.loadZj(), _self.loadGp()])
          .then(_self.$axios.spread(function(zjResponse, gpResponse) {
          var sss = zjResponse.data.substring(zjResponse.data.indexOf('保留信息|')+5,zjResponse.data.length-1).split('\|');
          sessionStorage.setItem('selfzj',sss);
          _self.zj=sss;
          var ss = gpResponse.data.substring(gpResponse.data.indexOf('保留信息|')+5,gpResponse.data.length-1).split('\|');
          if(ss.length==1&&_self.gpList.length==0){
          // _self.gpList.push(
          // [
          // "","","","","","","","","","","","","","",""
          // ]
          // )
          }else{
          for(var i=0;i<ss.length;i+=15){

          _self.gpList.push(ss.slice(i,i+15));
          }
          sessionStorage.setItem('gplist',_self.gpList);
          }
          })).catch(function(err) {
          _self.$message({
            showClose: true,
            message: '获取账户信息失败，错误信息：' + err,
            type: 'error'
          });
          });
    },
    hd:function(){
      if(this.active<4){
          this.active++;
      }
      this.jyForm.kmsl=Math.floor(200000/this.ssgp[3]*this.jyForm.jyCount/100)*100;
      var C=this.C;
      var ma=this.ma;
      var cross=this.cross;
      var ref=this.ref;
      var hhv=this.hhv;
      var llv=this.llv;
      var sma=this.sma;
      var g_if=this.g_if;
      eval(this.jyForm.mccl);
        //var mr=eval(this.jyForm.mrcl);
        // var mc=this.jyForm.mccl.split('\|');
        // var flagMc=0;
        //  for(var j=0;j<mc.length;j++){
        //    flagMc+=(eval(mc[j]));
        //  };
        //  if(flagMc==mc.length){
        //    alert('卖出')
        //  }else{
        //    //alert('不卖出')
        //  }
        //  var mr=this.jyForm.mrcl.split('\|');
        //  var flagMr=0;
        //   for(var j=0;j<mr.length;j++){
        //     flagMr+=(eval(mr[j]));
        //   };
        //   if(flagMr==mr.length){
        //     alert('买入')
        //   }else{
        //     //alert('不买入')
        //   }
       },
    gp_login:function(){
      this.$refs['loginDto'].validate((valid) => {
               if (valid) {
                 var _self=this;
                 switch(this.loginDto.qs){
                   case '东莞证券':
                   this.setLoginDto('27.223.20.162',7708,'0','','6.64');
                   ;break;
                 };
                 _self.$axios.post('/cgzdh/buss/gp_login',this.loginDto).then((response) => {
                               console.log(response);
                               if (!response.data ==0) {
                                 _self.clientId=response.data;
                                 sessionStorage.setItem('clientId',response.data);
                                 _self.getZhxx();

               }else{
                 _self.$message({
                   showClose: true,
                   message: '请检查证劵账户是否正确',
                   type: 'error'
                 });

               }
               }).catch(function(err) {
                 console.info(err);
                 _self.$message({
                   showClose: true,
                   message: err.response.data.errorMsg,
                   type: 'error'
                 });

                 _self.loadingInstance.close();
               });
               } else {

                 return false;
               }
             });
    }
   }
 }
  </script>
  <style>
  .grid-content{
    text-align: center;
  }
  .el-form-item__error {
    display: block;
}
  </style>
