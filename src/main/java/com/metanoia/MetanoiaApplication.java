package com.metanoia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.metanoia")
public class MetanoiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MetanoiaApplication.class, args);
	}

}
