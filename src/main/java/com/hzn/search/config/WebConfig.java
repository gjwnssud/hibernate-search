package com.hzn.search.config;

import com.hzn.search.interceptor.SearchInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <p></p>
 *
 * @author hzn
 * @date 12/13/23
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors (InterceptorRegistry registry) {
		registry.addInterceptor (new SearchInterceptor ()).addPathPatterns ("/**");
	}
}
