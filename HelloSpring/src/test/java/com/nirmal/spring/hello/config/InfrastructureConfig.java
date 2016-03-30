package com.nirmal.spring.hello.config;

import org.springframework.context.annotation.Bean;

public class InfrastructureConfig {

	@Bean
	String getName(){
		return "Nirmal Davis";
	}
	
	@Bean(name="sample") 
	String example() {
		return "Example 1";
	}
}
