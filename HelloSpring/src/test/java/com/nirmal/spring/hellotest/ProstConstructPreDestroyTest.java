package com.nirmal.spring.hellotest;

import static org.junit.Assert.assertEquals;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

public class ProstConstructPreDestroyTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testPostConstructAndPreDestroy() {
		ConfigurableApplicationContext context = SpringApplication.run(ConstructConfig.class);
		User user = context.getBean(User.class);
		String name = user.getName();
		assertEquals("Nirmal Davis", name);
		
		context.close();
		
		String name2 = user.getName();
		assertEquals("Nirmal", name2);
	}

}


@Component
class User {
	
	String name;
	
	User() {
		name = "Nirmal";
	}
	
	public String getName()
	{
		return name;
	}
	
	@PostConstruct
	private void initMore() {
		name = name + " Davis";
		System.out.println("User.initMore() name : " + name);
	}
	
	@PreDestroy
	private void close() {
		name = "Nirmal";
		System.out.println("User.close() name : " + name);
	}
	

}

@Configuration
@ComponentScan("com.nirmal.spring.hellotest")
class ConstructConfig {
	//or @Bean(intitMethod="initMore", destroyMethod="clearCache")	
}
