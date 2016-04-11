package com.nirmal.spring.hello.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nirmal.spring.hello.api.Greeting;

@Component("greeting")
public class GreetingImpl implements Greeting {

	private Person person;
	
	@Override
	public String getMessage() {
		return "Welcome to Spring, " + person.getName();
	}

	public Person getPerson() {
		return person;
	}

	//Method injection 
	@Autowired(required=false)
	public void setPerson(Person person) {
		this.person = person;
	}
	
}

@Component
class Person {
	
	String name = "Nirmal Davis";

	//Filed injection
	@Autowired
	Optional<Address> address;
	
	public String getName() {
		
		//Execute if Address is present
		address.ifPresent(consumer->{
			name = name + " @ " + consumer.getLine();
		});
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}

//@Component
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