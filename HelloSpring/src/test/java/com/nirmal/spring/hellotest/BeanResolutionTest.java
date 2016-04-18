package com.nirmal.spring.hellotest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

public class BeanResolutionTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test 
	public void testGetBean() {
		ApplicationContext context = SpringApplication.run(MyConfig.class);
		Person person = context.getBean(Person.class);
		assertEquals("Nirmal Davis", person.toString());
	}

	/**
	 * Even though there were two beans of type Address,
	 * the spring uses variable name (ie permananentAdddress) for bean resolution or disambiguation  
	 */
	@Test
	public void testGetBeanByDisambiguationUsingVariableNameThanType()
	{
		ApplicationContext context = SpringApplication.run(MyConfig.class);
		Employee employee = context.getBean(Employee.class);
		assertEquals("Employee @ Kundalahalli Gate", employee.toString());
	}
}

@Component
class Person {
	String name = "Nirmal Davis";
	
	public String toString() {
		return name;
	}
}

interface Address {
	String getLine();
}

@Component("permananentAdddress")
class HomeAdddress implements Address
{

	@Override
	public String getLine() {
		return "Kundalahalli Gate";
	}
	
}

@Component
class OfficeAddress implements Address {

	@Override
	public String getLine() {
		return "White Filed";
	}
	
}

@Component
class Employee {
	
	@Autowired
	Address permananentAdddress;
	
	
	public String toString()
	{
		return "Employee @ " + permananentAdddress.getLine();
	}
}

@Configuration
@ComponentScan("com.nirmal.spring.hellotest")
class MyConfig {
	
}