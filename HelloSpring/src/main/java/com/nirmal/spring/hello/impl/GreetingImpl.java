package com.nirmal.spring.hello.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nirmal.spring.hello.api.Greeting;

@Component
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
	@Autowired
	public void setPerson(Person person) {
		this.person = person;
	}
	
	

}

@Component
class Person {
	
	String name = "Nirmal Davis";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}