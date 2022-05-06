package com.rest.system.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;

/**
 * @author tiger380
 * @version 1.0 2012/02/09
 * @description 날짜 관련 Util
 */
public class DateUtil {
	/**
	 * 현재 시간정보를 반환한다.
	 * @param format
	 * @return
	 */
	public static String getCurrentTime(String format) {
		int millisPerHour = 60 * 60  * 1000;
		
		SimpleDateFormat fmt = new SimpleDateFormat(format);
		SimpleTimeZone timeZone = new SimpleTimeZone(9 * millisPerHour, "KST");
		fmt.setTimeZone(timeZone);
		
		String str = fmt.format(new Date(System.currentTimeMillis()));
		
		return str;
	}
	/**
	 * 현재 날자를 반환한다.
	 * @param pattern
	 */
	public static String getCurrDate(String pattern) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(cal.getTime());
	}
	
	public static String getCurrentDateTime(String format) {
		return new SimpleDateFormat(format).format(new Date());
	}
	
	/**
	 * check date string validation with the default format "yyyyMMdd" <br>
	 * 정해진 포맷형이 없을 때 인자로 받은 String s 가 "yyyyMMdd" 형태인지 체크한다.
	 * klia_root/common_side/src/klia/common/util/DateUtils.java
	 * 
	 * @param s date string you want to check with default format "yyyyMMdd"
	 * @return boolean true 날짜 형식이 맞고, 존재하는 날짜일 때
	 *                 false 날짜 형식이 맞지 않거나, 존재하지 않는 날짜일 때
	 * @throws Exception
	 */
	public static boolean isValid(String s) throws Exception
	{
		return DateUtil.isValid(s, "yyyyMMdd");
	}
	
	/**
	 * check date string validation with an user defined format <br>
	 * 인자로 받은 String s 를 사용자가 정의한 포맷형 String format 와 같은지 체크한다.
	 * klia_root/common_side/src/klia/common/util/DateUtils.java
	 * 
	 * @param s date string you want to check.
	 * @param format string representation of the date format. For example, "yyyy-MM-dd".
	 * @return boolean true 날짜 형식이 맞고, 존재하는 날짜일 때
	 *                 false 날짜 형식이 맞지 않거나, 존재하지 않는 날짜일 때
	 */
	public static boolean isValid(String s, String format)
	{
		/*
				if ( s == null )
					throw new NullPointerException("date string to check is null");
				if ( format == null ) 
					throw new NullPointerException("format string to check date is null");
		*/
		java.text.SimpleDateFormat formatter =
			new java.text.SimpleDateFormat(format, Locale.getDefault());
		java.util.Date date = null;
		try
		{
			date = formatter.parse(s);
		}
		catch (java.text.ParseException e)
		{
			return false;
		}

		if (!formatter.format(date).equals(s))
			return false;

		return true;
	}
	
	/**
	 * Date타입 날짜의 포맷변경 method
	 * @param date
	 * @param format
	 * @return
	 */
	public static String formatDate(Date date, String format) {
		SimpleDateFormat fmt = new SimpleDateFormat(format);
		return fmt.format(date);
	}
	/**
	 * String 타입 데이트 포맷 변경 method
	 * ex)DateUtil.formatDate("20120401", "-")
	 * 결과 : 2012-04-01
	 * @param date
	 * @param mark
	 * @return
	 */
	public static String formatDate(String date, String mark) {
		StringBuffer chagedDate = new StringBuffer(date);
		return String.valueOf(chagedDate.insert(4, mark).insert(7, mark));
	}
	
	/**
	 * long 타입 날짜의 포맷변경 method
	 *
	 * 
	 * @param date 밀리세컨즈 날짜
	 * @param format 변경할 날짜 포맷
	 * @return
	 */
	public static String formatDate(long date, String format) {
		SimpleDateFormat fmt = new SimpleDateFormat(format);
		return fmt.format(date);
	}
	
	/**
	 * yyyyMMdd 형식으로 현재일자 반환  method
	 * @return
	 */
    public static String getDate() {
        String format = "yyyyMMdd";
        Date date = new Date();
        return getDate(date, format);
    }

	/**
	 * yyyy 형식으로 현재년도 반환  method
	 * @return
	 */
    public static String getYear() {
        String format = "yyyy";
        Date date = new Date();
        return getDate(date, format);
    }

	/**
	 * MM 형식으로 현재월도 반환  method
	 * @return
	 */
    public static String getMonth() {
        String format = "MM";
        Date date = new Date();
        return getDate(date, format);
    }
    
	/**
	 * dd 형식으로 현재일자 반환  method
	 * @return
	 */
    public static String getDay() {
        String format = "dd";
        Date date = new Date();
        return getDate(date, format);
    }
    /**
     * Date에 대한 패턴 적용 일자 얻기<br>
     * Date에 pattern 형식을 적용한 일자를 얻는다.<br>
     * ex, String r = DateUtil.getDate(DateUtil.getDateObject("20110314"), "yyyy-MM-dd"); //r="2011-03-14"<br>
     * ex, getDate(new Date(), "yyyy/MM/dd") ==> 2007/08/16 <br>
     * ex, String r = DateUtil.getDate(DateUtil.getTimestamp("20110314010101001"), "yyyy-MM-dd HH:mm:ss.SSS");<br>
     * //r="2011-03-14 01:01:01.001"<br>
     *
     * @param date pattern을 적용하고 싶은 Date
     * @param pattern 적용하고 싶은 pattern
     * @return 해당 date에 패턴을 적용한 일자
     */
    public static String getDate(Date date, String pattern) {
        SimpleDateFormat formatter = new SimpleDateFormat(pattern, java.util.Locale.KOREA);
        return formatter.format(date);
    }
    
    /**
     * <pre>
     *	String 타입의 날짜를 Date 타입으로 변환.
     * </pre>
     * @param strSource String 타입의 날짜
     * @return
     */
    public static Date getDateType(String strSource)
    {
    	strSource	= strSource.replaceAll("-", "");
    	strSource	= strSource.replaceAll("/", "");

    	Date date	= null;

    	if(strSource.length() != 8)
    	{
    		strSource = "19000101";
    	}

        DateFormat df	= new SimpleDateFormat("yyyyMMdd");     
		try
		{
			date = df.parse(strSource);
		}
		catch(ParseException e)
		{
//				e.printStackTrace();
		}

    	return date;
    }
	
	/**
	 * 날짜를 지정한 포맷으로 원하는 만큼 이동 시키는 method
	 * @param date
	 * @param amount
	 * @param format
	 * @return
	 */
	public static String addDays(String date, int amount, String format)
	{
		Calendar c = Calendar.getInstance();
        c.setTime(getDateType(date));
        c.add(5, amount);
		
        SimpleDateFormat sdFormat = new SimpleDateFormat(format);
		return sdFormat.format(c.getTime());
	}
	
	/**
	 * 날짜를 지정한 포맷으로 원하는 만큼 이동 시키는 method
	 * @param date
	 * @param amount
	 * @param format
	 * @return
	 */
	public static String addMonth(String date, int amount, String format)
	{
		Calendar c = Calendar.getInstance();
        c.setTime(getDateType(date));
        c.add(Calendar.MONTH, amount);
		
        SimpleDateFormat sdFormat = new SimpleDateFormat(format);
		return sdFormat.format(c.getTime());
	}
		
	/**
	 * 날짜 비교.
	 * @param begin
	 * @param end
	 * @return
	 */
	public static long diffOfDate(String begin, String end)
	{
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");

	    Date beginDate;
	    Date endDate;
	    long diff = 0;
	    long diffDays = 0;
		try
		{
			beginDate	= formatter.parse(begin);
			endDate		= formatter.parse(end);

			diff = endDate.getTime() - beginDate.getTime();
			diffDays = diff / (24 * 60 * 60 * 1000);
		}
		catch (ParseException e) {
		}

	    return diffDays;
	}

}
