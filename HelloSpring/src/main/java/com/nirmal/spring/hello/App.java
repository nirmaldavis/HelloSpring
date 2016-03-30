package com.nirmal.spring.hello;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nirmal.spring.hello.api.Hello;
import com.nirmal.spring.hello.conf.HelloConfig;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    } 

    public String sayHelloWithSpring(String text) {
    	
		//Get Spring context
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HelloConfig.class);
		
		//Get Bean from Spring context
		Hello hello = context.getBean(Hello.class);
		
		context.close();
		
		return  hello.sayHello(text);
    }
}
