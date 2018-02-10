package com.cgzdh.buss.vo;


/**
 * @author v_bbojiang
 */
public interface PayTask {

    /**
     * 已接收
     */
    int STATUS_ACCEPTED = 0;
    /**
     * 正在进行
     */
    int STATUS_TRYING = 1;
    /**
     * 失败
     */
    int STATUS_FAIL = 2;
    /**
     * 成功
     */
    int STATUS_SUCCESS = 3;
    /**
     * 未得到第三方支付响应提供的预支付id
     */
    int STATUS_FirstFailed_pre=4;
    /**
     * 未得到第三方支付响应提供的codeurl
     */
    int STATUS_FirstFailed_qc=5;
    
  

   
}
