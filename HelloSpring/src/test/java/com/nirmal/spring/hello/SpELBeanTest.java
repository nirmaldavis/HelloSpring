package com.nirmal.spring.hello;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import com.nirmal.spring.hello.config.SpELBeanConfig;

public class SpELBeanTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testReferBeanUsingSpEL() {
		ApplicationContext context = SpringApplication.run(SpELBeanConfig.class);
		String addressLine = context.getBean("addressLine", String.class);
		System.out.println("addressLine : " + addressLine);
		assertEquals("Kundalahalli Gate", addressLine);
		
	}

}
