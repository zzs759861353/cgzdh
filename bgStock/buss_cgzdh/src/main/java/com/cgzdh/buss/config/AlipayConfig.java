package com.cgzdh.buss.config;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * 类名：AlipayConfig
 * 功能：基础配置类
 * 详细：设置帐户有关信息及返回路径
 * @author abo
 */
@Configuration
@Data
public class AlipayConfig {

    /**
     * 合作身份者ID，签约账号，以2088开头由16位纯数字组成的字符串，查看地址：https://b.alipay.com/order/pidAndKey.htm
     */
    @Value("${alipay.partner}")
    private  String partner;

    @Value("${alipay.appId}")
    private String appId;

    /**
     * 收款支付宝账号，以2088开头由16位纯数字组成的字符串，一般情况下收款账号就是签约账号
     */
    @Value("${alipay.seller_id}")
    private String sellerId;

    /**
     * MD5密钥，安全检验码，由数字和字母组成的32位字符串，查看地址：https://b.alipay.com/order/pidAndKey.htm
     */
    @Value("${alipay.key}")
    private String key;

    @Value("${alipay.pubkey}")
    private String pubKey;

    @Value("${alipay.privkey}")
    private String privkey;



    /**
     * 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
     */
    @Value("${alipay.notify_url}")
    private String notifyUrl;

    /**
     * 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
     */
    @Value("${alipay.return_url}")
    private String returnUrl;

    /**
     * 签名方式
     */
    @Value("${alipay.sign_type}")
    private String signType;

    @Value("${alipay.qrcode.sign_type}")
    private String qrCodesignType;

    /**
     * 调试用，创建TXT日志文件夹路径，见AlipayCore.java类中的logResult(String sWord)打印方法。
     */
    @Value("${alipay.log_path}")
    private String logPath;

    /**
     * 字符编码格式 目前支持 gbk 或 utf-8
     */
    @Value("${alipay.input_charset}")
    private String inputCharset;

    /**
     * 支付类型 ，无需修改
     */
    @Value("${alipay.payment_type}")
    private String paymentType;

    /**
     * 调用的接口名，无需修改
     */
    @Value("${alipay.service}")
    private String service;


    /**
     * 防钓鱼时间戳  若要使用请调用类文件submit中的query_timestamp函数
     */
    @Value("${alipay.anti_phishing_key}")
    private String antiPhishingKey;

    /***
     * 客户端的IP地址 非局域网的外网IP地址，如：221.0.0.1
     */
    @Value("${alipay.exter_invoke_ip}")
    private String exterInvokeIp;


    public final static String ALIPAY_GATEWAY_NEW ="https://mapi.alipay.com/gateway.do?_input_charset=utf-8";
//    public final static String ALIPAY_GATEWAY_NEW ="https://mapi.alipay.com/gateway.do?";

}

