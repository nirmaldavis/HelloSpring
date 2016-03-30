package com.nirmal.spring.hello.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@Configuration
public class PropertyConfig {

	@Autowired
	Environment env;
	
	@Bean
	public String getUserEnv() {
		// @Value("${USER_ID}") String userId
		String userId = env.getProperty("USER_ID");
		
		return userId;
	}
	
	@Bean
	String getUserValue(@Value("${USER_ID}") String userId) { //DONE: @Value - Not working unless you specifying a following "static" bean PropertySourcesPlaceholderConfigurer
		return userId;
	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}
