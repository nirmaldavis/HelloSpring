package com.nirmal.spring.hellotest;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

public class LazyAnnotationTest {

	static String state = "NONE";
	
	@Test
	public void testLazyAnnotation() {
		ConfigurableApplicationContext context = SpringApplication.run(LazyConfig.class);
		assertEquals("NONE", LazyAnnotationTest.state);
		context.getBean(Bus.class);
		assertEquals("CONSTRUCTED", LazyAnnotationTest.state);
	}

}

@Component
@Lazy
class Bus {
	Bus() {
		System.out.println("Bus is constructed");
		LazyAnnotationTest.state = "CONSTRUCTED";
	}
	String start() {
		return "Bus is moving";
	}
}

@Configuration
@ComponentScan("com.nirmal.spring.hellotest")
class LazyConfig {
	
}
