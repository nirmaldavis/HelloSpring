package com.nirmal.spring.hellotest;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

public class ResourceAnnotationTest {

	@Test
	public void test() {
		ConfigurableApplicationContext context = SpringApplication.run(ResourceConfig.class);
		Car car = context.getBean(Car.class);
		String name = car.getTyre().getName();
		assertEquals("MRF", name);
	}

}

@Component
class Car {
	
	//When using @Resource annotation (JSR-250), looking up bean name first
	//@AutoWired -> type then name
	//@Resource ->  name then type
	
	@Resource(name="MRFTyre")
	Tyre tyre;
	
	public Tyre getTyre() {
		return tyre;
	}
}

@Component
interface Tyre {
	
	public String getName();
		
}

@Component
class MRFTyre implements Tyre {

	@Override
	public String getName() {
		
		return "MRF";
	}
	
}

@Component
class CeatTyre implements Tyre {

	@Override
	public String getName() {
		
		return "Ceat";
	}
	
}

@Configuration
@ComponentScan("com.nirmal.spring.hellotest")
class ResourceConfig {
	
}