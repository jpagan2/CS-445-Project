package com.example.REST_server;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotesController {
	private static final String template = "Hello";
	private final AtomicLong counter = new AtomicLong();
	private final AtomicLong aCounter = new AtomicLong();
	private final int[] array = new int[2];
	private final String[] convoArray = new String[2];
	
	@GetMapping("/bn/api/notes")
	public Notes notes(@RequestParam(value = "description", defaultValue = "simple note") String description) {
		return new Notes(counter.incrementAndGet(), aCounter.incrementAndGet(), convoArray, aCounter.incrementAndGet(), convoArray, aCounter.incrementAndGet(), description, aCounter.incrementAndGet(), aCounter.incrementAndGet(), description, description);
	}
}
