package com.nirmal.spring.hellotest;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;
import javax.inject.Named;

import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

public class InjectAnnotationTest {

	@Test 
	public void testInjectNamed() {
		ConfigurableApplicationContext context = SpringApplication.run(InjectAnnotaionConfig.class);
		Hostel hostel = context.getBean(Hostel.class);
		String name = hostel.getStudent().getName();
		assertEquals("Hemantha", name);
		
	}

}

@Named
class Hostel {
	
	@Inject
	Student student;

	public Student getStudent() {
		return student;
	}
}

@Named
class Student {
	String name = "Hemantha";

	public String getName() {
		return name;
	}
}


@Configuration
@ComponentScan("com.nirmal.spring.hellotest")
class InjectAnnotaionConfig {
	
}