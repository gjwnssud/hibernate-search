package com.hzn.search.filter;

import com.hzn.search.util.CommonUtil;
import com.hzn.search.util.Rch;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.filter.OncePerRequestFilter;
import ua_parser.Client;
import ua_parser.Parser;

/**
 * <p></p>
 *
 * @author hzn
 * @date 12/26/23
 */
@WebFilter
@Component
@Order (2)
@Slf4j
public class LogFilter extends OncePerRequestFilter {
	@Override
	protected void doFilterInternal (HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		StopWatch stopWatch = new StopWatch ();
		stopWatch.start ();
		filterChain.doFilter (request, response);
		stopWatch.stop ();

		Parser uaParser = new Parser ();
		Client client = uaParser.parse (request.getHeader ("user-agent"));
		String uaLog = CommonUtil.getClientIP (request) + " " + client.os.family + "(v" + client.os.major + "." + client.os.minor + ") "
				+ client.userAgent.family + "(v" + client.userAgent.major + "." + client.userAgent.minor + ")";
		log.info (request.getMethod () + " " + request.getRequestURI () + " " + stopWatch.getLastTaskTimeMillis () + "(ms) " + uaLog);
	}
}
