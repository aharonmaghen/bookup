package com.boot;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BootApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(BootApplication.class, args);

		System.out.println("Running...");
	}
	
}
