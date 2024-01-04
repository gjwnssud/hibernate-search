package com.hzn.search.util;

import jakarta.servlet.http.HttpServletRequest;

/**
 * <p></p>
 *
 * @author hzn
 * @date 12/28/23
 */
public class CommonUtil {

	public static String getClientIP (HttpServletRequest request) {
		String ip = request.getHeader ("X-Forwarded-For");
		if (ip == null) {
			ip = request.getHeader ("Proxy-Client-IP");
		}
		if (ip == null) {
			ip = request.getHeader ("WL-Proxy-Client-IP");
		}
		if (ip == null) {
			ip = request.getHeader ("HTTP_CLIENT_IP");
		}
		if (ip == null) {
			ip = request.getHeader ("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null) {
			ip = request.getRemoteAddr ();
		}
		return ip;
	}
}
