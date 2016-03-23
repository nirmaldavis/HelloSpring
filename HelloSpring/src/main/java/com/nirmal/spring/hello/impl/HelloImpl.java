package com.nirmal.spring.hello.impl;

import com.nirmal.spring.hello.api.Hello;

public class HelloImpl implements Hello {

	@Override
	public String sayHello(String name) {
		return "Hello, " + name;
	}

}
