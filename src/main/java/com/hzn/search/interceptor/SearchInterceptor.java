package com.hzn.search.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * <p></p>
 *
 * @author hzn
 * @date 12/28/23
 */
public class SearchInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle (HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		return true;
	}
}
