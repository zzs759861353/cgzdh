package com.cgzdh.buss.vo;


/**
 * @author v_bbojiang
 */
public final class ResultModel {

    public static final int RETURN_CODE_SUCCESS = 0;
    public static final int RETURN_CODE_FAIL = 1;

    private ResultModel(int code, Object body) {
        this.code = code;
        this.body = body;
    }

    private int code = 0;
    private Object body;


    public int getCode() {
        return code;
    }
    public Object getBody() {
        return body;
    }
    public void setBody(Object body) {
        this.body = body;
    }
    public boolean isSuccess(){
        return getCode() == ResultModel.RETURN_CODE_SUCCESS;
    }
    public boolean isFail(){
        return getCode() != ResultModel.RETURN_CODE_SUCCESS;
    }


    public static ResultModel buildModel(boolean flag){
        if(flag) {
            return ResultModel.successModel();
        }
        return ResultModel.failModel();
    }
    public static ResultModel successModel(){
        return ResultModel.successModel("");
    }
    public static ResultModel successModel(Object body){
        return new ResultModel(ResultModel.RETURN_CODE_SUCCESS,body);
    }
    public static ResultModel failModel(){
        return ResultModel.failModel("");
    }
    public static ResultModel failModel(Object body){
        return new ResultModel(ResultModel.RETURN_CODE_FAIL,body);
    }
}
