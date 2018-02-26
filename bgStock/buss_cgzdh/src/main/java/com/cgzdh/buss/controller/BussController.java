package com.cgzdh.buss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cgzdh.buss.domain.dto.LoginDto;
import com.cgzdh.buss.domain.service.BussService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "业务模块接口")
@RequestMapping("/buss")
public class BussController {

	@Autowired
	private BussService bussService;
	@ApiOperation(value = "账户登录")
	@RequestMapping(value = "/gp_login", method = RequestMethod.POST)
	public int gp_login(@RequestBody LoginDto dto) {

		return bussService.gp_login(dto);
	}
	@ApiOperation(value = "买卖交易")
	@RequestMapping(value = "/gp_query", method = RequestMethod.GET)
	public String gp_deal(@RequestParam(value = "clientId", required = true) int clientId,
			@RequestParam(value = "user", required = true) String user,
			@RequestParam(value = "code", required = true) int code) {
		
		return bussService.gp_deal(clientId, user, code);
	}
	@ApiOperation(value = "撤单")
	@RequestMapping(value = "/gp_cancellations", method = RequestMethod.GET)
	public String gp_cancellations(@RequestParam(value = "clientId", required = true) int clientId,
			@RequestParam(value = "user", required = true) String user,
			@RequestParam(value = "wtbh", required = true) String wtbh,
			@RequestParam(value = "lx", required = true) int lx) {
		return bussService.gp_cancellations(clientId, user, wtbh, lx);
	}
	@ApiOperation(value = "查询账户信息")
	@RequestMapping(value = "/gp_deal", method = RequestMethod.GET)
	public String gp_query(@RequestParam(value = "clientId", required = true) int clientId,
			@RequestParam(value = "type", required = true) int type,
			@RequestParam(value = "user", required = true) String user,
			@RequestParam(value = "gdCode", required = true) String gdCode,
			@RequestParam(value = "gpCode", required = true) String gpCode,
			@RequestParam(value = "count", required = true) int count,
			@RequestParam(value = "price", required = true) float price) {
		return bussService.gp_query(clientId, type, user, gdCode, gpCode, count, price);
	}

}
