package com.nirmal.spring.hello.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class ProfileConfig {

	@Bean(name="user")
	@Profile("dev")
	String getUserForDev() {
		return "Nirmal Davis";
	}

	@Bean(name="user")
	@Profile("test")
	String getUserForTest() {
		return "Dummy";
	}
}
