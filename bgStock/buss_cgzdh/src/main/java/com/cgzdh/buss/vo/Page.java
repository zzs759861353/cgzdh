package com.cgzdh.buss.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 分页
 * @param <T>
 */
public class Page<T> {

   @Getter @Setter private Integer total;

    @Getter @Setter private Integer pageSize;

    @Getter @Setter    private Integer pageNum;

    @Getter @Setter   private Integer totalSize;
    /** 查询结果 **/
    @Getter @Setter private List<T> result;

    public Page(int total,int pageNum,int pageSize) {
        this.total = total;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        if(pageSize == 0){
            return;
        }
        this.totalSize= (total%pageSize==0)?total/pageSize:total/pageSize+1;
    }

    public Page() { }




}
