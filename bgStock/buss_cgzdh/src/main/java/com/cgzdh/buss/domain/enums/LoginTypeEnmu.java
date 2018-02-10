package com.cgzdh.buss.domain.enums;

/**
 * 登陆类型
 * @author v_bbojiang
 */
public enum  LoginTypeEnmu {
    /**
     * 用户名登录
     */
    USERNAME(1),
    /**
     * 手机号登录
     */
    PHONE(2);

    private int type;

    LoginTypeEnmu(int type){
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
