package com.nirmal.spring.hellotest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

public class MoreComponentsAnnotationTest {

	@Test
	public void testServiceAnnotation() {
		ApplicationContext context = SpringApplication.run(ServiceConfig.class);
		Welcome welcome = context.getBean(Welcome.class);
		assertEquals("Welcome", welcome.message());
	}
	
	@Test
	public void testRepositoryAnnotation() {
		ApplicationContext context = SpringApplication.run(ServiceConfig.class);
		SongRepository repository = context.getBean(SongRepository.class);
		assertEquals("Classical", repository.getType());
	}

	@Test
	public void testControllerAnnotation() {
		ApplicationContext context = SpringApplication.run(ServiceConfig.class);
		TrafficController controller = context.getBean(TrafficController.class);
		assertEquals("Bangalore", controller.getLocation());
	}
}

@Service
class Welcome {
	String message() {
		return "Welcome";
	}
}

@Repository
class SongRepository {
	String getType() {
		return "Classical";
	}
}

@Controller
class TrafficController {
	String getLocation() {
		return "Bangalore";
	}
}

@Configuration
@ComponentScan("com.nirmal.spring.hellotest")
class ServiceConfig {
	
}
