<template>
    <div>
  <div  style='text-align:right;margin:0 auto'>

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
  <el-input v-model="jyForm.gpCode"  :disabled='btnSta.csh'></el-input>
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
  <el-row :span='24'>
<el-form-item>
  <el-button style="margin-top: 12px;" type="primary" @click="csh" :disabled='btnSta.csh'>初始化</el-button>
  <el-button style="margin-top: 12px;" type="success" @click="starting" :disabled='btnSta.start'>开始</el-button>
  <el-button style="margin-top: 12px;" type="danger" @click="stopping" :disabled='btnSta.stop'>停止</el-button>
  <el-button style="margin-top: 12px;" type="warning" @click="reSet" :disabled='!btnSta.stop'>重置</el-button>
</el-form-item>
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
      this.options3[1].options=this.xtcls
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

      btnSta:{
        csh:false,
        start:true,
        stop:true
      },
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
            alert("浏览暂不支持localStorage，请更换推荐浏览器运行")
               }

          } else {
            alert('请补全信息');
            return false;
          }
        })

     },
     chsFinsh:function(){
       if(!this.ssgp[3]){
         alert('当前股票存在异常请检查后重试!');return;
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
