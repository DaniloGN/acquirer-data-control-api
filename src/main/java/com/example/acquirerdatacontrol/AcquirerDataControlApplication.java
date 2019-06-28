package com.example.acquirerdatacontrol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class AcquirerDataControlApplication {

	public static void main(String[] args) {
		SpringApplication.run(AcquirerDataControlApplication.class, args);
	}

	@GetMapping("/home")
	public String hello(){
		return "Hello";
	}

}
