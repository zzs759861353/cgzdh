package com.cgzdh.buss.vo;

import lombok.Data;

@Data
public class Message<T> {
    private int code ;
    private String msg;
    private T object;

    public static <T> Message<T>  successMessage(T object){
        Message<T> message = new Message<>();
        message.setCode(200);
        message.setMsg("成功");
        message.setObject(object);
        return message;
    }
    public static  Message failMessage(){
        Message message = new Message();
        message.setCode(500);
        message.setMsg("失败");
        return message;
    }
}
