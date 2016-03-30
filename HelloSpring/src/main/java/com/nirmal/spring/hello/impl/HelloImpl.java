package com.nirmal.spring.hello.impl;

import com.nirmal.spring.hello.api.Hello;

public class HelloImpl implements Hello {

	public HelloImpl(String helloName) {
		System.out.println("HelloImpl : " + helloName);
	}
	
	@Override
	public String sayHello(String name) {
		return "Hello, " + name;
	}

}
