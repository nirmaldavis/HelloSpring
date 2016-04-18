package com.nirmal.spring.hello.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringSpelConfig {

	//Using Spring Expression Language SpEL to get property from java system command line or system property 
	
	//Referring system property with SpEL
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
	
	//Referring environment variable with SpEL
	@Value("#{systemEnvironment['windir']}")
	String windowsDir;
	
	@Bean(name="windir")
	String getWindowsDir() {
		return windowsDir;
	}
	
	/**
	 * Setting a default value for system property locale with "elvis" operator in SpEL way
	 */
	@Value("#{systemProperties['locale'] ?: 'en-US' }")
	String locale;
	
	@Bean(name="locale")
	String getLocale() {
		return locale;
	}
}
