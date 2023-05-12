package com.example.springboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.Random;

@RestController
public class HelloController {

	@GetMapping(value = "/")
	public String index() {
		return "Spring Boot!";
	}

	@GetMapping(value = "/hello")
	public String testResponse() {
		return "Hello world!!";
	}

	@GetMapping(value = "/greeting")
	public ResponseEntity<String> greeting() {
		if (new Date().getHours() >= 12) {
			return ResponseEntity.ok("Good afternoon");
		}else if(new Date().getHours() > 6) {
			return ResponseEntity.ok("Good morning");
		}
		return ResponseEntity.ok("Good evening");
	}

	@GetMapping(value = "/bool")
	public ResponseEntity<String> bool(){
		Random boolRandom = new Random();
		boolean isOnline = boolRandom.nextBoolean() ;

		String user = "Cris";
		if (isOnline){
			return ResponseEntity.ok(user + " online");
		}
		return ResponseEntity.badRequest().body(user + " offline");
	}

}
