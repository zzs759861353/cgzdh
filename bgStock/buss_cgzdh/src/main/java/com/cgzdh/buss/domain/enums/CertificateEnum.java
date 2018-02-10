package com.cgzdh.buss.domain.enums;

public enum CertificateEnum {
    /**
     * 个人身份证照片正面
     */
    FACE("Face"),
    /**
     * 个人身份证照片背面
     */
    BACKGROUND("background"),
    /**
     * 个人手持身份证照片
     */
    HAND("hand"),
    /**
     *
     */
    BUSINESS_LICENSE("bussLicense");
    private String value;
    CertificateEnum(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
