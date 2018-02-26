package com.cgzdh.buss.controller;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cgzdh.buss.domain.dto.AccountDto;
import com.cgzdh.buss.domain.model.AccountDetail;
import com.cgzdh.buss.domain.service.AccountService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 账户列表操作
 * @author v_bbojiang
 */
@Api(value = "充值记录接口")
@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    /**
     * 获取个人或者机构的会员充值记录
     * @param pageSize 分页大小
     * @param pageNum 页码
     * @param agentId 机构编号
     * @param userId 用户id
     * @param month 年月 YYYY-MM
     * @return 充值记录列表
     */
    @ApiOperation(value="获取个人或者机构的会员充值记录", notes="获取个人或者机构的会员充值记录")
    @RequestMapping(value = "/user/account",method = RequestMethod.POST)
    public @ResponseBody Page<AccountDetail> getUserAccount(@RequestBody AccountDto ad ){
         
        return accountService.getUserAccount(ad);
    }
    /**
     * 储存个人或者机构的会员充值记录
     * @param pageSize 分页大小
     * @param pageNum 页码
     * @param agentId 机构编号
     * @param userId 用户id
     * @param month 年月 YYYY-MM
     * @return 充值记录列表
     */
    @ApiOperation(value="储存个人或者机构的会员充值记录", notes="储存个人或者机构的会员充值记录")
    @RequestMapping(value = "/user/saveAccount",method = RequestMethod.POST)
    public  @ResponseBody AccountDetail saveAccount(@RequestBody AccountDetail ad ){
    	return  accountService.saveAccount(ad);
    }

    /**
     * 获取机构中的会员充值记录
     * @param pageSize 分页大小
     * @param pageNum 分页页码
     * @param agentId 机构编号
     * @param month 年月 YYYY-MM
     * @return
     */
    @ApiOperation(value="获取机构中的会员充值记录", notes="获取机构中的会员充值记录")
    @RequestMapping(value = "/agent/account",method = RequestMethod.POST)
    public @ResponseBody Page<AccountDetail> getAgentAccount(@RequestBody AccountDto ad ){
         
        return accountService.getAgentAccount(ad);
    }
    /**
     * 获取机构中的会员充值记录
     * @param pageSize 分页大小
     * @param pageNum 分页页码
     * @param agentId 机构编号
     * @param month 年月 YYYY-MM
     * @return
     */
    @ApiOperation(value="获取机构中的会员充值记录", notes="获取机构中的会员充值记录")
    @RequestMapping(value = "/agent/money",method = RequestMethod.POST)
    public @ResponseBody Map<String,Double> getAgentMoney(@RequestBody AccountDto ad ){
    	
    	return accountService.getAgentMoney(ad);
    }

}
