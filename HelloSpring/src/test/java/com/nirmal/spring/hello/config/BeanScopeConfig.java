package com.nirmal.spring.hello.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.nirmal.spring.hello.api.Hello;
import com.nirmal.spring.hello.impl.HelloImpl;

@Configuration
public class BeanScopeConfig {

	@Bean(name="helloBean")
	Hello getHelloBean() {
		return new HelloImpl("Hello1");
	}
	
	@Bean(name="helloProtoBean")
	@Scope("prototype")
	Hello getHelloPrototypeBean() {
		return new HelloImpl("Hello1");
	}
}
