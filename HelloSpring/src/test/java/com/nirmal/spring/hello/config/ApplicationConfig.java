package com.nirmal.spring.hello.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(InfrastructureConfig.class) //Importing another configuration class here 
public class ApplicationConfig {

	//Looking for Bean to be autowired with Qualifier for bean id
	@Autowired
	@Qualifier("getName")
	String name;
	
	
	@Bean
	String displayInUpperCase(String message) 
	{
		return message.toUpperCase();
	}
	
	

	@Bean(name="message")
	String getWelcomeMessage() {
		return "Welcome, " + name;
	}
	
	//Expose bean with Qualifier describing the bean id
	@Bean(name="message")
	String getHelloMessage() {
		return "Hello, " + name;
	}

	
	@Bean(name="sample") 
	String example() {
		return "Example 2";
	}
}


// Referring bean by autowire for the field - done
// Referring bean in bean method parameter - done
//TODO: Question - How to refer bean in method parameter with Qualifier, is it possible ?
//TODO: Testing multiple beans with same name - may get latest
