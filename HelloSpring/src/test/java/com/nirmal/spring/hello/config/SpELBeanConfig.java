package com.nirmal.spring.hello.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(SimpleConfig.class)
public class SpELBeanConfig {

	@Value("#{person.address.line}")
	String addressLine;
	
	@Bean(name="addressLine")
	String getAddress() {
		return addressLine;
	}
}


@Configuration
class SimpleConfig {
	
	@Bean(name="person")
	Person getPerson() {
		return new Person("Nirmal Davis", new Address("Kundalahalli Gate"));
	}
}

class Person {
	private String name;
	private Address address;
	
	public Person(String name, Address address) {
		super();
		this.name = name;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}

class Address {
	private String line;

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