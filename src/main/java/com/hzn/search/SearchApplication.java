package com.hzn.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class SearchApplication {

	public static void main (String[] args) {
		SpringApplication.run (SearchApplication.class, args);
	}
}
