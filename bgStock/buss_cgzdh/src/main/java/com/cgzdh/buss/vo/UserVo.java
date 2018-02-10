package com.cgzdh.buss.vo;

import lombok.Getter;
import lombok.Setter;


/***
 * 用户信息
 * @author v_bbojiang
 */
public class UserVo  {

    /***
     * 联系方式
     */
    @Getter @Setter private String mobile;
    /**
     * 用户名用户账号
     */
    @Getter @Setter private String userName;
    /**
     * 推荐人
     */
    @Getter @Setter private String recommendId;
    /**
     * 密码
     */
    @Getter @Setter private String password;
    /**
     * 密码
     */
    @Getter @Setter private String agentId;
    /**
     * qq
     */
    @Getter @Setter private String qq;
    /**
     * 微信
     */
    @Getter @Setter private String wx;


    /**
     * 是否代理商
     */
    @Getter @Setter private boolean isAgent;

    /**
     * 法人姓名
     */
    @Getter @Setter private String legalUserName;

    /**
     * 代理商机构名称
     */
    @Getter @Setter private Integer agentName;

    /**
     * 代理商类型
     */
    @Getter @Setter private Integer agentType;

    /**
     * 机构编码
     */
    @Getter @Setter private Integer agentNum;
    /**
     * 银行名称
     */
    @Getter @Setter private String bankName;
    /**
     * 银行类型
     */
    @Getter @Setter private String bankType;

    /**
     * 银行账号
     */
    @Getter @Setter private String bankAccount;

    /**
     * 营业执照 身份证正反面   手持身份证照片
     */
    @Getter @Setter private String certificate;
    /**
     * 是否同意协议书
     */
    @Getter @Setter private boolean isAgreement;





}
