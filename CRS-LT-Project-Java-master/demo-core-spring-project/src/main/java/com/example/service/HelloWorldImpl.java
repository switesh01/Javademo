/**
 * 
 */
package com.example.service;

import org.springframework.stereotype.Service;

/**
 * @author sohamslc
 *
 */
@Service //internally @Service/@Component converts to @Bean annotation
public class HelloWorldImpl implements HelloWorld {
	@Override
	public String printHelloWorld(String msg) {
		System.out.println("Hello : " + msg);
		return "Hello" + msg;
	}

}
