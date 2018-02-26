package com.cgzdh.buss.util;

import java.util.UUID;

public class UUIDTool {
	 /**  
     * 自动生成32位的UUid，对应数据库的主键id进行插入用。  
     * @return  
     */  
    public static String getUUId() {         
        return UUID.randomUUID().toString().replace("-", "");  
    }  
    public static String getUUID() {
        int machineId = 1;//最大支持1-9个集群机器部署
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        if(hashCodeV < 0) {//有可能是负数
            hashCodeV = - hashCodeV;
        }
        // 0 代表前面补充0     
        // 4 代表长度为4     
        // d 代表参数为正数型
        System.out.println(machineId + String.format("%015d", hashCodeV));
        return machineId + String.format("%015d", hashCodeV);
    }
  
}
