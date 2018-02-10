package com.cgzdh.buss.controller;


import com.cgzdh.buss.constant.AliPayProperties;
import com.cgzdh.buss.domain.service.pay.ProcessorManager;
import com.cgzdh.buss.domain.service.pay.alipay.AliPayHelper;
import com.cgzdh.buss.util.PayStatus;
import com.cgzdh.buss.vo.PayTask;
import com.cgzdh.buss.vo.Trade;

import io.swagger.annotations.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

/**
 * @author v_bbojiang
 */
@Controller
@Api(value = "支付宝支付接口")
public class AliPayController {
	@Autowired
	ProcessorManager processorManager;

	@RequestMapping(value = AliPayProperties.notify_url,method = RequestMethod.POST)
	public void notify(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// 获取支付宝POST过来反馈信息
		Map<String, String> params = handerRequestParams(request.getParameterMap());
		String requestContent = "";

		// 获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
		// 商户订单号
        if(request.getParameter("out_trade_no")==null){
        	
        	return;
        }
		String outTradeNo = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");

		// 支付宝交易号

		String tradeNo = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");

		// 交易状态
		String tradeStatus = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"), "UTF-8");
		// 交易状态
		String totalFee = new String(request.getParameter("total_fee").getBytes("ISO-8859-1"), "UTF-8");
		// 获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)
		PrintWriter out = response.getWriter();
		// 验证成功
		if (AliPayHelper.verify(params)) {
			

			Trade payResult = new Trade();
			payResult.setPayStatus(
					"TRADE_SUCCESS".equals(tradeStatus) ? PayStatus.STATUS_SUCCESS : PayStatus.STATUS_FAIL);
			payResult.setTradeStatus(
					"TRADE_SUCCESS".equals(tradeStatus) ? PayTask.STATUS_SUCCESS : PayTask.STATUS_FAIL);
			payResult.setTotalFee(new BigDecimal(totalFee));
			payResult.setOrderId(outTradeNo);
			payResult.setOutTradeId(tradeNo);
			payResult.setReturnContent(requestContent);
			payResult.setResultTime(LocalDateTime.now());
			//来源为阿里银行
			payResult.setSource(2);
			processorManager.process(payResult);

			out.write("sucess");
			// 验证失败
		} else {
			out.write("failure");
		}

		out.flush();
		out.close();
	}

	private Map<String, String> handerRequestParams(Map requestParams){
		Map<String, String> params = new HashMap<>(16);
		Set entrySet = requestParams.entrySet();
		entrySet.forEach((Consumer<Map.Entry<String, Object>>) entry -> {
            String name = entry.getKey();
            String[] values = (String[]) entry.getValue();
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            params.put(name, valueStr);
        });
		return params;
	}
	
	@RequestMapping(value = AliPayProperties.notify_url_direct,method = RequestMethod.POST)
	public void notifyDirect(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// 获取支付宝POST过来反馈信息
		Map<String, String> params = handerRequestParams(request.getParameterMap());
		String requestContent = "";


		// 获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
		// 商户订单号
		  if(request.getParameter("out_trade_no")==null){
	        	
	        	return;
	        }
		String outTradeNo = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");

		// 支付宝交易号

		String tradeNo = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");

		// 交易状态
		String tradeStatus = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"), "UTF-8");
		// 交易状态
		String totalFee = new String(request.getParameter("total_fee").getBytes("ISO-8859-1"), "UTF-8");
		// 获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//
		PrintWriter out = response.getWriter();
		// 验证成功
		if (AliPayHelper.verify(params)) {
			

			Trade payResult = new Trade();
			payResult.setPayStatus(
					"TRADE_SUCCESS".equals(tradeStatus) ? PayStatus.STATUS_SUCCESS : PayStatus.STATUS_FAIL);
			payResult.setTradeStatus(
					"TRADE_SUCCESS".equals(tradeStatus) ? PayTask.STATUS_SUCCESS : PayTask.STATUS_FAIL);
			payResult.setTotalFee(new BigDecimal(totalFee));
			payResult.setOrderId(outTradeNo);
			payResult.setOutTradeId(tradeNo);
			payResult.setReturnContent(requestContent);
			payResult.setResultTime(LocalDateTime.now());
			//来源为即时到帐
			payResult.setSource(0);
			processorManager.process(payResult);

			out.write("sucess");
			// 验证失败
		} else {
			out.write("failure");
		}

		out.flush();
		out.close();
	}
}
