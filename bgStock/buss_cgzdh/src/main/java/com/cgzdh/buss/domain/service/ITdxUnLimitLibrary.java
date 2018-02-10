package com.cgzdh.buss.domain.service;


import com.sun.jna.Library;
import com.sun.jna.Native;

public interface ITdxUnLimitLibrary extends Library 
{
    ITdxUnLimitLibrary instance = (ITdxUnLimitLibrary) Native.loadLibrary("JLAPI", ITdxUnLimitLibrary.class);
	
    int JL_Login(String Ip, int Port,String Version,String User, String PassWord, String TXPass, String Yyb);  //登录
    
    boolean JL_QueryData(int ClientID,String User, int Category,byte[] Res);  //查询
    
    boolean JL_GetPrice(int ClientID, String Gpdm,byte[] Res);          //五档
    
    boolean JL_CancelOrder(int ClientID, String User,String Bho,int jys,byte[] Res);  //撤单
    
    boolean JL_SendOrder(int ClientID ,int Fx,String User,String Gddm,String Gpdm,int Quantity,float Price,byte[] Res);  //委托
    
    
       }
