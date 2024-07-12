package com.hzn.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

@SpringBootApplication (exclude = {UserDetailsServiceAutoConfiguration.class})
public class HibernateSearchApplication {

	public static void main (String[] args) {
		SpringApplication.run (HibernateSearchApplication.class, args);
	}

}
