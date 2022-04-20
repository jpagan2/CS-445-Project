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
public class GivesController {
	private final AtomicLong counter = new AtomicLong();
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
    LocalDateTime date_created = LocalDateTime.now();
    String formatted_date = date_created.format(myFormatObj);
    int[] zip_codes = {12345, 12345};

	Gives gives0 = new Gives("<uid" + counter.getAndIncrement() + ">", "<gid" + counter.getAndIncrement() + ">", "type",  "description", "start-date", "end-date", zip_codes, true, formatted_date) ;
    	
    
	@RequestMapping(value = "/bn/api/gives", method = RequestMethod.GET)
	public List<Gives> getAsks() {
	    List<Gives> list = new ArrayList<>();
	    list.add(gives0);
	    return list;
	}
/*
	@RequestMapping(value = "/bn/api/gives", method = RequestMethod.POST)
	public 
	
	@RequestMapping(value = "/bn/api/gives", method = RequestMethod.PUT)
	public 
		
*/

}