package com.cgzdh.buss.domain.dto;


import lombok.Data;

/**
 * @author abo
 */
@Data
public class Order {
    private String tradeNo;
    private String goodsName;
    private String totalFee;
    private String goodsDesc;
    /**
     * 订单标题
     */
    private String subject;
}
