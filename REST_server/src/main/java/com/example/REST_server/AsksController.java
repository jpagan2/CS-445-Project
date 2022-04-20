package com.example.REST_server;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsksController {
	
	private final AtomicLong counter = new AtomicLong(3);
	private final AtomicLong acounter = new AtomicLong(1);

    String[] zip_codes = {"60607", "60608"};

	Asks asks0 = new Asks("<uid" + counter.getAndIncrement() + ">", "<aid" + acounter.getAndIncrement() + ">", "gift",  "I need a twin bed frame with a spring box.", "2022-03-14", "", zip_codes, true, "<date5>");
    	
    
	@RequestMapping(value = "/bn/api/asks", method = RequestMethod.GET)
	public List<Asks> getAsks() {
	    List<Asks> list = new ArrayList<>();
	    list.add(asks0);
	    return list;
	}
/*
	@RequestMapping(value = "/bn/api/accounts", method = RequestMethod.POST)
	public 
	
	@RequestMapping(value = "/bn/api/accounts", method = RequestMethod.PUT)
	public 
		
*/

}