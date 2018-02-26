package com.cgzdh.buss.util;

import org.joda.time.DateTime;

import com.alibaba.fastjson.JSONObject;
import com.cgzdh.buss.config.AlipayConfig;

public class AliQrCodePay {


    public String getQrCode(com.cgzdh.buss.domain.dto.Order order,AlipayConfig alipayConfig) throws AlipayApiException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("out_trade_no",order.getTradeNo());
        jsonObject.put("total_amount",order.getTotalFee());
        jsonObject.put("subject",order.getSubject());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(AlipayConfig.ALIPAY_GATEWAY_NEW);

        StringBuilder stringParamBuilder = new StringBuilder();
        stringParamBuilder.append("app_id=").append(alipayConfig.getAppId());
        stringParamBuilder.append("&biz_content=").append(jsonObject.toJSONString());
        stringParamBuilder.append("&method=alipay.trade.precreate");
        stringParamBuilder.append("&sign_type=").append(alipayConfig.getQrCodesignType());
        stringParamBuilder.append("&timestamp=").append(new DateTime().toString("yyyy-MM-dd HH:mm:ss"));
        String sign = AlipaySignature.rsaSign(stringParamBuilder.toString(), alipayConfig.getPrivkey(), alipayConfig.getInputCharset(), alipayConfig.getQrCodesignType());
        stringParamBuilder.append("&sign=").append(sign);

        String ss="app_id=2018020302137294&amp;biz_content={&quot;out_trade_no&quot;:&quot;20147814645678555&quot;,&quot;total_amount&quot;:&quot;12000&quot;,&quot;subject&quot;:&quot;aaa&quot;}&amp;method=alipay.trade.precreate&amp;sign_type=RSA2&amp;timestamp=2018-02-16 11:49:17";
        System.out.println(AlipaySignature.rsaSign(ss, alipayConfig.getPubKey(), alipayConfig.getInputCharset(), alipayConfig.getQrCodesignType()));
        System.out.println(sign);
        stringBuilder.append(stringParamBuilder);
        return stringBuilder.toString();
    }



}
