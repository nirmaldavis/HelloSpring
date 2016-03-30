package com.nirmal.spring.hello;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nirmal.spring.hello.config.ApplicationConfig;

public class AppConfigTest {

	// private AnnotationConfigApplicationContext context;

	private ConfigurableApplicationContext context;

	@Before
	public void setup() {
		// context = new
		// AnnotationConfigApplicationContext(ApplicationConfig.class);
		context = SpringApplication.run(ApplicationConfig.class);

	}

	@Test
	public void testNameBean() {
		String name = context.getBean("getName", String.class);
		assertEquals("Nirmal Davis", name);

	}

	@Test
	public void testMessageBean() {
		String messageBean = context.getBean("message", String.class);
		assertEquals("Hello, Nirmal Davis", messageBean);
	}

	@Test
	public void testBeanByMethodParamInjection() {
		String displayBean = context.getBean("displayInUpperCase", String.class);
		String expected = context.getBean("message", String.class).toUpperCase();
		System.out.println(expected);
		assertEquals(expected, displayBean);
	}
	
	@Test
	public void testDuplicateBeans() {
		System.out.println("AppConfigTest.testDuplicateBeans()");
		String bean = context.getBean("sample", String.class);
		System.out.println(bean);
		assertEquals("Example 2", bean);
	}
}

// TODO: I want to test AutoWired
//TODO : How does the order decided if same bean id (name=XXX) used for multiple beans in same file. I have seen in case of multiple files it is based on the order of imports

