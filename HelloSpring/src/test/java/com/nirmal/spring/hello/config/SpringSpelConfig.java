package com.nirmal.spring.hello.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
public class SpringSpelConfig {

	@Value("#{systemProperties['ACCOUNT_TYPE']}")
	String accountType;
	
	@Bean(name="accountType")
	public String getAccountType() {
		return accountType;
	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}	
}
