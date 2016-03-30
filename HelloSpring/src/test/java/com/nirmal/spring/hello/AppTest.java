package com.nirmal.spring.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nirmal.spring.hello.api.Hello;
import com.nirmal.spring.hello.conf.HelloConfig;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
	

	App app = null;
	
	AnnotationConfigApplicationContext context = null;
	
    @Override
	protected void setUp() throws Exception {

		super.setUp();
		app = new App();
		
		System.out.println("AppTest.setUp()");
		
		//Get Spring context
		context = new AnnotationConfigApplicationContext(HelloConfig.class);
		
		//TODO: What is the dependency we need to setup to use SpringApplication class
//		SpringApplication.run(HelloConfig.class);

	}

	/**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
//    public void testApp()
//    {
//        assertTrue( true );
//    }
    
//    public void testSayHelloWithSpring() {
//    	
//    	String text = "Spring World..!!";
//		String helloWithSpringActual = app.sayHelloWithSpring(text );
//		System.out.println("helloWithSpringActual : " + helloWithSpringActual);
//		assertEquals("Hello, "+text, helloWithSpringActual);
//		
//    }
    
    /**
     * Testing get bean by class , if type is unique
     */
//    public void testGetBeanByClass() {
//    	
//    	Hello hello = context.getBean(Hello.class);
//    	assertNotNull(hello);
//    	
//    	String name = "Nirmal";
//		String sayHello = hello.sayHello(name);
//		
//		assertEquals("Hello, " + name, sayHello);
//		
//		
//    }
    
    /**
     * Testing get bean by bean id
     */
    public void testGetBeanByBeanId() {
    	
    	Hello hello = (Hello)context.getBean("getHello");
    	assertNotNull(hello);
    	
    	String name = "Nirmal";
		String sayHello = hello.sayHello(name);
		
		assertEquals("Hello, " + name, sayHello);
		
    }    

    /**
     * Testing get bean by bean id without cast
     */
    public void testGetBeanByBeanIdWithoutCast() {
    	
    	Hello hello = context.getBean("getHello", Hello.class);
    	assertNotNull(hello);
    	
    	String name = "Nirmal";
		String sayHello = hello.sayHello(name);
		
		assertEquals("Hello, " + name, sayHello);
		
    }
    
    public void testExceptionIfBeanTypeNotUnique() {
    	
    	try {
		
    		Hello hello = context.getBean(Hello.class);
    	
    		fail("Ideally should not have reached here, as bean type not unique");
    		
    		String name = "Nirmal";
    		String sayHello = hello.sayHello(name);
    		
		} catch (Exception e) {

			assertNotNull(e);
			System.out.println(e.getMessage());
		}
    	
    	
    	
    }
}



/*

	TODO: 1. How to check whether expected exception is thrown by junit way



*/