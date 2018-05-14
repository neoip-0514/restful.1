package com.example.restful1.redis;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {

	@Autowired
	RedisService redisService;
	
	final String key = String.format("%s", "20180514");
	
	@RequestMapping(value = "/redis/{value}", method = RequestMethod.GET)
	public HashMap<String, String> addKey(@PathVariable(name="value") String value) {

		HashMap<String, String> hm = new HashMap<>();
		
		redisService.addKey(key, value);
		hm.put("action", "addKey");
		hm.put(key, value);
		hm.put("size", Long.toString(redisService.size(key)));

		return hm; 
	}
}
