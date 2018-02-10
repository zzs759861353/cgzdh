package com.cgzdh.buss.vo.validate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Message<T> {
    private int code;
    private  T obj;
    private String msg;

    public Message(){
        this.code = 200;
        this.msg = "成功";
    }

}
