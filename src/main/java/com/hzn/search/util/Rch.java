package com.hzn.search.util;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Objects;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * <p>{@link RequestContextHolder} 유틸</p>
 *
 * @author hzn
 * @date 2023-12-13
 */
public class Rch {

	public static HttpServletRequest getRequest () {
		return ((ServletRequestAttributes) getRequestAttributes ()).getRequest ();
	}

	public static HttpServletResponse getResponse () {
		return ((ServletRequestAttributes) getRequestAttributes ()).getResponse ();
	}

	public static HttpSession getSession () {
		return getRequest ().getSession ();
	}

	public static void set (String n, Object v) {
		set (n, v, RequestAttributes.SCOPE_REQUEST);
	}

	public static void set (String n, Object v, int scope) {
		getRequestAttributes ().setAttribute (n, v, scope);
	}

	public static Object get (String n) {
		return get (n, RequestAttributes.SCOPE_REQUEST);
	}

	public static Object get (String n, int scope) {
		return getRequestAttributes ().getAttribute (n, scope);
	}

	public static void remove (String n) {
		remove (n, RequestAttributes.SCOPE_REQUEST);
	}

	public static void remove (String n, int scope) {
		getRequestAttributes ().removeAttribute (n, scope);
	}

	private static RequestAttributes getRequestAttributes () {
		return Objects.requireNonNull (RequestContextHolder.getRequestAttributes ());
	}
}
