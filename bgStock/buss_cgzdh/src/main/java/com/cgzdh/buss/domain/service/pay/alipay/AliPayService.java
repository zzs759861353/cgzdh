package com.cgzdh.buss.domain.service.pay.alipay;


import com.cgzdh.buss.constant.AliPayProperties;
import com.cgzdh.buss.exception.DbException;
import com.cgzdh.buss.vo.PayTask;
import com.cgzdh.buss.vo.ResultModel;
import com.cgzdh.buss.vo.Trade;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author v_bbojiang
 */
@Service
public class AliPayService implements InitializingBean {



	public ResultModel sendDataForDirectPayForbank(Trade trade) {

		
		//////////////////////////////////// 请求参数//////////////////////////////////////

		// 支付类型
		String payment_type = "1";
		// 必填，不能修改
		// 服务器异步通知页面路径
		String notify_url = AliPayProperties.domain+AliPayProperties.notify_url;
		// 需http://格式的完整路径，不能加?id=123这类自定义参数

		// 页面跳转同步通知页面路径
		String return_url =AliPayProperties.return_url;
		// 需http://格式的完整路径，不能加?id=123这类自定义参数，不能写成http://localhost/

		// 商户订单号
		String out_trade_no = trade.getOrderId();
		// 商户网站订单系统中唯一订单号，必填

		// 订单名称
		String subject =trade.getBody();
		// 必填

		// 付款金额
		String total_fee =String.valueOf(trade.getTotalFee());
		// 必填

		// 订单描述

		String body =trade.getBody();
		// 默认支付方式
		String paymethod = "bankPay";
		
		//超时时间
		String itBPay = "1m";
		//选填
		//////////////////////////////////////////////////////////////////////////////////

		// 把请求参数打包成数组
		Map<String, String> sParaTemp = new HashMap<String, String>();
		sParaTemp.put("service", "create_direct_pay_by_user");
		sParaTemp.put("partner", AliPayProperties.partner);
		sParaTemp.put("seller_email", AliPayProperties.sellerEmail);
		sParaTemp.put("_input_charset", AliPayProperties.charset);
		sParaTemp.put("payment_type", payment_type);
		sParaTemp.put("notify_url", notify_url);
		sParaTemp.put("return_url", return_url);
		sParaTemp.put("out_trade_no", out_trade_no);
		sParaTemp.put("subject", subject);
		sParaTemp.put("total_fee", total_fee);
		
		sParaTemp.put("paymethod", paymethod);
		sParaTemp.put("defaultbank", trade.getBank());


		String requestContent="";
		   for (int i = 0; i < sParaTemp.keySet().size(); i++) {
	            String name = sParaTemp.get(i);
	            String value = sParaTemp.get(i);
	            requestContent+=name+":"+value+"|";
	           
	        }
		
		trade.setRequestContent(requestContent);
		trade.setTradeStatus(PayTask.STATUS_ACCEPTED);

		if (StringUtils.isEmpty(trade.getOrderId())) {

			//错误处理
		}
		trade.setRequestTime(java.time.LocalDateTime.now());

		
		// 建立请求
		String sHtmlText = AliPayHelper.buildRequest(sParaTemp, "get", "ok");
		
		return ResultModel.successModel(sHtmlText);
	}

