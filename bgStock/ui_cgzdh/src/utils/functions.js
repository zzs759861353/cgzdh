export default {
  install(Vue, options) {
    Vue.mixin({
      data(){
        return{
          gpXqList:[],
          today:'',
          isMa:false,
          yesterday:'',
          scs:[],
          dpzs:[],
          sfsc:0,
          jcjg:0,
          jcs:[],
          g_status:0,//0卖1买，2完成买卖
          lastMonthDay:'',
          ssgp:[],
          sfgp:[],
          funs:[
            {title:'ma(A,day)',des:"A的day天平均移动"},
            {title:'cross(C,B)',des:"C上穿B"},
            {title:'ref(A,day)',des:"day个周期前的A值"},
            {title:'if(A,B,C)',des:"判断A(必须是判断语句)条件成立的时候返回B,不成立返回C"},
            {title:'ma("C",day)',des:"平均移动"}
          ],
          xtcls:[
            {title:'波浪分时形',id:'this.blcl()', des:'浪形分时波段交易，策略先卖后买，实现差价盈利'}
          ],
          yhcls: JSON.parse(localStorage.getItem('a52b0ae3-c95e-4ac8-aab1-997ba8b646bc'))
        }
      },
      methods: {
      time_range : function (beginTime, endTime) {
        var nowTime=this.getNowFormatDate();
      var strb = beginTime.split (":");
     if (strb.length != 2) {
          return false;
      }

      var stre = endTime.split (":");
      if (stre.length != 2) {
          return false;
     }

     var strn = nowTime.split (":");
     if (stre.length != 2) {
         return false;
     }
     var b = new Date ();
     var e = new Date ();
     var n = new Date ();

     b.setHours (strb[0]);
     b.setMinutes (strb[1]);
     e.setHours (stre[0]);
     e.setMinutes (stre[1]);
     n.setHours (strn[0]);
     n.setMinutes (strn[1]);

     if (n.getTime () - b.getTime () > 0 && n.getTime () - e.getTime () < 0) {
         return true;
     } else {
         //alert ("当前时间是：" + n.getHours () + ":" + n.getMinutes () + "，不在该时间范围内！");
         return false;
     }
 },
        jc:function(){
          var C=this.C;
          var ma=this.ma;
          var cross=this.cross;
          var ref=this.ref;
          var hhv=this.hhv;
          var llv=this.llv;
          var sma=this.sma;
          var g_if=this.g_if;
          if(this.jcs.length>3&&this.jcs[2].zs<this.jcs[0].zs){
            if((this.jcjg-this.ssgp[3])/this.jcjg>0.005){
              if(this.jcs.length%2==1){this.jcs=[this.jcs[this.jcs.length-1]];
            }else{
              this.jcs=[this.jcs[this.jcs.length-2]];
            }
              console.log('mr'+this.ssgp[3]);
              this.g_status=2;
              this.stopping();
              return;
            }
          }
          if(this.jcs.length>5&&this.jcs[2].zs>this.jcs[0].zs){
            if((this.jcjg-this.ssgp[3])/this.jcjg>0.005){
              if(this.jcs.length%2==1){this.jcs=[this.jcs[this.jcs.length-1]];
              }else{
                this.jcs=[this.jcs[this.jcs.length-2]];
              }
              console.log('mr'+this.ssgp[3]);
              this.g_status=2;
              this.stopping();
              return;
            }
          }
            var result=0;
            if(this.jcs.length%2==1){
              result=this.cross(function(i){return 3*(sma(function(i){return (C(i)-llv(function (i){return C(i)},4,i))/(hhv(function (i){return C(i)},4,i)-llv(function (i){return C(i)},4,i))*100},2,1,i))-2*(sma(function(i){return sma(function(i){return (C(i)-llv(function (i){return C(i)},4,i))/(hhv(function (i){return C(i)},4,i)-llv(function (i){return C(i)},4,i))*100},2,1,i)},2,1,i))},function(i){return sma(function(i){return sma(function(i){return (C(i)-llv(function (i){return C(i)},4,i))/(hhv(function (i){return C(i)},4,i)-llv(function (i){return C(i)},4,i))*100},2,1,i)},2,1,i)});

            }else{
              result=this.cross(function(i){return sma(function(i){return sma(function(i){return (C(i)-llv(function (i){return C(i)},4,i))/(hhv(function (i){return C(i)},4,i)-llv(function (i){return C(i)},4,i))*100},2,1,i)},2,1,i)},function(i){return 3*(sma(function(i){return (C(i)-llv(function (i){return C(i)},4,i))/(hhv(function (i){return C(i)},4,i)-llv(function (i){return C(i)},4,i))*100},2,1,i))-2*(sma(function(i){return sma(function(i){return (C(i)-llv(function (i){return C(i)},4,i))/(hhv(function (i){return C(i)},4,i)-llv(function (i){return C(i)},4,i))*100},2,1,i)},2,1,i))});

            }
          if(result==1){

                this.jcs.push({zs:this.dpzs[1],jg:this.ssgp[3]});
                if(this.jcs.length==2){
                  if((this.jcjg-this.ssgp[3])/this.jcjg>0.01){
                    this.jcs=[{zs:this.dpzs[1],jg:this.ssgp[3]}];
                    console.log('mr'+this.ssgp[3]);
                    this.g_status=2;
                    this.stopping();
                  }
                }else if(this.jcs.length>3){
                  //yn+2<yn
                  if(this.jcs[2].zs<this.jcs[0].zs){
                    //判断y+3
                        //每一个金叉
                        if(this.jcs.length%2==0){
                          if((this.jcjg-this.ssgp[3])/this.jcjg>0.003){
                            this.jcs=[{zs:this.dpzs[1],jg:this.ssgp[3]}];
                          console.log('mr'+this.ssgp[3]);
                            this.g_status=2;
                            this.stopping();
                          }
                        }
                    //yn+2>yn
                  }else{
                    //判断y+3
                    if(this.jcs.length==4){
                      if((this.jcjg-this.ssgp[3])/this.jcjg>0.01){
                        this.jcs=[{zs:this.dpzs[1],jg:this.ssgp[3]}];
                        console.log('mr'+this.ssgp[3]);
                        this.g_status=2;
                        this.stopping();
                      }
                      //判断yn+4
                    }else if(this.jcs.length>=5){
                      //y4<y2
                      if(this.jcs[4].zs<this.jcs[2].zs){
                        if(this.jcs.length>5){
                          //监控反弹
                          if(this.jcs.length%2==0){
                            if((this.jcjg-this.ssgp[3])/this.jcjg>0.003){
                              this.jcs=[{zs:this.dpzs[1],jg:this.ssgp[3]}];
                              console.log('mr'+this.ssgp[3]);
                              this.g_status=2;
                              this.stopping();
                            }
                          }
                        }
                      }else{
                        this.jcs=[{zs:this.dpzs[1],jg:this.ssgp[3]}];
                      }
                    }
                  }
                }
            }
        },
        sc:function(){
          var C=this.C;
          var ma=this.ma;
          var cross=this.cross;
          var ref=this.ref;
          var hhv=this.hhv;
          var llv=this.llv;
          var sma=this.sma;
          var g_if=this.g_if;
          if((this.gpXqList[0][6]-this.gpXqList[0][5])/this.gpXqList[0][2]){

          };
          if(this.sfgp.length<8||this.sfgp.length==this.sfsc){
            return;
          }
          var scResult=this.cross(function(i){return sma(function(i){return sma(function(i){return (C(i)-llv(function (i){return C(i)},4,i))/(hhv(function (i){return C(i)},4,i)-llv(function (i){return C(i)},4,i))*100},2,1,i)},2,1,i)},function(i){return 3*(sma(function(i){return (C(i)-llv(function (i){return C(i)},4,i))/(hhv(function (i){return C(i)},4,i)-llv(function (i){return C(i)},4,i))*100},2,1,i))-2*(sma(function(i){return sma(function(i){return (C(i)-llv(function (i){return C(i)},4,i))/(hhv(function (i){return C(i)},4,i)-llv(function (i){return C(i)},4,i))*100},2,1,i)},2,1,i))});
          if(scResult==1){
            this.sfsc=this.sfgp.length;
            if(this.scs.length==0){
              this.scs.push({zs:this.dpzs[1],jg:this.ssgp[3]})
            }else{
              this.scs.push({zs:this.dpzs[1],jg:this.ssgp[3]})
              if(this.dpzs[1]>this.scs[this.scs.length-2].zs){
                this.scs=[];
                console.log('mc'+this.ssgp[3]);
                this.jcjg=this.ssgp[3];
                this.g_status=1;
                this.jcs.push({zs:this.dpzs[1],jg:this.ssgp[3]});
              }
            }
          }
        },
        blcl:function(){
          if(this.jcjg==0){

            this.sc();
          }else{
            this.jc();
          }


        },
        init(gpCode){
          var now = new Date();
          this.yesterday=this.getYestoday(now);
          this.today=now.getFullYear()+((now.getMonth()+1)<10?"0":"")+(now.getMonth()+1)+(now.getDate()<10?"0":"")+now.getDate();
          this.lastMonthDay=this.getLastMonthYestdy(now);
          var self=this;
               self.$axios.get('/hisHq?code=cn_'+gpCode+'&start='+this.lastMonthDay+'&end='+this.yesterday+'&stat=1&order=D&period=d&callback=historySearchHandler&rt=json').then((response) => {

         self.gpXqList=response.data[0].hq;
         var g='';
         if(gpCode.substr(0,1)==6){
           g='sh'+gpCode;
         }else{
             g='sz'+gpCode;
         }
             self.$axios.get('/list='+g).then((response) => {

               self.ssgp=response.data.substr(response.data.indexOf('\"')+1,response.data.length).split(",");
               this.chsFinsh();;

             }).catch(function(err) {


             });
               }).catch(function(err) {

                 console.info(err);
                 alert('获取股票信息失败' + err.response.data.errorMsg);
                 return false;

               });
        },
        formatDuring:  function (mss) {
    var days = parseInt(mss / (1000 * 60 * 60 * 24));
    var hours = parseInt((mss % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
    var minutes = parseInt((mss % (1000 * 60 * 60)) / (1000 * 60));
    var seconds = (mss % (1000 * 60)) / 1000;
    return days + " 天 " + hours + " 小时 " + minutes + " 分钟 " + seconds + " 秒 ";
},
        getNowFormatDate:function () {
    var date = new Date();
    var seperator1 = "-";
    var seperator2 = ":";
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
            + " " + date.getHours() + seperator2 + date.getMinutes()
            + seperator2 + date.getSeconds();
    return date.getHours() + seperator2 + date.getMinutes();
},
      getYestoday:  function (date){
    var yesterday_milliseconds=date.getTime()-1000*60*60*24;
    var yesterday = new Date();
        yesterday.setTime(yesterday_milliseconds);

    var strYear = yesterday.getFullYear();
    var strDay = yesterday.getDate();
    var strMonth = yesterday.getMonth()+1;
    if(strMonth<10)
    {
        strMonth="0"+strMonth;
    }
    if(strDay<10)
    {
        strDay="0"+strDay;
    }
    return strYear+""+strMonth+""+strDay;
  } ,

  //获得上个月在昨天这一天的日期
getLastMonthYestdy:  function (date){
     var daysInMonth = new Array([0],[31],[28],[31],[30],[31],[30],[31],[31],[30],[31],[30],[31]);
     var strYear = date.getFullYear();
     var strDay = date.getDate();
     var strMonth = date.getMonth()+1;
     if(strYear%4 == 0 && strYear%100 != 0){
        daysInMonth[2] = 29;
     }
     if(strMonth - 1 == 0)
     {
        strYear -= 1;
        strMonth = 12;
     }
     else
     {
        strMonth -= 1;
     }
     strDay = daysInMonth[strMonth] >= strDay ? strDay : daysInMonth[strMonth];
     if(strMonth<10)
     {
        strMonth="0"+strMonth;
     }
     if(strDay<10)
     {
        strDay="0"+strDay;
     }

     return strYear+""+strMonth+""+strDay;
  },
  C:function(i){
    if(i<0){
      return parseFloat(this.ssgp[3]);
    }else{
      return parseFloat(this.sfgp[i+1].split(' ')[1]);
    }
  },
        g_if:function(A,B,C){
          if(A==true){
                  return B;
                }else if(A==false){
                  return C;
                }else{
                  throw('if参数中的判断条件不成立')
                }
        },
        ref:function(A,B){
          // this.isTrue("2C",B);
          // if(Object.prototype.toString.call(A) === '[object Array]'){
          //   switch(A.length){
          //     case 4:return this.nma(A[2],A[3],B);break;
          //     case 5:return this.nsma(A[2],A[3],A[4],B);break;
          //   }
          // }else{
          //   alert();
          //   this.isTrue(A,B);
          //   return this.gpXqList[parseInt(B)-1][parseInt(A)];
          // }

        },
        hhv:function(A,B,D){
          if(!D){
            D=0;
          }
          var _max=A(D);

          // switch(parseInt(A)){
          //   case 1:_max= this.ssgp[1];break;
          //   case 2:_max= this.ssgp[3];break;
          //   case 5:_max= this.ssgp[5];break;
          //   case 6:_max= this.ssgp[4];break;
          //   case 7:_max= this.ssgp[8];break;
          //   case 8:_max= this.ssgp[9];break;
          // }

          for(var d=1;d<B;d++){
          if(A(d+D)>_max){
            _max=A(d+D);
          }
          }
          return parseFloat(_max);

        },
        llv:function(A,B,D){

          // this.isTrue(A,B);
          // var __min=0;
          // if(!D&&!isNaN(D)){
          //   __min=this.gpXqList[D-1][parseInt(A)];
          //   for(var d=1;d<(B);d++){
          //
          //   if(this.gpXqList[d+D-1][parseInt(A)]<__min){
          //   __min=this.gpXqList[d+D-1][parseInt(A)];
          //   }
          //   }
          //   alert(__min);
          //   return __min;
          //
          // }else{
          //
          //   switch(parseInt(A)){
          //   case 1:__min= this.ssgp[1];break;
          //   case 2:__min= this.ssgp[3];break;
          //   case 5:__min= this.ssgp[5];break;
          //   case 6:__min= this.ssgp[4];break;
          //   case 7:__min= this.ssgp[8];break;
          //   case 8:__min= this.ssgp[9];break;
          //   }
          //
          if(!D){
            D=0;
          }
          var __min=eval(A(D));
            for(var d=1;d<B;d++){
            if(eval(A(d+D))<__min){
            __min=eval(A(d+D));
            }
            }
            return parseFloat(__min);
        //  }

        },
        count:function(){

        },
        cross:function(A,B){
          // if(Object.prototype.toString.call(A) === '[object Array]'&&Object.prototype.toString.call(B) === '[object Array]'){
          var i =0;
          //var sma=this.sma;
          var xa=eval(A(i));
          var xb=eval(B(i) );

          var i =1;
          var qa=eval(A(i));
          var qb=eval(B(i));
          if(qa>=qb){
            return 0;
          }else{
            if(xa>=xb){
              return 1;
            }else{
              return 0
            }
          }
    //     }else if(Object.prototype.toString.call(A) === '[object Array]'&&!isNaN(B)){
    //
    //     if(A[1]>=B){
    //       return 0;
    //     }
    //     if(A[0]>=B){
    //       return 1;
    //     }else{
    //       return 0
    //     }
    //   }else if(Object.prototype.toString.call(B) === '[object Array]'&&!isNaN(A)){
    //   if(A>=B[1]){
    //     return 0;
    //   }
    //   if(A>=B[0]){
    //     return 1;
    //   }else{
    //     return 0
    //   }
    // }else{
    //     throw('cross函数参数有误')
    //   }
      //  },
//         ma:function(a,b){
//           this.isTrue(a,b);
//           var pma=[];
//             var j=0;
//             var yj=0;
//             for(var i =0;i<b;i++){
//             yj=eval(yj+this.gpXqList[i][parseInt(a)]*10000);
//             if(i==(b-2)){
//               j=yj;
//             }
//             }
//             var jrcs=0;
//             switch(parseInt(a)){
//               case 1:jrcs= 1;break;
//               case 2:jrcs= 3;break;
//               case 5:jrcs= 5;break;
//               case 6:jrcs= 4;break;
//               case 7:jrcs= 8;break;
//               case 8:jrcs= 9;break;
//             }
//             j=(j+this.ssgp[jrcs]*10000)/(b*10000);
//             yj=yj/b/10000;
//             pma.push(j);
//             pma.push(yj);
//             pma.push(parseInt(a));
//             pma.push(parseInt(b));
// return pma;

        },
        nma:function(a,b,n){
            // var yj=0;
            // for(var i =0;i<b;i++){
            // yj=eval(yj+this.gpXqList[i+n-1][a]*10000);
            // }
            // yj=yj/b/10000;
            //
            // return yj;

        },
        sma:function(a,b,c,d){
          if(!d){
            d=0;
          }
          var psma=[];

             for(var i =b+d-1;i>d-1;i--){

            if(i==b+d-1){
              psma.push(a(i));
            }else{
              psma.push((c*a(i)+(b-c)*psma[psma.length-1])*10000/b/10000);
            }
             }

             return psma[psma.length-1];
          // alert(a);
          // if (typeof a === "function"){
          //   alert();
          //   var COLSE='COLSE';
          //   var hhv=this.hhv;
          //   var llv=this.llv;
          //   var C='2C';
          //   var O='1O';
          //   var H='6H';
          //   var L='5L';
          //   var V='7V';
          //   var AMO='8AMO';
          //   var psma=[];
          //   var jrcs=0;
          //   // switch(parseInt(a)){
          //   //   case 1:jrcs= 1;break;
          //   //   case 2:jrcs= 3;break;
          //   //   case 5:jrcs= 5;break;
          //   //   case 6:jrcs= 4;break;
          //   //   case 7:jrcs= 8;break;
          //   //   case 8:jrcs= 9;break;
          //   // }
          //   this.isTrue(a,b);
          //     var j=0;
          //     if(b==1){
          //       COLSE=this.ssgp[3];
          //       psma.push(eval(a));
          //       COLSE=this.gpXqList[0][2];
          //       var t=1;
          //       psma.push(eval(a));
          //       psma.push(a);
          //       psma.push(b);
          //       psma.push(c);
          //         return psma;
          //     }else{
          //       COLSE=this.gpXqList[b-2][2];
          //       var t=b-1;
          //       psma.push(eval(a));
          //       for(var i =(b-1);i>0;i--){
          //       if(i-1>0){
          //       COLSE=this.gpXqList[i-2][2];
          //       t=i-1;
          //       psma.push((c*eval(a)+(b-c)*psma[psma.length-1])*10000/b/10000);
          //     }else if(i-1==0)
          //         COLSE=this.ssgp[3];
          //          t=1;
          //       {alert((c*eval(a)+(b-c)*psma[psma.length-1])*10000/b/10000)
          //         return [(c*eval(a)+(b-c)*psma[psma.length-1])*10000/b/10000,this.nsma(a,b,c,1),a,b,c];
          //       }
          //       }
          //     }
          //
          // }
          // var psma=[];
          // var jrcs=0;
          // switch(parseInt(a)){
          //   case 1:jrcs= 1;break;
          //   case 2:jrcs= 3;break;
          //   case 5:jrcs= 5;break;
          //   case 6:jrcs= 4;break;
          //   case 7:jrcs= 8;break;
          //   case 8:jrcs= 9;break;
          // }
          // this.isTrue(a,b);
          //   var j=0;
          //   if(b==1){
          //     psma.push(this.ssgp[jrcs]);
          //     psma.push(this.gpXqList[0][parseInt(a)]);
          //     psma.push(a);
          //     psma.push(b);
          //     psma.push(c);
          //       return psma;
          //   }else{
          //     psma.push(this.gpXqList[b-2][parseInt(a)]);
          //     for(var i =(b-1);i>0;i--){
          //     if(i-1>0){
          //     psma.push((c*this.gpXqList[i-2][parseInt(a)]+(b-c)*psma[psma.length-1])*10000/b/10000);
          //   }else if(i-1==0)
          //     {alert((c*this.ssgp[jrcs]+(b-c)*psma[psma.length-1])*10000/b/10000)
          //       return [(c*this.ssgp[jrcs]+(b-c)*psma[psma.length-1])*10000/b/10000,this.nsma(a,b,c,1),a,b,c];
          //     }
          //     }
          //   }
          //
          //

        },
        nsma:function(a,b,c,d){

          // var psma=[];
          // this.isTrue(a,b);
          //   var j=0;
          //   if(b==1){
          //     return this.gpXqList[d-1][parseInt(a)];
          //   }else{
          //     psma.push(this.gpXqList[b+d-2][parseInt(a)]);
          //     for(var i =(b-1);i>0;i--){
          //
          //     psma.push((c*this.gpXqList[i+d-2][parseInt(a)]+(b-c)*psma[psma.length-1])*10000/b/10000);
          //
          //     }
          //     alert(psma[psma.length-1]);
          //     return psma[psma.length-1];
            // }




        },
        isType: function (obj,type) {
              return (type === "Null" && obj === null) ||
              (type === "Undefined" && obj === void 0 ) ||
              (type === "Number" && isFinite(obj)) ||
              Object.prototype.toString.call(obj).slice(8,-1) === type;
              } ,
        isTrue: function (a,b) {
                  var re=  /^\+?[1-9][0-9]*$/;
                  var result=  re.test(b);
                  // var csA="1,2,5,6,7,8";
                  // var result2=csA.indexOf(parseInt(a));
                  if(result&&isNaN(a)){
                    return true;
                  }else{
                    throw ('   错误信息：函数参数有误');
                    return;
                  }
                    } ,
        auto:function(){
          if(this.time_range('09:29','11:30')&&this.time_range('12:59','15:00')){

            var self=this;
            var g='';
            var dp='';
            if(this.jyForm.gpCode.substr(0,1)==6){
              g='sh'+this.jyForm.gpCode;
              dp='s_sh000001'
            }else{
                g='sz'+this.jyForm.gpCode;
                dp='s_sz399001'
            }
  // var hq_str_s_sh000001="上证指数,3094.668,-128.073,-3.97,436653,5458126";
  // 数据含义分别为：指数名称，当前点数，当前价格，涨跌率，成交量（手），成交额（万元）；

                // self.$axios.get('/flashdata/hushen/minute/'+g+'.js').then((response) => {
                //   self.sfgp=response.data.split("\\n\\").reverse();
                  self.$axios.get('/list='+g).then((response) => {
                    self.ssgp=response.data.substr(response.data.indexOf('\"')+1,response.data.length).split(",");
                    if(self.ssgp[self.ssgp.length-2].substr(6)<5){
                      self.sfgp.push(self.ssgp[self.ssgp.length-2]+' '+self.ssgp[3])
                    };
                    console.log(self.sfgp)
                    self.$axios.get('/list='+dp).then((response) => {
                      self.dpzs=response.data.substr(response.data.indexOf('\"')+1,response.data.length).split(",");

                      this.hd();

                    }).catch(function(err) {
                    });
                  }).catch(function(err) {


                  });

                // }).catch(function(err) {
                //
                //
                // });
          }

        }
      }
    })
  }
}
