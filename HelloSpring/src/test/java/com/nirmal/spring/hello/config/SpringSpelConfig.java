package com.nirmal.spring.hello.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringSpelConfig {

	//Using Spring Expression Language SpEL to get property from java system command line or system property 
	
	@Value("#{systemProperties['ACCOUNT_TYPE']}")
	String accountType;
	
	@Bean(name="accountType")
	public String getAccountType() {
		return accountType;
	}
	
	//@Value("${type}" for making use of property without SpEL and 
	//@Value("#{systemProperties['type']}"  with SpEL
	
	@Bean(name="address")
	public String getAddress(@Value("#{systemProperties['type']}") String type)
	{
		String address = "";
		switch (type) {
			
			case "Office" :
				address = "JFWTC, Whitefield";
				break;
			case "Personal":
			default:
				address = "Kundalahalli Gate";
				break;				
		}
				
		return address;
	}
}
