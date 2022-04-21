package com.example.REST_server;


import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;   
import java.time.LocalDateTime;   
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AsksController {

	@Autowired
	AsksService asksService;
	
	@PostMapping("/bn/api/accounts/{uid}/asks")
	@ResponseStatus(HttpStatus.CREATED)
	public Asks addAsk(@RequestBody Asks newAsks, HttpServletResponse response) {
		response.setHeader("Location", "/bn/api/accounts/{uid}/asks/{uid}" + newAsks.getUid());
		return asksService.addAsks(newAsks);
	}
}