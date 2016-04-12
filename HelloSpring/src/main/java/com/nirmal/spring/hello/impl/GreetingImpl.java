package com.nirmal.spring.hello.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.nirmal.spring.hello.api.Greeting;

@Component
public class GreetingImpl implements Greeting {

	@Override
	public String getMessage() {
		return "Welcome to Spring";
	}

}

@Component
@Profile("test1")
class GreetingImpl1 implements Greeting {

	private Person person;
	
	@Override
	public String getMessage() {
		return "Welcome to Spring, " + person.getName();
	}

	public Person getPerson() {
		return person;
	}

	//Method injection 
	@Autowired
	public void setPerson(Person person) {
		this.person = person;
	}
	
}

@Component
@Profile("test2")
class GreetingImpl2 implements Greeting {

	//Field injection
	@Autowired
	private Person person;
	
	@Override
	public String getMessage() {
		return "Welcome to Spring, " + person.getName();
	}
}


@Component
@Profile("test3")
class GreetingImpl3 implements Greeting {

	private Person person;

	//TODO:How Spring can create bean even if constructor is private ?!! 
	//Ans : ctor.setAccessible(true) - 
	//Refer @ http://stackoverflow.com/questions/5430605/how-is-spring-beanfactory-able-to-instantiate-a-non-public-class
	
	//Constructor injection
	@Autowired
	private GreetingImpl3(Person person) 
	{
		System.out.println("GreetingImpl3.GreetingImpl3()");
		this.person = person;
	}
	
	@Override
	public String getMessage() {
		return "Welcome to Spring, " + person.getName();
	}

}

@Component
@Profile("test4")
class GreetingImpl4 implements Greeting {

	//Field injection
	@Autowired(required=false)
	private Person person;
	
	@Override
	public String getMessage() {
		return "Welcome to Spring, " + person.getName();
	}

}

@Component
@Profile("test5")
class GreetingImpl5 implements Greeting {

	//Field injection
	@Autowired(required=false)
	private Person person;
	
	@Override
	public String getMessage() {
		String message = "Welcome to Spring";
		if(person != null) {
			message = "Welcome to Spring, " + person.getName();
		}
		return message;
	}

}

@Component
@Profile("test6")
class GreetingImpl6 implements Greeting {

	
	private Person person;

	
	//TODO: If constructor injection needs to work with required=false, need an empty default constructor. 
	//Otherwise bean cannot be created by spring, why ?!!
	//Reference @ http://blog.bltavares.com/2013/08/19/following-the-error-spring-autowired-and-bean/
	
	
	@Deprecated
	private GreetingImpl6()
	{
		
	}
	
	//Constructor injection
	@Autowired(required=false)
	public GreetingImpl6(Person person)
	{
		System.out.println("GreetingImpl6.GreetingImpl6(Person ) ctor");
		this.person = person;
	}
	
	@Override
	public String getMessage() {
		String message = "Welcome to Spring";
		if(person != null) {
			message = "Welcome to Spring, " + person.getName();
		}
		return message;
	}

}



@Component
//You can specify multiple profiles
@Profile({"test1","test2","test3"})
class Person {
	
	String name = "Nirmal Davis";

	public String getName() {
		return name;
	}

}


@Component("Greeting")
@Profile({"test11", "test12", "test13"})
class GreetingImpl11 implements Greeting {

	//Field injection
	@Autowired
	private Person person;
	
	@Override
	public String getMessage() {
		return "Welcome to Spring, " + person.getName();
	}
}

@Component("Person")
@Profile({"test11","test12"})
class Person2 extends Person {
	
	String name = "Nirmal Davis";

	//Field injection
	@Autowired
	Optional<Address> address;
	
	public String getName() {
		
		//Execute if Address is present
		address.ifPresent(consumer->{
			name = name + " @ " + consumer.getLine();
		});
		return name;
	}

}


@Component("Person")
@Profile({"test13"})
class Person3 extends Person {
	
	String name = "Nirmal Davis";

	//Field injection
	@Autowired
	@Qualifier("officialAddress")
	Optional<Address> address;
	
	public String getName() {
		
		//Execute if Address is present
		address.ifPresent(consumer->{
			name = name + " @ " + consumer.getLine();
		});
		return name;
	}

}



@Component 
@Profile("test11")
class Address {
	String line;
	
	public Address() {
		line = "Kundalahalli Gate";
	}

	public Address(String line) {
		super();
		this.line = line;
	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}
}

@Component("officialAddress")
@Profile("test13")
class OfficeAddress extends Address {
	public OfficeAddress() {
		super("White Field");
	}
}