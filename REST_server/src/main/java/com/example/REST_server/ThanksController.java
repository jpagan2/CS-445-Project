package com.example.REST_server;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ThanksController {
	private static final String template = "Hello";
	private final AtomicLong counter = new AtomicLong();
	private final AtomicLong aCounter = new AtomicLong();
	
	@GetMapping("/bn/api/thanks")
	public Thanks thanks(@RequestParam(value = "description", defaultValue = "thank you") String description) {
		return new Thanks(counter.incrementAndGet(), counter.incrementAndGet(), counter.incrementAndGet(), description, description);
	}
}
