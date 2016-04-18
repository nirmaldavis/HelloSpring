package com.nirmal.spring.hello;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import com.nirmal.spring.hello.config.SpringSpelConfig;

public class SpringSpelTest {

	@Before
	public void setUp() throws Exception {
		
	}

	@Test 
	public void testUserBeanWithSpel() {
		
		System.setProperty("ACCOUNT_TYPE", "Savings");
		
		ApplicationContext context = SpringApplication.run(SpringSpelConfig.class);
		String accountType = context.getBean("accountType", String.class);
		System.out.println("accountType : " + accountType);
		assertEquals("Savings", accountType);
		
	}

	@Test 
	public void testAddressWithSpel() {
		
		System.setProperty("type", "Office");
		
		ApplicationContext context = SpringApplication.run(SpringSpelConfig.class);
		String address = context.getBean("address", String.class);
		System.out.println("address : " + address);
		assertEquals("JFWTC, Whitefield", address);
		
	}	
	
	@Test 
	public void testEnvVariableWithSpel() {
		
		ApplicationContext context = SpringApplication.run(SpringSpelConfig.class);
		String windir = context.getBean("windir", String.class);
		System.out.println("windir : " + windir);
		assertEquals("C:\\Windows", windir);
		
	}	
	
	@Test
	public void testDefaultValueWithSpel()
	{
		ApplicationContext context = SpringApplication.run(SpringSpelConfig.class);
		String locale = context.getBean("locale", String.class);
		assertEquals("en-US", locale);
	}
}
