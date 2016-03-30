package com.nirmal.spring.hello;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nirmal.spring.hello.api.Hello;
import com.nirmal.spring.hello.config.BeanScopeConfig;

public class BeanScopeTest {

	private ApplicationContext context;

	@Before
	public void setUp() throws Exception {
		context = SpringApplication.run(BeanScopeConfig.class);
	}

	@Test
	public void testBeanScopeDefault() {
		Hello helloBean1 = context.getBean("helloBean", Hello.class);
		Hello helloBean2 = context.getBean("helloBean", Hello.class);
		assertSame(helloBean1, helloBean2);
	}
	
	@Test
	public void testBeanScopePrototype() {
		Hello helloBean1 = context.getBean("helloProtoBean", Hello.class);
		Hello helloBean2 = context.getBean("helloProtoBean", Hello.class);
		assertNotSame(helloBean1, helloBean2);
	}

	//Need to test bean scope
}
