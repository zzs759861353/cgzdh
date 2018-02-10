package com.cgzdh.buss.domain.service.pay;


import com.cgzdh.buss.vo.PayTask;
import com.cgzdh.buss.vo.ResultModel;

public interface Processor<T extends PayTask> {

    ResultModel process(T t);

}
