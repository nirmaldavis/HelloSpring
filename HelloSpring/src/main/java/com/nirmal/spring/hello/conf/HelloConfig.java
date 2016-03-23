package com.nirmal.spring.hello.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nirmal.spring.hello.api.Hello;
import com.nirmal.spring.hello.impl.HelloImpl;

@Configuration
public class HelloConfig {

	@Bean
	Hello getHello() {
		return new HelloImpl();
	}
}
