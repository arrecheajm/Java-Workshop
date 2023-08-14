package com.luv2code.springcoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication; // Autoconfiguration, component scanning additional
																					//additional config

@SpringBootApplication(
//		scanBasePackages = {"com.luv2code.springcoredemo","com.luv2code.util"} // Adding packages outiside of the package containing the application
)
public class SpringcoredemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcoredemoApplication.class, args);
	}

}
