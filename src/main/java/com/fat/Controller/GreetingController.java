package com.fat.Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fat.access.Greeting;



@RestController
public class GreetingController {

	private static final String template = "Hello, %s";
	private static final AtomicLong counter = new AtomicLong();

	
	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value ="name", defaultValue = "World") String name)
	{
		return new Greeting(counter.getAndIncrement(), String.format(template, name));
	}
	

	
}
