package com.cgzdh.buss.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.cgzdh.buss.domain.dto.AccountDto;
import com.cgzdh.buss.domain.dto.TUserDto;
import com.cgzdh.buss.domain.model.TUser;
import com.cgzdh.buss.domain.service.TUserService;
import com.cgzdh.buss.exception.DbException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "用户管理接口", basePath = "/cgzdh/tuser")
@RequestMapping("/auth")
public class TUserController{
	private static Logger LOGGER = LoggerFactory.getLogger(TUserController.class);

	@Autowired
	private TUserService tUserService;	
	@RequestMapping(value = "/tuser/check", method = RequestMethod.POST)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "tUserDto", value = "账户信息", required = true, paramType = "body", dataType = "TUserDto") })
	@ApiOperation(value = "根据用户名检测用户信息")
	public @ResponseBody OAuth2AccessToken checkAccount( @RequestBody TUserDto tUserDto) {
		return tUserService.checkAccount( tUserDto);
	}
	@RequestMapping(value = "/tuser/pay", method = RequestMethod.POST)
	public @ResponseBody TUser userPay( @RequestBody AccountDto accountDto) {
		new AliPayController().pay_req(accountDto);
		return tUserService.userPay( accountDto);
	}
	@RequestMapping(value = "/getTime", method = RequestMethod.GET)
	public @ResponseBody Long getTime() {
		return new Date().getTime();
	}
	@RequestMapping(value = "/tuser/{userName}", method = RequestMethod.GET)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "userName", value = "人员账户", required = true, paramType = "path", dataType = "String", defaultValue = "") })
	@ApiOperation(value = "根据账户查询人员信息")
	public @ResponseBody TUserDto getTUser(@PathVariable("userName") String userName) {
		return tUserService.findByAccount(userName);
	}

	@RequestMapping(value = "/tuser/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "人员id", required = true, paramType = "path", dataType = "String", defaultValue = "") })
	@ApiOperation(value = "根据人员id删除账户")
	public void deleteTApp(@PathVariable("id") String id) {
		LOGGER.debug("删除应用id={}", id);
		tUserService.deleteTUser(id);
	}
	@RequestMapping(value = "/tuser/layOut", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void layOut() {
		
		tUserService.layOut();
	}
	  /***
     * 用户注册接口
     * @param userVo
     * @return
     */
    @ApiOperation(value="用户注册接口", notes="用户注册接口")
    @RequestMapping(value = "/userRegister",method = RequestMethod.POST)
    public @ResponseBody TUser userRegister(@RequestBody TUserDto user){
        return tUserService.userRegister(user);
    }
//    /***
//     * 获取用户信息
//     * @return
//     */
//    @ApiOperation(value="获取用户信息", notes="获取用户信息")
//    @RequestMapping(value = "/userInfo",method = RequestMethod.GET)
//    public @ResponseBody ResponseEntity<TUser> userInfo(){
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if (auth == null){
//            return ResponseEntity.status(HttpStatus.OK).body(null);
//        }
//        TUser users = (TUser) auth.getPrincipal();
//        TUser resultUser = new TUser();
//        BeanUtils.copyProperties(users, resultUser);
//        resultUser.setSalt(null);
//        resultUser.setPassword(null);
//        return ResponseEntity.status(HttpStatus.OK).body(resultUser);
//    }

    /**
     * 获取用户的二维码信息
     * @param request
     * @return
     */
    @ApiOperation(value="获取用户的二维码信息", notes="获取用户的二维码信息")
    @RequestMapping(value = "/getUserQr",method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<String> getUserQr(HttpServletRequest request){
        try {
            String url = request.getRequestURL().toString();
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            TUser userDetails = (TUser)auth.getPrincipal();
            url = url.substring(0,url.indexOf(request.getContextPath()))+request.getContextPath();
            String filePath = tUserService.getUserQr(userDetails,url);
            return ResponseEntity.status(HttpStatus.OK).body(filePath);
        } catch (DbException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMsg());
        }
    }

}

