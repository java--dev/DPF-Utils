package org.rency.utils.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

/**
 * @desc 获取客户端浏览器类型
 * @author T-rency
 * @date 2014年11月27日 下午4:20:12
 */
public class BrowserUtils {
	// 判断是否是IE
	public static boolean isIE(HttpServletRequest request) {
		return (request.getHeader("USER-AGENT").toLowerCase().indexOf("msie") > 0||
				request.getHeader("USER-AGENT").toLowerCase().indexOf("rv:11.0")>0)? true : false;
	}

	/**
	 * 获取IE版本
	 * 
	 * @param request
	 * @return
	 */
	public static Double getIEversion(HttpServletRequest request) {
		Double version = 0.0;
		if (getBrowserType(request, IE11)) {
			version = 11.0;
		}else if (getBrowserType(request, IE10)) {
			version = 10.0;
		}else if (getBrowserType(request, IE9)) {
			version = 9.0;
		}else if (getBrowserType(request, IE8)) {
			version = 8.0;
		}else if (getBrowserType(request, IE7)) {
			version = 7.0;
		}else if (getBrowserType(request, IE6)) {
			version = 6.0;
		}
		return version;
	}

	private static boolean getBrowserType(HttpServletRequest request, String brosertype) {
		return request.getHeader("USER-AGENT").toLowerCase().indexOf(brosertype) > 0 ? true : false;
	}
	private final static String IE11 = "rv:11.0";
	private final static String IE10 = "MSIE 10.0";
	private final static String IE9 = "MSIE 9.0";
	private final static String IE8 = "MSIE 8.0";
	private final static String IE7 = "MSIE 7.0";
	private final static String IE6 = "MSIE 6.0";
	private final static String MAXTHON = "Maxthon";
	private final static String QQ = "QQBrowser";
	private final static String GREEN = "GreenBrowser";
	private final static String SE360 = "360SE";
	private final static String FIREFOX = "Firefox";
	private final static String OPERA = "Opera";
	private final static String CHROME = "Chrome";
	private final static String SAFARI = "Safari";
	private final static String OTHER = "其它";

	public static String checkBrowse(HttpServletRequest request) {
		String userAgent=request.getHeader("User-Agent");
		if(StringUtils.isBlank(userAgent)){
			return "unkonwn";
		}
		if (regex(OPERA, userAgent))
			return OPERA;
		if (regex(CHROME, userAgent))
			return CHROME;
		if (regex(FIREFOX, userAgent))
			return FIREFOX;
		if (regex(SAFARI, userAgent))
			return SAFARI;
		if (regex(SE360, userAgent))
			return SE360;
		if (regex(GREEN, userAgent))
			return GREEN;
		if (regex(QQ, userAgent))
			return QQ;
		if (regex(MAXTHON, userAgent))
			return MAXTHON;
		if (regex(IE11, userAgent))
			return IE11;
		if (regex(IE10, userAgent))
			return IE10;
		if (regex(IE9, userAgent))
			return IE9;
		if (regex(IE8, userAgent))
			return IE8;
		if (regex(IE7, userAgent))
			return IE7;
		if (regex(IE6, userAgent))
			return IE6;
		return OTHER;
	}

	public static boolean regex(String regex, String str) {
		Pattern p = Pattern.compile(regex, Pattern.MULTILINE);
		Matcher m = p.matcher(str);
		return m.find();
	}

}
