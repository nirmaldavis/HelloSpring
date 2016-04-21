package com.nirmal.spring.hellotest;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

public class XMLConfigTest {

	@Test 
	public void testGetBeanFromXMLConfig() {
		ConfigurableApplicationContext context = SpringApplication.run(XMLConfig.class);
		Worker worker = context.getBean(Worker.class);
		assertEquals("Pavan", worker.getName());
		
		Manager manager = context.getBean("manager", Manager.class);
		assertNotNull(manager);
	}

	@Test
	public void testConstructorInjectionUsingXMLConfig(){
		ConfigurableApplicationContext context = SpringApplication.run(XMLConfig.class);
		Manager manager = context.getBean(Manager.class);
		assertEquals("Ramakanth", manager.getName());
		assertEquals("Pavan", manager.getWorker().getName());
	}
}


class Worker {
	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}


class Manager {
	//Need to set the worker by xml config beans
	String name;
	public Worker getWorker() {
		return worker;
	}

	public void setWorker(Worker worker) {
		this.worker = worker;
	}

	public String getName() {
		return name;
	}

	public String getDesignation() {
		return designation;
	}

	String designation;
	Worker worker;
	
	Manager(String name, String designation) {
		this.name = name;
		this.designation = designation;
	}
	
	
}

@Configuration
@ImportResource("classpath:com/nirmal/spring/hellotest/hello-config.xml")
class XMLConfig {
	
}