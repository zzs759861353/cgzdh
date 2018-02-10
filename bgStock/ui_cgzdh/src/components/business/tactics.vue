<template>
<div >
  <el-row :gutter="21" >
    <el-col :span="5">
      <div  style='text-align:left;border-left:1px solid #e0e0e0;border-right:1px solid #e0e0e0;border-top:1px solid #e0e0e0'>
<span>
  函数列表
</span></br>
参数说明：</br>
C:收盘价
O:开盘价
H:最高价
<br />
L:最低价
V:成交量
AMO:成交额

      </div>
      <el-collapse  accordion>
  <el-collapse-item :title=fun.title :name=index v-for='(fun,index) in funs'>
    <div style='text-align:left'>
{{fun.des}}
    </div>

  </el-collapse-item>
</el-collapse>
    </el-col>
    <el-col :span="16">
      <div class="grid-content bg-purple-dark " style='text-align:left;line-height:36px;font-size:14px;padding-left:10px;color:#fff;margin:0   0 10px 0' @click='cjcl'> 用户策略(单机此处新增策略)</div>
      <el-form  v-show='cjyhcl' :model="yhclDto" :rules="rules" ref="yhclDto" label-width="100px" class="demo-ruleForm" >
        <el-form-item label="策略名称" prop="title">
          <el-input v-model="yhclDto.title"></el-input>
        </el-form-item>
        <el-form-item label="策略描述" prop="des">
          <el-input type="textarea" v-model="yhclDto.des"></el-input>
        </el-form-item>
        <el-form-item label="策略表达式" prop="cl">
          <el-input type="textarea" v-model="yhclDto.cl"></el-input>
        </el-form-item>
        <el-form-item style='margin:20px 30px 20px 0;text-align:right'>
          <el-button type="primary" @click="submitYhcl()">立即创建</el-button>
          <el-button @click="init('600446')">测试</el-button>
        </el-form-item>
      </el-form>







      <el-collapse  accordion>
  <el-collapse-item :title=yhcl.title :name=index v-for='(yhcl,index) in yhcls' style='text-align:right'>
    <div style='text-align:left'>
策略表达式：{{yhcl.cl}}</br>
策略描述：{{yhcl.des}}

    </div>
<el-button type="danger" @click='delCl(index)'>删除策略</el-button>
  </el-collapse-item>
</el-collapse>


      <div class="grid-content bg-purple-dark " style='text-align:left;line-height:36px;font-size:14px;padding-left:10px;color:#fff;margin:10px 0 10px 0'> 系统策略</div>
      <el-collapse  accordion>
  <el-collapse-item :title=xtcl.title :name=index v-for='(xtcl,index) in xtcls'>
    <div style='text-align:left'>
策略表达式：{{xtcl.cl}}</br>
策略描述：{{xtcl.des}}
    </div>

  </el-collapse-item>
</el-collapse>
    </el-col>
  </el-row>
</div>
</template>
<script>
export default {
  name: 'tactics',
  created: function() {

  },
  mounted: function() {
  },
  data() {
    return {
      cjyhcl:false,
      yhclDto:{
        title:'',
        des:'',
        cl:'',
        name:''
      },
      jyForm:{
        gpCode:'600570'
      },
      rules: {
          title: [
            { required: true, message: '请输入策略名称', trigger: 'blur' },
            { min: 1, max: 30, message: '长度在 3 到 5 个字符', trigger: 'blur' }
          ],
          des: [
            { required: true, message: '请输入策略描述', trigger: 'blur' },
            { min: 1, max: 200, message: '长度在 3 到 5 个字符', trigger: 'blur' }
          ],
          cl: [
            { required: true, message: '请填写策略表达式', trigger: 'blur' }
          ]
        }
    }
  },
  methods:{
    chsFinsh:function(){
      this.auto();
    },
    hd:function(){
      var C=this.C;
      var ma=this.ma;
      var cross=this.cross;
      var ref=this.ref;
      var hhv=this.hhv;
      var llv=this.llv;
      var sma=this.sma;
      var g_if=this.g_if;
      var b=999;
      try  {
        //alert(this.yhclDto.cl.replace('if','this.g_if'))
     b=eval(this.yhclDto.cl.replace('if','g_if'));
     alert('输出:'+b)
     }
     catch(exception) {
       console.log(exception);
       this.$message({
       showClose: true,
       message: '该策略函数写法有误，请重新编辑!'+exception,
       type: 'error'
       });
       return;
     }
         if(isNaN(this.yhclDto.cl)&&(b==0||b==1)){
           this.$message({
          showClose: true,
          message: '恭喜你，该策略可以执行',
          type: 'success'
        });
         }else{
           this.$message({
          showClose: true,
          message: '该策略返回值不正确，请重新编辑',
          type: 'error'
        });
         };
       },
    delCl:function(index){
      this.$confirm('此操作将永久删除该策略, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.yhcls.splice(index, 1);
        localStorage.setItem('a52b0ae3-c95e-4ac8-aab1-997ba8b646bc',JSON.stringify(this.yhcls));
        this.$message({
          type: 'success',
          message: '删除成功!'
        });
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        });
      });


    },
    cjcl:function(){
      this.$refs['yhclDto'].resetFields();
      this.cjyhcl=true;
    },
    submitYhcl:function(){
      var _self=this;
      this.$refs['yhclDto'].validate((valid) => {
          if (valid) {
            if(_self.yhcls==null){
              _self.yhcls=[];
            }
            _self.yhcls.push({title:_self.yhclDto.title,
                              des:_self.yhclDto.des,
                              cl:_self.yhclDto.cl
                            });
            localStorage.setItem('a52b0ae3-c95e-4ac8-aab1-997ba8b646bc',JSON.stringify(_self.yhcls));
            this.cjyhcl=false;
          } else {
            return false;
          }
        });
    }

  }
}
</script>
<style>
.el-form-item__error {
    display: block;
}
</style>
