package com.nirmal.spring.hello;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import com.nirmal.spring.hello.config.PropertyConfig;

public class PropertyTest {

	private ApplicationContext context;

	@Before
	public void setUp() throws Exception {
		
//		context = new AnnotationConfigApplicationContext(PropertyConfig.class);
		
		//We can set it on comand line system property arguments -DUSER_ID=Nirmal -Dmode=dev
		//or set as system property in program before initialzing the spring context
		System.setProperty("USER_ID", "Nirmal");
		System.setProperty("mode", "dev");
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
