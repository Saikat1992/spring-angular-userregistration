package com.example.javatechie;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import com.javatechie.SpringAngularUserregistrationApplication;

import jakarta.annotation.PostConstruct;

@SpringBootTest 
class JavatechieSession1ApplicationTests {
	
public static Logger logger= LoggerFactory.getLogger(SpringAngularUserregistrationApplication.class);
	
	@PostConstruct
	public void contextLoads() {
		logger.info("Test case executing...");
		assertEquals(true, true);
	}
  
  }
 


