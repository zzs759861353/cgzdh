package com.cgzdh.buss.domain.service;

import org.springframework.stereotype.Service;

import com.cgzdh.buss.domain.dto.LoginDto;
import com.sun.jna.Native;

@Service
public class BussService extends BaseService {
	
	public int gp_login(LoginDto dto){

		return ITdxUnLimitLibrary.instance.JL_Login(dto.getIp(),dto.getPort(),dto.getVersion(),dto.getUser(), dto.getPasswd(),dto.getTxPwd(), dto.getYyb());
	}
	public String gp_deal(int clientId,String user,int code){
		byte[] Res=new byte[1024*1024];
		ITdxUnLimitLibrary.instance.JL_QueryData(clientId,user,code,Res);  //查询函数 这里104是查询 资金
		System.out.println(Native.toString(Res, "GBK"));;
		return Native.toString(Res, "GBK");
	}
	public String gp_cancellations(int clientId,String user,String code,int lx){
		byte[] Res=new byte[1024*1024];
		 ITdxUnLimitLibrary.instance.JL_CancelOrder(clientId,user,code,lx,Res);    //撤单函数这里是委托编号 为 8 的深圳股票
		System.out.println(Native.toString(Res, "GBK"));
		return Native.toString(Res, "GBK");
	}
	public String gp_query(int clientId,int type, String user, String gdCode, String gpCode, int count, float price){
		byte[] Res=new byte[1024*1024];
		/*
		 *  参数 ClientID，方向（0为买入，1为卖出），账户，股东代码，股票代码，股票数量，价格,Res保存返回的字符串
			其中股东代码要对应所买股票，上海的要用上海的股东代码，深圳和创业版要用深圳的，有的券商不需要输入为空也行，但不能写错
			成功返回委托编号
			失败会返回失败原因，比如你差多少钱，或者差多少股，或者不在交易时间不接受委托等等等等
		 * */
		ITdxUnLimitLibrary.instance.JL_SendOrder(clientId,type, user, gdCode, gpCode, count, price,Res);    //下单函数 其中01200211xx是深圳股东号
		return Native.toString(Res, "GBK");
	}


}
