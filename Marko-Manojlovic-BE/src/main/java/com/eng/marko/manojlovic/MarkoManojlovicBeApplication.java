package com.eng.marko.manojlovic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
public class MarkoManojlovicBeApplication {
	@RequestMapping("/hello")
	   @ResponseBody
	   void home() {
		  System.out.println("call by angular");
	     
	   }
	
	public static void main(String[] args) {
		SpringApplication.run(MarkoManojlovicBeApplication.class, args);
	}
}
