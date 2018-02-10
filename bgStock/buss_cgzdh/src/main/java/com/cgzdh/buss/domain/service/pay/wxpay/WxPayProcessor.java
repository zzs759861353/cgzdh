package com.cgzdh.buss.domain.service.pay.wxpay;


import com.cgzdh.buss.domain.service.pay.Processor;
import com.cgzdh.buss.vo.ResultModel;
import com.cgzdh.buss.vo.Trade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * @author v_bbojiang
 */
@Component
public class WxPayProcessor implements Processor<Trade> {

    @Autowired
    WxPayService wxPayService;

    @Override
    public ResultModel process(Trade trade)  {

        ResultModel serviceResult = wxPayService.getPayJson(trade);
        if( !serviceResult.isSuccess() ){
            return serviceResult;
        }

       
        return ResultModel.successModel(serviceResult.getBody());
    }

}
