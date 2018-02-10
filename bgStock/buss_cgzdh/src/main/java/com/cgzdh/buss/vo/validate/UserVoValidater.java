package com.cgzdh.buss.vo.validate;


import com.alibaba.fastjson.JSONObject;
import com.baidu.unbiz.fluentvalidator.Validator;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.baidu.unbiz.fluentvalidator.ValidatorHandler;
import com.cgzdh.buss.domain.enums.AgentTypeEnum;
import com.cgzdh.buss.domain.enums.CertificateEnum;
import com.cgzdh.buss.vo.UserVo;
import org.springframework.util.StringUtils;


/**
 * 界面注册信息的校验
 * @author v_bbojiang
 */
public class UserVoValidater extends ValidatorHandler<UserVo> implements Validator<UserVo> {

    /**
     * 对用户参数校验
     * @param context 上下文
     * @param userVo 界面用户信息
     * @return 是否成功
     */
    @Override
    public boolean validate(ValidatorContext context, UserVo userVo) {
        if(!userVo.isAgreement()){
            context.addErrorMsg("请同意协议");
            return false;
        }
        if(!userVo.isAgent()){
            return commonUser(context, userVo);
        }else if(AgentTypeEnum.UserAgent.getAgentType().equals(userVo.getAgentType())){
            return userAgent(context, userVo);
        }else if(AgentTypeEnum.CompanyAgent.getAgentType().equals(userVo.getAgentType())){
            return companyAgent(context, userVo);
        }
        context.addErrorMsg("注册类型需要填写！");
        return false;
    }

    /**
     * 普通用户注册
     * @param context 上下文
     * @param userVo 界面用户信息
     * @return 是否成功
     */
    private boolean commonUser(ValidatorContext context, UserVo userVo){
        if(StringUtils.isEmpty(userVo.getCertificate())){
            context.addErrorMsg("请上传身份证照片");
        }
        return true;
    }

    /**
     * 用户代理商
     * @param context 上下文
     * @param userVo 界面用户信息
     * @return 是否成功
     */
    private boolean userAgent(ValidatorContext context, UserVo userVo){
        if(StringUtils.isEmpty(userVo.getCertificate())){
            context.addErrorMsg("请上传身份证照片");
            return false;
        }
        JSONObject certificateJSONObject = JSONObject.parseObject(userVo.getCertificate());
        if(StringUtils.isEmpty(certificateJSONObject.getString(CertificateEnum.FACE.getValue()))){
            context.addErrorMsg("请上传身份证正面照片");
            return false;
        }
        if(StringUtils.isEmpty(certificateJSONObject.getString(CertificateEnum.BACKGROUND.getValue()))){
            context.addErrorMsg("请上传身份证背面照片");
            return false;
        }
        if(StringUtils.isEmpty(certificateJSONObject.getString(CertificateEnum.HAND.getValue()))){
            context.addErrorMsg("请上传手持身份证照片");
            return false;
        }
        if(StringUtils.isEmpty(userVo.getBankAccount())){
            context.addErrorMsg("请填写银行卡号码");
            return false;
        }
        if(StringUtils.isEmpty(userVo.getBankName())){
            context.addErrorMsg("请填写银行卡所在银行名称");
            return false;
        }

        return true;
    }

    /**
     * 公司代理商
     * @param context 上下文
     * @param userVo 界面用户信息
     * @return 是否成功
     */
    private boolean companyAgent(ValidatorContext context, UserVo userVo){
        if(StringUtils.isEmpty(userVo.getCertificate())){
            context.addErrorMsg("请上传营业执照");
            return false;
        }
        JSONObject certificateJSONObject = JSONObject.parseObject(userVo.getCertificate());
        if(StringUtils.isEmpty(certificateJSONObject.getString(CertificateEnum.BUSINESS_LICENSE.getValue()))){
            context.addErrorMsg("请上传营业执照照片");
            return false;
        }
        if(StringUtils.isEmpty(userVo.getAgentName())){
            context.addErrorMsg("请填写结构名称");
            return false;
        }
        if(StringUtils.isEmpty(userVo.getAgentNum())){
            context.addErrorMsg("请填写结构编码");
            return false;
        }
        if(StringUtils.isEmpty(userVo.getBankAccount())){
            context.addErrorMsg("请填写对公账号");
            return false;
        }
        return true;
    }

}
