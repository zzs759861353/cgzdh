package com.cgzdh.buss.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cgzdh.buss.config.AlipayConfig;
import com.cgzdh.buss.domain.dto.AccountDto;
import com.cgzdh.buss.domain.dto.Order;
import com.cgzdh.buss.util.AlipayNotify;
import com.cgzdh.buss.util.AlipaySubmit;
import com.cgzdh.buss.util.HttpClientUtil;
import com.cgzdh.buss.util.UUIDTool;
import com.cgzdh.buss.vo.Message;


/**
 * 支付宝交易
 * @author abo
 */
@RestController
@RequestMapping("ali")
public class AliPayController {

    @Autowired
    AlipayConfig alipayConfig;

    @GetMapping("index")
    public String index(){
        return "index";
    }
    @RequestMapping(value="/pay", method = RequestMethod.POST)
    public Message<String> pay_req(@RequestBody AccountDto order){
        //商户订单号，商户网站订单系统中唯一订单号，必填
        String outTradeNo =UUIDTool.getUUID();

        //订单名称，必填
        String subject = "量化交易";
 
        System.out.println(subject);
        //付款金额，必填
        String totalFee= order.getMoney().toString();

        //商品描述，可空
        String body ="";


        //把请求参数打包成数组
        Map<String, String> sParaTemp = new HashMap<String, String>();
        sParaTemp.put("service", alipayConfig.getService());
        sParaTemp.put("partner", alipayConfig.getPartner());
        sParaTemp.put("seller_id", alipayConfig.getSellerId());
        sParaTemp.put("_input_charset", alipayConfig.getInputCharset());
        sParaTemp.put("payment_type", alipayConfig.getPaymentType());
        sParaTemp.put("notify_url", alipayConfig.getNotifyUrl());
        sParaTemp.put("return_url", alipayConfig.getReturnUrl());
        sParaTemp.put("anti_phishing_key", alipayConfig.getAntiPhishingKey());
        sParaTemp.put("exter_invoke_ip", alipayConfig.getExterInvokeIp());
        sParaTemp.put("out_trade_no", outTradeNo);
        sParaTemp.put("subject", subject);
        sParaTemp.put("total_fee", totalFee);
        sParaTemp.put("body", body);
        String sHtmlText = AlipaySubmit.buildRequest(sParaTemp,"get","确认",alipayConfig);
        
        try {
        	 return Message.successMessage(new HttpClientUtil().doGet(sHtmlText));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
       
    }
    @RequestMapping(value="/Spay_notify", method = RequestMethod.POST)
    public Message pay_notify(HttpServletRequest request)throws Exception{
        //获取支付宝POST过来反馈信息
        Map<String,String> params = new HashMap<String,String>();
        Map requestParams = request.getParameterMap();
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }

            params.put(name, valueStr);
        }

        //获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
        //商户订单号

        String outTradeNo = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");

        //支付宝交易号

        String tradeNo = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");

        //交易状态
        String tradeStatus = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"),"UTF-8");

        //验证成功
        if(AlipayNotify.verify(params,alipayConfig)){

            String TradeFinished="TRADE_FINISHED";
            String TradeSuccess="TRADE_SUCCESS";

            if( TradeFinished.equals(tradeStatus)){
                //判断该笔订单是否在商户网站中已经做过处理

            } else if ( TradeSuccess.equals(tradeStatus)){
                //判断该笔订单是否在商户网站中已经做过处理

            }
            return Message.successMessage(null);

        }else{
            return Message.failMessage();
        }

    }
    @RequestMapping("pay_return")
    public Message pay_return(HttpServletRequest request)throws Exception{
    	System.out.println("11111");
    	System.out.println("11111");
    	System.out.println("11111");
    	System.out.println("11111");
        //获取支付宝GET过来反馈信息
        Map<String,String> params = new HashMap<String,String>();
        Map requestParams = request.getParameterMap();
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
            valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }

        //获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
        //商户订单号

        String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");

        //支付宝交易号

        String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");

        //交易状态
        String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"),"UTF-8");

        //获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//

        //计算得出通知验证结果
        boolean verify_result = AlipayNotify.verify(params,alipayConfig);
        //验证成功
        if(!verify_result){
            return Message.successMessage(null);
        }
        String TradeFinished="TRADE_FINISHED";
        String TradeSuccess="TRADE_SUCCESS";
        if( TradeFinished.equals(trade_status) ||  TradeSuccess.equals(trade_status)){

        }

        return Message.failMessage();
    }
}
