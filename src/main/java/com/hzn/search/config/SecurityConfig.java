package com.hzn.search.config;

import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

/**
 * <p></p>
 *
 * @author hzn
 * @date 2024. 5. 22.
 */
@EnableWebSecurity
@Configuration
public class SecurityConfig {
	@Value ("${cors.allowed.origins}")
	private List<String> corsAllowedOrigins;
	@Value ("${cors.allowed.headers}")
	private List<String> corsAllowedHeaders;
	@Value ("${cors.allowed.methods}")
	private List<String> corsAllowedMethods;

	@Bean
	public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
		http.authorizeHttpRequests (authorize -> authorize.requestMatchers ("/**").permitAll ()).formLogin (AbstractHttpConfigurer::disable)
		    .logout (AbstractHttpConfigurer::disable).httpBasic (AbstractHttpConfigurer::disable).cors (cors -> cors.configurationSource (corsConfigurationSource ()))
		    .csrf (AbstractHttpConfigurer::disable);
		return http.build ();
	}

	@Bean
	public CorsConfigurationSource corsConfigurationSource () {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource ();
		CorsConfiguration config = new CorsConfiguration ();
		config.setAllowCredentials (true);
		config.setAllowedOriginPatterns (corsAllowedOrigins);
		config.setAllowedHeaders (corsAllowedHeaders);
		config.setAllowedMethods (corsAllowedMethods);
		source.registerCorsConfiguration ("/**", config);
		return source;
	}
}
