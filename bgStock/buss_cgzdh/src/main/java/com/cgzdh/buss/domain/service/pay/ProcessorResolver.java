package com.cgzdh.buss.domain.service.pay;


import com.cgzdh.buss.vo.PayTask;

/**
 * @author v_bbojiang
 */
public interface ProcessorResolver<T extends PayTask>{

    /**
     * 1
     * @param task
     * @return
     */
    Class<? extends Processor> resolve(T task);

}
