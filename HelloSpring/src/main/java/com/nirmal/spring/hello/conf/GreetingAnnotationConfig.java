package com.nirmal.spring.hello.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.nirmal.spring.hello.impl"})
public class GreetingAnnotationConfig {

}
