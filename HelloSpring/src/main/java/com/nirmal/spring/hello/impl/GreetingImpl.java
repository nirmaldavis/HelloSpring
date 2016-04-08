package com.nirmal.spring.hello.impl;

import org.springframework.stereotype.Component;

import com.nirmal.spring.hello.api.Greeting;

@Component
public class GreetingImpl implements Greeting {

	@Override
	public String getMessage() {
		return "Welcome to Spring";
	}

}
