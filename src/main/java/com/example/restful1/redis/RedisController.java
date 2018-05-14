package com.example.restful1.redis;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/redis/{key}")
public class RedisController {

	@Autowired
	RedisService redisService;
	
	final String key = String.format("%s", "20180514");
	
	@GetMapping
	public HashMap<String, Object> getKey(@PathVariable String key) {

		HashMap<String, Object> hm = new HashMap<>();
		
		ArrayList<String> list = redisService.getValue(key);
		hm.put("list", list);
		
		return hm; 
	}
	
	@PostMapping
	public HashMap<String, String> addKey(@PathVariable String key,
			@RequestBody Value value) {
		
		HashMap<String, String> hm = new HashMap<>();
		
		redisService.addKey(key, value.getValue());
		hm.put("action", "addKey");
		hm.put(key, value.getValue());
		hm.put("size", Long.toString(redisService.size(key)));
		
		return hm; 
	}
}
