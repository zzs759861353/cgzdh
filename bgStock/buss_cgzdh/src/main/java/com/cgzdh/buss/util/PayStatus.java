package com.cgzdh.buss.util;


/**
 * @author v_bbojiang
 */
public interface PayStatus {

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


}
