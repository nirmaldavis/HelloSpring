package com.nirmal.spring.hello;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import com.nirmal.spring.hello.api.Greeting;
import com.nirmal.spring.hello.conf.GreetingAnnotationConfig;

public class AnnotationConfigTest {

//	private ApplicationContext context;
//
//	@Before
//	public void setUp() throws Exception {
//		context = SpringApplication.run(GreetingAnnotationConfig.class);
//	}

	@Test
	public void testGettingBeanByAnnotationConfig() {
		
		System.clearProperty("spring.profiles.active");
		
		ApplicationContext context = SpringApplication.run(GreetingAnnotationConfig.class);
		Greeting greeting = context.getBean(Greeting.class);
		String message = greeting.getMessage();
		assertEquals("Welcome to Spring", message);
	}
	
	@Test
	public void testBeanIdDerivedFromClassNameGreetingImpl() {
		
		System.clearProperty("spring.profiles.active");
		
		//Testing Bean id derived from class name
		//the first letter of class name becomes small letter when it becomes bean id
		ApplicationContext context = SpringApplication.run(GreetingAnnotationConfig.class);
		Greeting greeting = context.getBean("greetingImpl", Greeting.class);
		String message = greeting.getMessage();
		System.out.println("message : " + message);
		assertEquals("Welcome to Spring", message);
	}
	
	/**
	 * Bean defined in a particular @Profile should not be available until profile is set "spring.profiles.active"
	 */
	@Test(expected=NoSuchBeanDefinitionException.class) 
	public void testProfileBeanWithoutSettingProfile()
	{
		//Helps in removing the profile property set in other tests if any
		System.clearProperty("spring.profiles.active");
		
		System.out.println("AnnotationConfigTest.testProfileBeanWithoutSettingProfile() : " + System.getProperty("spring.profiles.active"));
		
		ApplicationContext context2 = SpringApplication.run(GreetingAnnotationConfig.class);
		Greeting greeting = context2.getBean("greetingImpl2", Greeting.class);
		System.out.println(greeting.getMessage());
		fail("Should not have reached here");
	}
	

	/**
	 * Bean defined in a particular @Profile should  be available when profile is set "spring.profiles.active"
	 */
	@Test 
	public void testProfileBeanWithSettingProfile()
	{
		System.setProperty("spring.profiles.active", "test1");
		
		System.out.println("AnnotationConfigTest.testProfileBeanWithSettingProfile() : " + System.getProperty("spring.profiles.active"));
		
		
		ApplicationContext context2 = SpringApplication.run(GreetingAnnotationConfig.class);
		Greeting greeting = context2.getBean("greetingImpl1", Greeting.class);
		String message = greeting.getMessage();
		assertEquals("Welcome to Spring, Nirmal Davis", message);
	}

	@Test(expected=NoUniqueBeanDefinitionException.class)
	public void testNoUniqueBeanException() {
		System.setProperty("spring.profiles.active", "test1");
		
		ApplicationContext context2 = SpringApplication.run(GreetingAnnotationConfig.class);
		Greeting greeting = context2.getBean(Greeting.class);
		System.out.println(greeting.getMessage());
		fail("Should not have reached here");
		
	}
	
	@Test 
	public void testFiledInjection()
	{
		System.setProperty("spring.profiles.active", "test2");
		
		ApplicationContext context2 = SpringApplication.run(GreetingAnnotationConfig.class);
		Greeting greeting = context2.getBean("greetingImpl2",Greeting.class);
		String message = greeting.getMessage();
		assertEquals("Welcome to Spring, Nirmal Davis", message);
	}

	@Test 
	public void testConstructorInjection()
	{
		System.setProperty("spring.profiles.active", "test3");
		
		ApplicationContext context2 = SpringApplication.run(GreetingAnnotationConfig.class);
		Greeting greeting = context2.getBean("greetingImpl3",Greeting.class);
		String message = greeting.getMessage();
		assertEquals("Welcome to Spring, Nirmal Davis", message);
	}

	@Test(expected=NullPointerException.class)
	public void testRequiredFalseInFieldInjection()
	{
		System.setProperty("spring.profiles.active", "test4");
		
		ApplicationContext context2 = SpringApplication.run(GreetingAnnotationConfig.class);
		Greeting greeting = context2.getBean("greetingImpl4",Greeting.class);
		String message = greeting.getMessage();
		System.out.println("AnnotationConfigTest.testRequiredFalseInFieldInjection() - message : " + message);
		assertEquals("Welcome to Spring, Nirmal Davis", message);
	}

	@Test
	public void testRequiredFalseInFieldInjectionWorking()
	{
		System.setProperty("spring.profiles.active", "test5");
		
		ApplicationContext context2 = SpringApplication.run(GreetingAnnotationConfig.class);
		Greeting greeting = context2.getBean("greetingImpl5",Greeting.class);
		String message = greeting.getMessage();
		System.out.println("AnnotationConfigTest.testRequiredFalseInFieldInjection() - message : " + message);
		assertEquals("Welcome to Spring", message);
	}
	
	@Test 
	public void testRequiredFalseInConstructorInjection()
	{
		System.setProperty("spring.profiles.active", "test6");
		
		ApplicationContext context2 = SpringApplication.run(GreetingAnnotationConfig.class);
		Greeting greeting = context2.getBean("greetingImpl6",Greeting.class);
		String message = greeting.getMessage();
		System.out.println("AnnotationConfigTest.testRequiredFalseInConstructorInjection() - message : " + message);
		assertEquals("Welcome to Spring", message);
	}
	
	
	
	@Test
	public void testOptionalWithAddress() {
		System.setProperty("spring.profiles.active", "test11");
		
		ApplicationContext context2 = SpringApplication.run(GreetingAnnotationConfig.class);
		Greeting greeting = context2.getBean("Greeting",Greeting.class);
		String message = greeting.getMessage();
		System.out.println("AnnotationConfigTest.testOptionalWithAddress() - message : " + message);
		assertEquals("Welcome to Spring, Nirmal Davis @ Kundalahalli Gate", message);
	}
	

	@Test 
	public void testOptionalWithoutAddress() {
		System.setProperty("spring.profiles.active", "test12");
		
		ApplicationContext context2 = SpringApplication.run(GreetingAnnotationConfig.class);
		Greeting greeting = context2.getBean("Greeting",Greeting.class);
		String message = greeting.getMessage();
		System.out.println("AnnotationConfigTest.testOptionalWithoutAddress() - message : " + message);
		assertEquals("Welcome to Spring, Nirmal Davis", message);
	}

	@Test
	public void testOptionalWithQualifiedAddress() {
		System.setProperty("spring.profiles.active", "test13");
		
		ApplicationContext context2 = SpringApplication.run(GreetingAnnotationConfig.class);
		Greeting greeting = context2.getBean("Greeting",Greeting.class);
		String message = greeting.getMessage();
		System.out.println("AnnotationConfigTest.testOptionalWithQualifiedAddress() - message : " + message);
		assertEquals("Welcome to Spring, Nirmal Davis @ White Field", message);
	}

	
	@Test @Ignore
	public void testAutoWiredInComponent() {
//		System.setProperty("spring.profiles.active", "test");
		ApplicationContext context2 = SpringApplication.run(GreetingAnnotationConfig.class);
		Greeting greeting = context2.getBean("greetingImpl2", Greeting.class);
		String message = greeting.getMessage();
		System.out.println("message : " + message);
		
		assertEquals("Welcome to Spring, nirmal Davis", message);
		
	}

}
