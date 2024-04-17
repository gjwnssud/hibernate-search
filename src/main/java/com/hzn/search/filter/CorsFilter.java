package com.hzn.search.filter;

import com.hzn.search.enums.Status;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * <p></p>
 *
 * @author hzn
 * @date 12/13/23
 */
@WebFilter
@Component
@Order (1)
public class CorsFilter extends OncePerRequestFilter {
	@Override
	protected void doFilterInternal (HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		response.setHeader ("Access-Control-Allow-Origin", "*");
		response.setHeader ("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE, PATCH, OPTIONS");
		response.setHeader ("Access-Control-Max-Age", "3600");

		if (request.getMethod ().equals ("OPTIONS")) {
			response.setHeader ("Access-Control-Allow-Headers", "*");
			response.setStatus (Status.OK.getCode ());
		} else {
			response.setHeader ("Access-Control-Allow-Headers",
			                    "Authorization, Origin, X-Requested-With, Content-PaymentType, Content-Disposition, Accept");
			filterChain.doFilter (request, response);
		}
	}
}
