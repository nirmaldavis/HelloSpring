package com.nirmal.spring.hello;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import com.nirmal.spring.hello.config.ProfileConfig;

public class ProfileTest {

	
	@Test
	public void testDevProfile() {
		System.setProperty("spring.profiles.active", "dev");
		ApplicationContext context = SpringApplication.run(ProfileConfig.class);
		String bean = context.getBean("user", String.class);
		System.out.println(bean);
		assertEquals("Nirmal Davis", bean);
	}

	@Test
	public void testTestProfile() {
		System.setProperty("spring.profiles.active", "test");
		ApplicationContext context = SpringApplication.run(ProfileConfig.class);
		String bean = context.getBean("user", String.class);
		System.out.println(bean);
		assertEquals("Dummy", bean);
	}

	@Test(expected=NoSuchBeanDefinitionException.class)
	public void testWithoutProfile() {
		//System.setProperty("spring.profiles.active", "test");
		ApplicationContext context = SpringApplication.run(ProfileConfig.class);
		String bean = context.getBean("user", String.class);
		System.out.println(bean);
		assertEquals("Dummy", bean);
	}

}
