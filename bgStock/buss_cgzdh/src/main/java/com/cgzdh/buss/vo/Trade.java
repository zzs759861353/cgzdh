package com.cgzdh.buss.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;


/**
 * 支付model类
 * @author v_bbojiang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trade implements PayTask{

    private Integer id;
	/**
	 * 订单号
	 */
	private String orderId;
	/**
	 * 描述
	 */
	private String body;
	/**
	 * 货币类型 ,暂时只支持人民
	 */
	private String feeType = "CNY";
	/**
	 * 订单总金额
	 */
	private BigDecimal totalFee;
    private double price;
	/**
	 * 支付方式(微信支付,支付宝支付)
	 */
	private int payType;
	/**
	 * 如使用第三方支付时的一些标示,只有使用特殊的支付方式时才需要
	 */
	private String openId;
	/**
	 * 如使用第三方支付时的一些标示,只有使用特殊的支付方式时才需要
	 */
	private String code;
	/**
	 * 支付完成后的返回页面，返回时将携带支付结果
	 */
	private String returnUrl;

	/**
	 * 第三方(微信,支付宝)的交易号
	 */
	private String outTradeId;

	/**
	 * 发起请求的时间
	 */
	private LocalDateTime requestTime;
	/**
	 * 获得结果的时间
	 */
	private LocalDateTime resultTime;

	/**
	 * 任务状态 1 成功 0 失败
	 */
	private int tradeStatus = 1;

	/**
	 * 调用端ip
	 */
	private String ip="";
    private int productId;
    private String productType;
    private int orderType;
    private int quantity;
    private String requestContent;
    private String returnContent;
    private String pageReturnContent;
    private String deviceInfo;
    private long phone;
    private int payStatus;
    private String finishTime;
    private String bank;
    /**
     * 0支付宝   1 微信 
     */
    private int source;
    
    private String coupon;
    
    private String orgName;

}
