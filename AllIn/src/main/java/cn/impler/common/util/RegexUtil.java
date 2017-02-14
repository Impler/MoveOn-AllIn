package cn.impler.common.util;

import java.util.UUID;
import java.util.regex.Pattern;

public class RegexUtil {

	// mobile number regex
	private static String REG_MOBILE_NUMBER = "^0{0,1}(13[0-9]|15[0-9]|14[0-9]|18[0-9])[0-9]{8}$";
	// email address regex
	private static String REG_EMAIL_ADDRESS = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
	
	private RegexUtil() {
	}

	/**
	 * is mobile number string
	 * @param str
	 * @return
	 */
	public static boolean isMobileNumStr(String str){
		return match(REG_MOBILE_NUMBER, str);
	}
	
	/**
	 * is email address string 
	 * @param str
	 * @return
	 */
	public static boolean isEmailAddressStr(String str){
		return match(REG_EMAIL_ADDRESS, str);
	}
	
	/**
	 * @param regex
	 * @param str
	 * @return
	 */
	public static boolean match(String regex, String str){
		if(null == str){
			return false;
		}
		return Pattern.matches(regex, str);
	}
	
}
