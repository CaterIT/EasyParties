/**
 * 
 */
package com.cater.utils;

/**
 * @author armaank
 *
 */
public class GeneralUtils {
	public static String createOTP(){
		String otp=(int)(Math.random()*10000)+"";
		return otp;
	}
}
