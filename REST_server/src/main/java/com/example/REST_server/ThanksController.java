package com.example.REST_server;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ThanksController {

	@Autowired
	ThanksService thanksService;
	
	@PostMapping("/bn/api/accounts/{uid}/thanks")
	@ResponseStatus(HttpStatus.CREATED)
	public Thanks addThanks(@RequestBody Thanks newThanks, @PathVariable("uid") String uid, HttpServletResponse response) {
		response.setHeader("Location", "/accounts/%3Cuid3%3E/thanks/<tid1>");
		return thanksService.addThanks(newThanks);
	}
	@PutMapping("/bn/api/accounts/{uid}/thanks/{tid}")
	public Map putThanks(@RequestBody Thanks updatedThanks,  HttpServletResponse response) {
		response.setStatus(204);
		return thanksService.updateThanks(updatedThanks);
	}
	
	@GetMapping("/bn/api/accounts/{uid}/thanks")
	public List<Thanks> getThanks() {
	    return thanksService.getThanks();
	}
	
	@GetMapping("/bn/api/thanks/received/{uid}")
	public ResponseEntity<Thanks> getAsksByAid(@PathVariable("uid")String thanksId) {
		Thanks thanks = thanksService.getThanksByUid(thanksId);
		if(thanks == null) {
			return new ResponseEntity<Thanks> (HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Thanks> (thanks,HttpStatus.OK);
	}

}