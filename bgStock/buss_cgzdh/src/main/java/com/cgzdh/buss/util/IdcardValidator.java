package com.cgzdh.buss.util;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/** 
 * 身份证前6位【ABCDEF】为行政区划数字代码（简称数字码）说明（参考《GB/T 2260-2007 中华人民共和国行政区划代码》）： 
 * 该数字码的编制原则和结构分析，它采用三层六位层次码结构，按层次分别表示我国各省（自治区，直辖市，特别行政区）、 
 * 市（地区，自治州，盟）、县（自治县、县级市、旗、自治旗、市辖区、林区、特区）。  
 数字码码位结构从左至右的含义是：  
 第一层为AB两位代码表示省、自治区、直辖市、特别行政区；  
 第二层为CD两位代码表示市、地区、自治州、盟、直辖市所辖市辖区、县汇总码、省（自治区）直辖县级行政区划汇总码，其中：  
 ——01~20、51~70表示市，01、02还用于表示直辖市所辖市辖区、县汇总码；  
 ——21~50表示地区、自治州、盟；  
 ——90表示省（自治区）直辖县级行政区划汇总码。  
 第三层为EF两位表示县、自治县、县级市、旗、自治旗、市辖区、林区、特区，其中：  
 ——01~20表示市辖区、地区（自治州、盟）辖县级市、市辖特区以及省（自治区）直辖县级行政区划中的县级市，01通常表示辖区汇总码； 
 ——21~80表示县、自治县、旗、自治旗、林区、地区辖特区；  
 ——81~99表示省（自治区）辖县级市。  
 */
/**
 * 身份证验证的工具（支持15位或18位身份证）
 * 身份证号码结构：
 * 17位数字和1位校验码：6位地址码数字，8位生日数字，3位出生时间顺序号，1位校验码。
 * 地址码（前6位）：表示对象常住户口所在县（市、镇、区）的行政区划代码，按GB/T2260的规定执行。
 * 出生日期码，（第七位 至十四位）：表示编码对象出生年、月、日，按GB按GB/T7408的规定执行，年、月、日代码之间不用分隔符。
 * 顺序码（第十五位至十七位）：表示在同一地址码所标示的区域范围内，对同年、同月、同日出生的人编订的顺序号，
 * 顺序码的奇数分配给男性，偶数分配给女性。 
 * 校验码（第十八位数）：
 * 十七位数字本体码加权求和公式 s = sum(Ai*Wi), i = 0,,16，先对前17位数字的权求和；   
 *  Ai:表示第i位置上的身份证号码数字值.Wi:表示第i位置上的加权因.Wi: 7 9 10 5 8 4 2 1 6 3 7 9 10 5 8 4 2；
 * 计算模 Y = mod(S, 11) 
 * 通过模得到对应的校验码 Y: 0 1 2 3 4 5 6 7 8 9 10 校验码: 1 0 X 9 8 7 6 5 4 3 2 
 */
public class IdcardValidator {
	
    final static Map<Integer, String> zoneNum = new HashMap<Integer, String>();
    static {
        zoneNum.put(11, "北京");zoneNum.put(12, "天津");zoneNum.put(13, "河北");zoneNum.put(14, "山西");zoneNum.put(15, "内蒙古");
        zoneNum.put(21, "辽宁");zoneNum.put(22, "吉林");zoneNum.put(23, "黑龙江");
        zoneNum.put(31, "上海");zoneNum.put(32, "江苏");zoneNum.put(33, "浙江");zoneNum.put(34, "安徽");zoneNum.put(35, "福建");zoneNum.put(36, "江西");zoneNum.put(37, "山东");
        zoneNum.put(41, "河南");zoneNum.put(42, "湖北");zoneNum.put(43, "湖南");zoneNum.put(44, "广东");zoneNum.put(45, "广西");zoneNum.put(46, "海南");
        zoneNum.put(50, "重庆");zoneNum.put(51, "四川");zoneNum.put(52, "贵州");zoneNum.put(53, "云南");zoneNum.put(54, "西藏");
        zoneNum.put(61, "陕西");zoneNum.put(62, "甘肃");zoneNum.put(63, "青海");zoneNum.put(64, "新疆");
        zoneNum.put(71, "台湾");
        zoneNum.put(81, "香港");zoneNum.put(82, "澳门");
        zoneNum.put(91, "外国");
    }
     
    final static int[] PARITYBIT = {'1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'};
    final static int[] POWER_LIST = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
     
    /**
     * 身份证验证
     *@param s  号码内容
     *@return 是否有效 null和"" 都是false 
     */
    public static boolean isIdcard(String idcard){
        if(idcard == null || (idcard.length() != 15 && idcard.length() != 18))
            return false;
        final char[] cs = idcard.toUpperCase().toCharArray();
        //校验位数
        int power = 0;
        for(int i=0; i<cs.length; i++){
            if(i==cs.length-1 && cs[i] == 'X')
                break;//最后一位可以 是X
            if(cs[i]<'0' || cs[i]>'9')
                return false;
            if(i < cs.length -1){
                power += (cs[i] - '0') * POWER_LIST[i];
            }
        }
         
        //校验区位码
        if(!zoneNum.containsKey(Integer.valueOf(idcard.substring(0,2)))){
            return false;
        }
         
        //校验年份
        String year = idcard.length() == 15 ? getIdcardCalendar() + idcard.substring(6,8) :idcard.substring(6, 10);
         
        final int iyear = Integer.parseInt(year);
        if(iyear < 1900 || iyear > Calendar.getInstance().get(Calendar.YEAR))
            return false;//1900年的PASS，超过今年的PASS
         
        //校验月份
        String month = idcard.length() == 15 ? idcard.substring(8, 10) : idcard.substring(10,12);
        final int imonth = Integer.parseInt(month);
        if(imonth <1 || imonth >12){
            return false;
        }
         
        //校验天数      
        String day = idcard.length() ==15 ? idcard.substring(10, 12) : idcard.substring(12, 14);
        final int iday = Integer.parseInt(day);
        if(iday < 1 || iday > 31)
            return false;       
         
        //校验"校验码"
        if(idcard.length() == 15)
            return true;
        return cs[cs.length -1 ] == PARITYBIT[power % 11];
    }
     
    private static int getIdcardCalendar() {        
         GregorianCalendar curDay = new GregorianCalendar();
         int curYear = curDay.get(Calendar.YEAR);
         int year2bit = Integer.parseInt(String.valueOf(curYear).substring(2));          
         return  year2bit;
    }     
     

 
}