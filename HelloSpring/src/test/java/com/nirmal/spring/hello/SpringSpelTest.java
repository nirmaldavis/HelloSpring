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

}
