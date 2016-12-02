package cn.impler.common.util;

import java.text.Format;
import java.util.Date;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.FastDateFormat;

public class DateFormatUtil {

	public static String getDefaultFormtedDateStr(Date date){
		return getFormatedDateStr(date, DateFormatUtils.ISO_DATE_FORMAT);
	}
	
	public static String getDefaultFormatedDatetimeStr(Date date){
		return getFormatedDateStr(date, "yyyy-MM-dd HH:mm:ss");
	}
	
	public static String getFormatedDateStr(Date date, String pattern){
		return getFormatedDateStr(date, FastDateFormat.getInstance(pattern));
	}
	public static String getFormatedDateStr(Date date, Format format){
		return format.format(date);
	}
	
}
