package com.cgzdh.buss.domain.service.pay.alipay;


import com.cgzdh.buss.constant.PayType;
import com.cgzdh.buss.domain.service.pay.Processor;
import com.cgzdh.buss.vo.ResultModel;
import com.cgzdh.buss.vo.Trade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * @author v_bbojiang
 */
@Component
public class AliPayProcessor implements Processor<Trade> {

	@Autowired
	AliPayService aliPayService;

	@Override
	public ResultModel process(Trade trade) {

		if (trade.getPayType() == PayType.ALI_PAY_NetBank) {

			ResultModel serviceResult = aliPayService.sendDataForDirectPayForbank(trade);
			if (!serviceResult.isSuccess()) {
				return serviceResult;
			}

			return ResultModel.successModel(serviceResult.getBody());
		}
		if (trade.getPayType() == PayType.ALI_PAY_Direct) {

			ResultModel serviceResult = aliPayService.sendDataForDirectPay(trade);
			if (!serviceResult.isSuccess()) {
				return serviceResult;
			}

			return ResultModel.successModel(serviceResult.getBody());
		}
		if (trade.getPayType() == PayType.ALI_PAY_WAP) {

			ResultModel serviceResult = aliPayService.sendDataForWAPDirectPay(trade);
			if (!serviceResult.isSuccess()) {
				return serviceResult;
			}

			return ResultModel.successModel(serviceResult.getBody());
		}

		return ResultModel.failModel();
	}

}
