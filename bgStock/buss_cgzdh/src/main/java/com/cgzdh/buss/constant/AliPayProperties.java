package com.cgzdh.buss.constant;



import com.cgzdh.buss.util.Util;

import java.util.Properties;

public class AliPayProperties {

    /**
     * 支付宝提供给商户的服务接入网关URL(新)
     */
    public static final String ALIPAY_GATEWAY_NEW = "https://mapi.alipay.com/gateway.do?";

    /**
     * 数字组成的字符串
     */
    public static String partner = "";

    /**
     * 支付宝的公钥，无需修改该值
     */
    public static String aliPublicKey = "";

    /**
     * 字符编码格式 目前支持 gbk 或 utf-8
     */
    public static String charset = "utf-8";

    /**
     * 支付签名方式 不需修改
     */
    public static String signType = "MD5";

    /**
     * 卖家支付宝帐户
     */
    public static String sellerEmail = "";
    public static String domain="";
    public static String defaultbank="";
    /**
     * 服务器异步通知页面路径为银行支付
     */
    public static final String notify_url = "/pay/alipay/notify";
    /**
     * 服务器异步通知页面路径为即时到帐支付
     */
    public static final String notify_url_direct = "/pay/alipay/notifydirect";
    /**
     * 服务成功直接返回页面路径
     */
    public static String return_url = "";

    /**
     * 服务成功直接返回页面路径用于移动端
     */
    public static String m_return_url = "";
    /**
     * 服务器异步通知页面路径
     */
    public static String showUrl = "";
    
    public static void init() {
    	  Properties properties = Util.getProperties("/payconfig/ali/alipayconfig.properties");
        AliPayProperties.partner =properties.getProperty("partner");
        AliPayProperties.aliPublicKey =properties.getProperty("aliPublicKey");
        AliPayProperties.sellerEmail =properties.getProperty("sellerEmail");
        AliPayProperties.domain =properties.getProperty("domain");
        AliPayProperties.defaultbank =properties.getProperty("defaultbank");
        AliPayProperties.showUrl =properties.getProperty("showUrl");
        AliPayProperties.return_url =properties.getProperty("returnUrl");
        AliPayProperties.m_return_url =properties.getProperty("mreturnUrl");
    }
}
