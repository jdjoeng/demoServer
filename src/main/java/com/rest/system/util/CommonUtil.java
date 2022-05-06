package com.rest.system.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

/**
 * 1. 패키지명	: com.gsitm.mydata.system.util
 * 2. 파일명	: CommonUtil.java
 * 3. 작성일	: 2021. 05. 10.
 * 4. 작성자	: jjlee
 * 5. 설명 	: 공통 UTIL 
 * 
 */
@Slf4j
public class CommonUtil {
	
	/**
     * @Method Name : isEmpty
     * @param str
     * @return
     */
    public boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }
    
    
    /**
     * @Method Name : tokenCheck
     * @param tokenVal
     * @return
     */
   public Map tokenCheck(String tokenVal){
	   Map resMap = new HashMap();
	   
	   tokenVal = tokenVal.replace("bearer ","");
	   
	   resMap.put("clientId","testclientid");
	   resMap.put("clientSecret","AAAAAAAAAAAAAA");
	   resMap.put("cino",tokenVal);
	   
	   return resMap;
   }
   
   /**
    * @Method Name : commonValidate
    * @param checkVal
    * @param len
    * @param val
    * @return
    */
   public boolean commonValidate(String checkVal, int len, String val){
	   boolean valPass = false;
	   String notnullChk = "notnull";
	   String lenChk = "length";
	   int errorCnt = 0;
	   String[] checkArr = checkVal.split(",");
	   
	   for(int i=0;i < checkArr.length;i++) {
		   if(checkArr[i].equals(notnullChk)) {
			   if(val == null || val.trim().equals("")) {
				   errorCnt++;
			   }
		   }
		   
		   if(checkArr[i].equals(lenChk)) {
			   if(val != null && val.length() > len) {
				   errorCnt++;
			   }
		   }
	   }
	   
	   if(errorCnt == 0) {
		   valPass = true;
	   }
	   
	   return valPass;
   }
   
   /**
    * @Method Name : spaceFit
    * @param val
    * @param position
    * @param len
    * @return
    */
   public String spaceFit(String val, String pos, int len){
	    String resVal = val;
		
		String spaceVal = " ";
		if(pos != null && pos.equals("forth") && val.length() < len) {
			for(int i=0;i < (len-val.length());i++) {
				resVal = spaceVal + resVal;
			}
		}else if(pos != null && pos.equals("back") && val.length() < len) {
			for(int i=0;i < (len-val.length());i++) {
				resVal = resVal + spaceVal;
			}
		}
	   
	    return resVal;
   }
   
   /**
    * @Method Name : null2Str
    * @param val
    * @return
    */
   public String null2Str(Object val) {
		return null2Str(val, "");
   }
   
   /**
    * @Method Name : null2Str
    * @param val
    * @param defaultValue
    * @return
    */
   public String null2Str(Object val, String defaultValue) {
	   if(val != null) {
		   return String.valueOf(val);
	   }
	   return defaultValue;
	}
   
   /**
    * @Method Name : maskingName
    * @param val
    * @return
    */
   public String maskingName(String val) {
	   String maskingVal = "";
	   val = val.trim();
	   if(val != null) {
		   for(int i=0;i < val.length();i++) {
			   maskingVal += "*";
		   }
		   maskingVal = val.substring(0, 1) + maskingVal.substring(1);
		   maskingVal = maskingVal.substring(0, val.length()-1) + val.substring(val.length()-1, val.length());
	   }
	   return maskingVal;
	}
   
   /**
    * @Method Name : periodCheck
    * @param val
    * @return
    */
   public boolean periodCheck(int period, String startDt) {
	    boolean rtnValue = false;
		SimpleDateFormat fm = new SimpleDateFormat("yyyyMMdd");
		Calendar day = Calendar.getInstance();
		String strToday = fm.format(day.getTime());
		
		Date date = null;
		try {
			date = fm.parse(strToday);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		day.setTime(date);
		day.add(Calendar.YEAR, -(period));
		
		String stdDate = fm.format(day.getTime());
		
		if(Integer.parseInt(startDt) >= Integer.parseInt(stdDate)) {
			rtnValue = true;
		}
		
		return rtnValue;
	}
   
   /**
    * @Method Name : splitRglrPeriod
    * @param val
    * @return
    */
   public String[] splitRglrPeriod(String cycle) {
	   String[] cycleArr = null;
	   
	   if(cycle != null && cycle.indexOf("/") > 0) {
			cycleArr = cycle.split("/");
		}
		
		return cycleArr;
	}
   
   /**
    * @Method Name : addDateMatch
    * @param val
    * @return
    */
   public String addDateMatch(String val) {
	    if(val.length() == 1) {
	    	val = "0"+val;
	    }
		
		return val;
	}
   
   /**
    * @Method Name : maxSearchPeriodCheck
    * @param val
    * @return
    * @throws ParseException 
    */
   public boolean maxSearchPeriodCheck(String startDt, String endDt, int maxDay, String dateGubun) throws ParseException {
	    boolean rtnValue = false;
	   	Date sDate = new SimpleDateFormat("yyyyMMdd").parse(startDt);
		Date eDate = new SimpleDateFormat("yyyyMMdd").parse(endDt);
		Calendar startDate = Calendar.getInstance();
		Calendar endDate = Calendar.getInstance();
		
		startDate.setTime(sDate);
		endDate.setTime(eDate);
		
		if(dateGubun.equals("day")) {
			long diffSec = (endDate.getTimeInMillis() -startDate.getTimeInMillis())/1000;
			long diffDays = diffSec / (24*60*60);
			
			if(diffDays <= maxDay) {
				rtnValue = true;
			}
		}else if(dateGubun.equals("month")) {
			endDate.add(Calendar.MONTH,-(maxDay));
			
			String startDay = new SimpleDateFormat("yyyyMMdd").format(startDate.getTime());
			String beforeDay = new SimpleDateFormat("yyyyMMdd").format(endDate.getTime());
			
			if(Integer.parseInt(startDay) >= Integer.parseInt(beforeDay)) {
				rtnValue = true;
			}
			
		}
		
		return rtnValue;
	}
}
