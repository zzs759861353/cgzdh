package com.cgzdh.buss.domain.enums;

import lombok.Getter;

/**
 * @author bo
 */
public enum ErrorEnum {

    /**
     * 参数异常
     */
    PARAM(600,"param error");

    @Getter private int code;
    @Getter private String msg;
    ErrorEnum(int code,String msg){
    this.code=code;
    this.msg=msg;
    }
}
