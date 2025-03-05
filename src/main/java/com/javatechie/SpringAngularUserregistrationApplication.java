package com.javatechie;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
//@CrossOrigin(origins = "*")
public class SpringAngularUserregistrationApplication {
	
	public static Logger logger= LoggerFactory.getLogger(SpringAngularUserregistrationApplication.class);
	
	@PostConstruct
	public void init() {
		logger.info("Application started...");
	}

	public static void main(String[] args) {
		logger.info("Application executed...");
		SpringApplication.run(SpringAngularUserregistrationApplication.class, args);
	}

}
