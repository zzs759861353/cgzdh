<template>
<div id='accountregister'>
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
    <span style='margin-left:10px;font-size:12px'>已阅读并同意<a @click="dialogVisible = true" target="_blank"><span class="lan">《搏格量化大师使用协议》</span></a></span>
    <el-dialog title="搏格量化大师注册及软件产品许可使用协议" :visible.sync="dialogVisible" center style='min-width:800px;text-align:center;padding:0;margin:0'>
    <div style='text-align:left;padding:0 40px;font-size:12px'>
      欢迎您注册搏格量化大师账号或购买搏格量化大师产品，您在注册搏格量化大师账号或购买软件产品程序过程中勾选“我已经阅读”即表示您与公司达成协议，视为您已了解并完全接受本协议项下的全部条款；如您不接受本协议项下的全部条款，请您不要勾选。

    <h4>  一、协议的完善和修改</h4>

      深圳市搏格教育咨询有限公司有权根据互联网的发展和中华人民共和国有关法律、法规、政策变化，不断地完善服务质量并依此修改本协议的条款，修改后的协议条款将在公司网站上予以公布，用户确认公司无需就协议条款的修改事宜逐一通知用户。用户继续使用公司软件产品的，视为该用户接受修改后的协议条款，有关公司与该用户之间的权利以及义务的表述关系，以修改后的协议条款为准。

      <h4>二、注册信息和隐私保护</h4>

      1.用户完成注册申请手续后，获得帐号的使用权，帐号的所有权归公司所有。用户应提供及时、详尽及准确的个人资料，并不断更新注册资料，符合及时、详尽、准确的要求。如果因注册信息不真实而引起的问题，并对问题发生所带来的后果，深圳市搏格教育咨询有限公司不负任何责任。<br />
      2. 您一旦注册成功成为用户，您将得到一个密码和帐号。如果您未保管好自己的帐号和密码而对您、深圳市搏格教育咨询有限公司或第三方造成的损害，您将负全部责任。另外，每个用户都要对其帐户中的所有活动和事件负全责。您可随时改变您的密码，也可以结束旧的帐户重开一个新帐户。用户同意若发现任何非法使用用户帐号或安全漏洞的情况，立即通告深圳市搏格教育咨询有限公司。<br />
      3. 用户因密码遗失或被盗向公司提出修改密码时，必须提供完整、准确的注册信息，否则公司有权本着为用户保密的原则不予修改。<br />
      4. 用户的用户名和密码只能供用户本人使用，不得以任何形式转让或授权他人使用。一个账号同一时间仅允许在同一台终端上使用，如若发现通过破解、外挂等途径实现一个账号同一时间被多人或者多终端登录使用，公司有权取消此账号的使用资格，并不予任何赔偿或者退还任何已缴纳的服务费用。<br />
      5. 公司不对外公开或向第三方提供用户的注册资料，除非：<br />
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(1) 事先获得用户的明确授权；</br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(2) 只有透露用户的个人资料，才能提供用户所要求的产品和服务；</br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(3) 有关的法律法规要求；</br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(4) 按照相关政府主管部门的要求。</br>

      <h4>三、软件产品服务费用</h4>
      1. 软件产品服务费用按照购买日公布的价格及优惠政策执行，用户应在本协议签订当日支付全部软件产品服务费用。<br />
      2. 软件产品服务期限自软件帐号激活之日起计算。<br />
    <h4>  四、服务修订</h4>
      深圳市搏格教育咨询有限公司保留随时修改或中断服务而不需通知用户的权利。用户接受深圳市搏格教育咨询有限公司行使修改或中断服务的权利，深圳市搏格教育咨询有限公司不需对用户或第三方负责。<br />
      <h4>五、产品风险提示</h4>

      1. 用户应充分认识到证券投资的风险。公司所提供的所有数据与信息，及操作策略参考数据，软件功能和需要执行自动化功能，仅供用户参考使用，不构成用户进行投资操作的直接依据，用户据此操作，风险自担，公司不承担任何经济和法律责任。<br />
      2. 公司通过软件产品为用户提供量化交易和行情数据信息，并通过相关数据分析系统、统计运算模型，数据进行整理、加工和集成，为用户提供高附加值的数据服务和智能功能，（该等信息及数据服务均是根据数据模型自动生成，不存在人为的操控或操纵），以利于用户在投资过程中理性决策、控制风险。用户在使用软件产品过程中，对于公司提供的信息数据内容，用户不应将其视作公司明示、默示地承诺证券的投资收益，不应将其视为具体证券品种选择/买卖时机的建议，不应将其视为对证券市场/证券品种的走势、投资证券的可行性的分析、预测或建议，或任何其他形式的证券投资咨询/建议。公司对用户的投资决策可能带来的风险或损失不承担任何违约、赔偿或其他民事责任。<br />

      <h4>六、知识产权</h4>

      公司尊重他人知识产权和合法权益。若您认为您的知识产权或其他合法权益被侵犯，请按照以下说明向公司提供资料∶
      请注意：如果权利通知的陈述失实，权利通知提交者将承担对由此造成的全部法律责任（包括但不限于赔偿各种费用及律师费）。如果上述个人或单位不确定公司的软件产品是否侵犯了其知识产权和其他合法权益，公司建议该个人或单位首先咨询专业人士。
      为了公司有效处理上述个人或单位的权利通知，请使用以下格式（包括各条款的序号）：<br />
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(1) 权利人对涉嫌侵权内容拥有知识产权或其他合法权益和/或依法可以行使知识产权或其他合法权益的权属证明。</br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(2) 请充分、明确地描述被侵犯了知识产权或其他合法权益的情况，并指明涉嫌侵权的具体内容。</br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(3) 请提供权利人具体的联络信息，包括姓名、身份证或护照复印件（对自然人）、单位登记证明复印件（对单位）、通信地址、电话号码、传真和电子邮件。</br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; (4) 请在权利通知中加入如下关于通知内容真实性的声明：</br>
      “我本人/本公司保证，本通知中所述信息是充分、真实、准确的，如果本权利通知内容不完全属实，本人/本公司将承担由此产生的一切法律责任。”
      请您签署该文件，如果您是依法成立的机构或组织，请您加盖公章<br />

      <h4>七、免责条款</h4>

      1. 在服务期内，公司将有权根据经营活动的需要，随时对软件产品的服务内容进行更新、增加或删除，且无需另行通知或取得用户的同意。<br />
      2. 公司尽力提供完整、及时、准确的信息，但不对所提供信息的完整性、及时性、准确性承担任何责任。<br />
      3. 公司全力保障信息的优质传输，但对因证券交易所、卫星传输线路、电信部门及网络服务提供商、上市公司信息提供商等任何原因造成的信息传递异常情况所致后果不承担任何法律责任。<br />
      4. 由于地震、台风、战争、罢工、政府行为、瘟疫、爆发性和流行性传染病或其他重大疫情、各方原因造成的火灾、基础电信网络中断造成的及其它各方不能预见并且对其发生后果不能预防或避免的不可抗力原因，致使相关服务中断，公司不承担由此产生的损失，但会积极加以解决。<br />
      5.软件部分功能，涉及量化交易，及按照您的意愿，实现量化交易，若不符合您的投资理念，请谨慎使用，造成任何的损失的，不承担任何法律责任。<br />
      6.应用本软件，系执行交易，不属于第三交易，一切交易均在隶属证券执行，不对交易承担任何法律责任。<br />
      <h4>八、服务内容的版权</h4>
      公司的软件产品均受版权保护，用户不能擅自复制、随意发布相关服务内容，不得根据服务内容，改造或创造与服务内容有关的派生产品，不得将公司提供的数据和信息内容向他人发布并收取不正当的费用。<br />
      <h4>九、软件产品的续费</h4>

      服务期限届满后，用户愿意继续使用公司软件产品的，应向公司办理续期手续并交纳相应的续期费用。若届时双方没有特殊约定的，在续期期间内用户与公司之间的权利义务关系继续适用本协议的约定。<br />
      请仔细阅读以上条款，阅读结束后同意请勾选“我已经阅读”。<hr />





      <el-button type="primary" style='float:right' @click="dialogVisible = false">确 定</el-button></br>
    </div>
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
    <span style='margin-left:10px;font-size:12px'>已阅读并同意<a @click="dialogVisible = true" target="_blank"><span class="lan">《搏格量化大师使用协议》</span></a></span>
    <el-dialog title="搏格量化大师注册及软件产品许可使用协议" :visible.sync="dialogVisible" center style='min-width:800px;text-align:center;padding:0;margin:0'>
    <div style='text-align:left;padding:0 40px;font-size:12px'>
      欢迎您注册搏格量化大师账号或购买搏格量化大师产品，您在注册搏格量化大师账号或购买软件产品程序过程中勾选“我已经阅读”即表示您与公司达成协议，视为您已了解并完全接受本协议项下的全部条款；如您不接受本协议项下的全部条款，请您不要勾选。

    <h4>  一、协议的完善和修改</h4>

      深圳市搏格教育咨询有限公司有权根据互联网的发展和中华人民共和国有关法律、法规、政策变化，不断地完善服务质量并依此修改本协议的条款，修改后的协议条款将在公司网站上予以公布，用户确认公司无需就协议条款的修改事宜逐一通知用户。用户继续使用公司软件产品的，视为该用户接受修改后的协议条款，有关公司与该用户之间的权利以及义务的表述关系，以修改后的协议条款为准。

      <h4>二、注册信息和隐私保护</h4>

      1.用户完成注册申请手续后，获得帐号的使用权，帐号的所有权归公司所有。用户应提供及时、详尽及准确的个人资料，并不断更新注册资料，符合及时、详尽、准确的要求。如果因注册信息不真实而引起的问题，并对问题发生所带来的后果，深圳市搏格教育咨询有限公司不负任何责任。<br />
      2. 您一旦注册成功成为用户，您将得到一个密码和帐号。如果您未保管好自己的帐号和密码而对您、深圳市搏格教育咨询有限公司或第三方造成的损害，您将负全部责任。另外，每个用户都要对其帐户中的所有活动和事件负全责。您可随时改变您的密码，也可以结束旧的帐户重开一个新帐户。用户同意若发现任何非法使用用户帐号或安全漏洞的情况，立即通告深圳市搏格教育咨询有限公司。<br />
      3. 用户因密码遗失或被盗向公司提出修改密码时，必须提供完整、准确的注册信息，否则公司有权本着为用户保密的原则不予修改。<br />
      4. 用户的用户名和密码只能供用户本人使用，不得以任何形式转让或授权他人使用。一个账号同一时间仅允许在同一台终端上使用，如若发现通过破解、外挂等途径实现一个账号同一时间被多人或者多终端登录使用，公司有权取消此账号的使用资格，并不予任何赔偿或者退还任何已缴纳的服务费用。<br />
      5. 公司不对外公开或向第三方提供用户的注册资料，除非：<br />
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(1) 事先获得用户的明确授权；</br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(2) 只有透露用户的个人资料，才能提供用户所要求的产品和服务；</br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(3) 有关的法律法规要求；</br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(4) 按照相关政府主管部门的要求。</br>

      <h4>三、软件产品服务费用</h4>
      1. 软件产品服务费用按照购买日公布的价格及优惠政策执行，用户应在本协议签订当日支付全部软件产品服务费用。<br />
      2. 软件产品服务期限自软件帐号激活之日起计算。<br />
    <h4>  四、服务修订</h4>
      深圳市搏格教育咨询有限公司保留随时修改或中断服务而不需通知用户的权利。用户接受深圳市搏格教育咨询有限公司行使修改或中断服务的权利，深圳市搏格教育咨询有限公司不需对用户或第三方负责。<br />
      <h4>五、产品风险提示</h4>

      1. 用户应充分认识到证券投资的风险。公司所提供的所有数据与信息，及操作策略参考数据，软件功能和需要执行自动化功能，仅供用户参考使用，不构成用户进行投资操作的直接依据，用户据此操作，风险自担，公司不承担任何经济和法律责任。<br />
      2. 公司通过软件产品为用户提供量化交易和行情数据信息，并通过相关数据分析系统、统计运算模型，数据进行整理、加工和集成，为用户提供高附加值的数据服务和智能功能，（该等信息及数据服务均是根据数据模型自动生成，不存在人为的操控或操纵），以利于用户在投资过程中理性决策、控制风险。用户在使用软件产品过程中，对于公司提供的信息数据内容，用户不应将其视作公司明示、默示地承诺证券的投资收益，不应将其视为具体证券品种选择/买卖时机的建议，不应将其视为对证券市场/证券品种的走势、投资证券的可行性的分析、预测或建议，或任何其他形式的证券投资咨询/建议。公司对用户的投资决策可能带来的风险或损失不承担任何违约、赔偿或其他民事责任。<br />

      <h4>六、知识产权</h4>

      公司尊重他人知识产权和合法权益。若您认为您的知识产权或其他合法权益被侵犯，请按照以下说明向公司提供资料∶
      请注意：如果权利通知的陈述失实，权利通知提交者将承担对由此造成的全部法律责任（包括但不限于赔偿各种费用及律师费）。如果上述个人或单位不确定公司的软件产品是否侵犯了其知识产权和其他合法权益，公司建议该个人或单位首先咨询专业人士。
      为了公司有效处理上述个人或单位的权利通知，请使用以下格式（包括各条款的序号）：<br />
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(1) 权利人对涉嫌侵权内容拥有知识产权或其他合法权益和/或依法可以行使知识产权或其他合法权益的权属证明。</br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(2) 请充分、明确地描述被侵犯了知识产权或其他合法权益的情况，并指明涉嫌侵权的具体内容。</br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(3) 请提供权利人具体的联络信息，包括姓名、身份证或护照复印件（对自然人）、单位登记证明复印件（对单位）、通信地址、电话号码、传真和电子邮件。</br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; (4) 请在权利通知中加入如下关于通知内容真实性的声明：</br>
      “我本人/本公司保证，本通知中所述信息是充分、真实、准确的，如果本权利通知内容不完全属实，本人/本公司将承担由此产生的一切法律责任。”
      请您签署该文件，如果您是依法成立的机构或组织，请您加盖公章<br />

      <h4>七、免责条款</h4>

      1. 在服务期内，公司将有权根据经营活动的需要，随时对软件产品的服务内容进行更新、增加或删除，且无需另行通知或取得用户的同意。<br />
      2. 公司尽力提供完整、及时、准确的信息，但不对所提供信息的完整性、及时性、准确性承担任何责任。<br />
      3. 公司全力保障信息的优质传输，但对因证券交易所、卫星传输线路、电信部门及网络服务提供商、上市公司信息提供商等任何原因造成的信息传递异常情况所致后果不承担任何法律责任。<br />
      4. 由于地震、台风、战争、罢工、政府行为、瘟疫、爆发性和流行性传染病或其他重大疫情、各方原因造成的火灾、基础电信网络中断造成的及其它各方不能预见并且对其发生后果不能预防或避免的不可抗力原因，致使相关服务中断，公司不承担由此产生的损失，但会积极加以解决。<br />
      5.软件部分功能，涉及量化交易，及按照您的意愿，实现量化交易，若不符合您的投资理念，请谨慎使用，造成任何的损失的，不承担任何法律责任。<br />
      6.应用本软件，系执行交易，不属于第三交易，一切交易均在隶属证券执行，不对交易承担任何法律责任。<br />
      <h4>八、服务内容的版权</h4>
      公司的软件产品均受版权保护，用户不能擅自复制、随意发布相关服务内容，不得根据服务内容，改造或创造与服务内容有关的派生产品，不得将公司提供的数据和信息内容向他人发布并收取不正当的费用。<br />
      <h4>九、软件产品的续费</h4>

      服务期限届满后，用户愿意继续使用公司软件产品的，应向公司办理续期手续并交纳相应的续期费用。若届时双方没有特殊约定的，在续期期间内用户与公司之间的权利义务关系继续适用本协议的约定。<br />
      请仔细阅读以上条款，阅读结束后同意请勾选“我已经阅读”。<hr />





      <el-button type="primary" style='float:right' @click="dialogVisible = false">确 定</el-button></br>
    </div>
    </el-dialog>


        </el-form-item>
            <el-form-item >
          <input name="返回" type="button" @click='goLogin' class="btn_zhuce" value="返回"><input name="注册" type="button" @click='addUser(2)' style='margin-left:10px' class="btn_zhuce" value="注册">
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

  },
  data() {
    return {
      msg: 'Welcome to Your companyregister.js App',
      activeName2: 'first',
      unitRegistDto: {
      	userName:'',
      	name:'',
      	password:'',
        userType:1,
      	recommendId:''
      },
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
