package com.school.wts.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableAutoConfiguration
public class App extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(App.class);
	}

}
