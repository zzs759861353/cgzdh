<template>
    <div>
    <div >
      <el-row style="margin:2% 0 7% 15%">
        <el-col >
          <el-steps :active="active" finish-status="success" >
              <el-step title="初始化" ></el-step>
              <el-step title="检测" ></el-step>
              <el-step title="开始" ></el-step>
              <el-step title="执行中" ></el-step>
        </el-steps>
      </el-col>
    </el-row>
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
      <el-row >

        <el-col :xs="22" :sm="12" :md="12" :lg="12">  <el-form-item label="股票名称：" prop="" >
  <el-input v-model="ssgp[0]"  disabled></el-input>
      </el-form-item></el-col>
      <el-col :xs="22" :sm="12" :md="12" :lg="12"><el-form-item label="当前价格：" prop="" style='text-align:left'>
<el-input v-model="ssgp[3]"  disabled></el-input>
    </el-form-item></el-col>
      </el-row>
  <el-row style="text-align:right">
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
       rules:{
         gpCode: [
           { required: true, message: '请填写股票代码', trigger: 'blur' }
         ],
         mccl: [
           { required: true, message: '请选择策略', trigger: 'change' }
         ],
         mrcl: [
           { required: true, message: '请选择策略', trigger: 'change' }
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
            _self.$message({
              showClose: true,
              message: '此浏览器不支持该系统',
              type: 'error'
            });
               }

          } else {
            _self.$message({
              showClose: true,
              message: '请补全录入信息',
              type: 'error'
            });
            return false;
          }
        })

     },
     chsFinsh:function(){
       if(!this.ssgp[3]){
         _self.$message({
           showClose: true,
           message: '无此股票信息，请重新选择',
           type: 'error'
         });return;
       }
       //this.jyForm.kmsl=Math.floor(29999.98/this.ssgp[3]*this.jyForm.jyCount/100)*100;//this.zj[2]/this.ssgp[3]/100*100;
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
       alert('卖出价格::'+this.jcjg+'买入价格::'+this.ssgp[3])
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
