package com.nirmal.spring.hello;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nirmal.spring.hello.config.PropertyConfig;

public class PropertyTest {

	private ApplicationContext context;

	@Before
	public void setUp() throws Exception {
		
//		context = new AnnotationConfigApplicationContext(PropertyConfig.class);
		
		context = SpringApplication.run(PropertyConfig.class);
//		System.setProperty("USER_ID", "Nirmal");
		System.out.println("Property : USER_ID = " + 
			System.getProperty("USER_ID"));
	}

	@Test
	public void testUserIdEnv() {
		String user = context.getBean("getUserEnv", String.class);
		assertEquals("Nirmal", user);
		
	}

	@Test
	public void testUserIdValue() {
		String user = context.getBean("getUserValue", String.class);
		assertEquals("Nirmal", user);
		
	}
	
	@Test
	public void testPropertyFromPropertiesFile() {
		//System.setProperty("mode", "dev"); Pass it as command line property -Dmode=dev
		String user = context.getBean("userName", String.class);
		assertEquals("Nirmal Davis V", user);
		
	}
}