		public ResultModel sendDataForDirectPay(Trade trade) {

		
		//////////////////////////////////// 请求参数//////////////////////////////////////

		// 支付类型
		String payment_type = "1";
		// 必填，不能修改
		// 服务器异步通知页面路径
		String notify_url = AliPayProperties.domain+AliPayProperties.notify_url_direct;
		// 需http://格式的完整路径，不能加?id=123这类自定义参数

		// 页面跳转同步通知页面路径
		String return_url =AliPayProperties.return_url;
		// 需http://格式的完整路径，不能加?id=123这类自定义参数，不能写成http://localhost/

		// 商户订单号
		String out_trade_no = trade.getOrderId();
		// 商户网站订单系统中唯一订单号，必填

		// 订单名称
		String subject =trade.getBody();
		// 必填

		// 付款金额
		String total_fee =String.valueOf(trade.getTotalFee());
		// 必填

		// 订单描述

		String body =trade.getBody();
	
		//超时时间
		String itBPay = "1m";
		//选填
		//////////////////////////////////////////////////////////////////////////////////

		// 把请求参数打包成数组
		Map<String, String> sParaTemp = new HashMap<String, String>();
		sParaTemp.put("service", "create_direct_pay_by_user");
		sParaTemp.put("partner", AliPayProperties.partner);
		sParaTemp.put("seller_email", AliPayProperties.sellerEmail);
		sParaTemp.put("_input_charset", AliPayProperties.charset);
		sParaTemp.put("payment_type", payment_type);
		sParaTemp.put("notify_url", notify_url);
		sParaTemp.put("return_url", return_url);
		sParaTemp.put("out_trade_no", out_trade_no);
		sParaTemp.put("subject", subject);
		sParaTemp.put("total_fee", total_fee);
		sParaTemp.put("paymethod", "");
		sParaTemp.put("defaultbank","");


		String requestContent="";
		   for (int i = 0; i < sParaTemp.keySet().size(); i++) {
	            String name = sParaTemp.get(i);
	            String value = sParaTemp.get(i);
	            requestContent+=name+":"+value+"|";
	           
	        }
		
		trade.setRequestContent(requestContent);
		trade.setTradeStatus(PayTask.STATUS_ACCEPTED);

		if (StringUtils.isEmpty(trade.getOrderId())) {

			throw new DbException(500,"订单不存在");
		}
		trade.setRequestTime(java.time.LocalDateTime.now());

		
		// 建立请求
		String sHtmlText = AliPayHelper.buildRequest(sParaTemp, "get", "ok");
		
		return ResultModel.successModel(sHtmlText);
	}

	public ResultModel sendDataForWAPDirectPay(Trade trade) {

		
				//支付类型
				String payment_type = "1";
				// 必填，不能修改
				// 服务器异步通知页面路径
				String notify_url = AliPayProperties.domain+AliPayProperties.notify_url;
				// 需http://格式的完整路径，不能加?id=123这类自定义参数

				// 页面跳转同步通知页面路径
				String return_url =AliPayProperties.m_return_url;
				// 需http://格式的完整路径，不能加?id=123这类自定义参数，不能写成http://localhost/

				//商户订单号
				String out_trade_no = trade.getOrderId();
				//商户网站订单系统中唯一订单号，必填

				//订单名称
				String subject = trade.getBody();
				//必填

				//付款金额
				String total_fee = String.valueOf(trade.getTotalFee());
				//必填

				
				//订单描述
				String body = trade.getBody();
				//选填
				//超时时间
				String itBPay = "1m";

				
				//////////////////////////////////////////////////////////////////////////////////
				
				//把请求参数打包成数组
				Map<String, String> sParaTemp = new HashMap<String, String>();
				sParaTemp.put("service", "alipay.wap.create.direct.pay.by.user");
		        sParaTemp.put("partner", AliPayProperties.partner);
		        sParaTemp.put("seller_id", AliPayProperties.partner);
		        sParaTemp.put("_input_charset", AliPayProperties.charset);
				sParaTemp.put("payment_type", payment_type);
				sParaTemp.put("notify_url", notify_url);
				sParaTemp.put("return_url", return_url);
				sParaTemp.put("out_trade_no", out_trade_no);
				sParaTemp.put("subject", subject);
				sParaTemp.put("total_fee", total_fee);
				sParaTemp.put("show_url", AliPayProperties.showUrl);
				sParaTemp.put("body", body);
				sParaTemp.put("it_b_pay", itBPay);
				String requestContent="";
				   for (int i = 0; i < sParaTemp.keySet().size(); i++) {
			            String name = sParaTemp.get(i);
			            String value = sParaTemp.get(i);
			            requestContent+=name+":"+value+"|";
			           
			        }
				
				
				trade.setRequestContent(requestContent);
				trade.setTradeStatus(PayTask.STATUS_ACCEPTED);

				if (StringUtils.isEmpty(trade.getOrderId())) {

					//错误处理
				}

				//建立请求
				String sHtmlText = AliPayHelper.buildRequest(sParaTemp,"get","ok");
				
				return ResultModel.successModel(sHtmlText);
	}

	@Override
	public void afterPropertiesSet() {

	}

}
