package com.nirmal.spring.hello;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import com.nirmal.spring.hello.api.Greeting;
import com.nirmal.spring.hello.conf.GreetingAnnotationConfig;

public class AnnotationConfigTest {

	private ApplicationContext context;

	@Before
	public void setUp() throws Exception {
		context = SpringApplication.run(GreetingAnnotationConfig.class);
	}

	@Test
	public void testGreeting() {
		Greeting greeting = context.getBean(Greeting.class);
		String message = greeting.getMessage();
		assertEquals("Welcome to Spring, Nirmal Davis", message);
	}
	
	@Test
	public void testBeanIdDerivedFromClassNameGreetingImpl() {
		//Testing Bean id derived from class name
		//the first letter of class name becomes small letter when it becomes bean id
		Greeting greeting = context.getBean("greetingImpl", Greeting.class);
		String message = greeting.getMessage();
		assertEquals("Welcome to Spring, Nirmal Davis", message);
	}	

}
