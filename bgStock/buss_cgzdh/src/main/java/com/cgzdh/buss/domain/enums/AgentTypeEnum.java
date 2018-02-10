package com.cgzdh.buss.domain.enums;

/**
 * 代理商类型
 * @author v_bbojiang
 */
public enum AgentTypeEnum {

    /**
     * 个人代理商
     */
    UserAgent(1),
    /**
     * 公司代理商
     */
    CompanyAgent(2);

    private Integer agentType;
    AgentTypeEnum(Integer agentType){
        this.agentType = agentType;
    }

    public Integer getAgentType() {
        return agentType;
    }
}
