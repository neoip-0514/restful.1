package com.example.restful1.redis;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

@Service("redisService")
public class RedisService {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private RedisTemplate<String, String> template;
	
	@Resource(name = "redisTemplate")
	private ValueOperations<String, String> valueOps;
	
	@Resource(name = "redisTemplate")
	private ListOperations<String, String> listOps;
	
	@Resource(name = "redisTemplate")
	private HashOperations<String, String, String> hashOps;
	
	@Resource(name = "redisTemplate")
	private SetOperations<String, String> setOps;
	

	
	public void addKey(String key, String value) {
		
		listOps.leftPush(key, value);
		logger.debug("key={} size={}", key, listOps.size(key));
	}
	
	public ArrayList<String> getValue(String key) {
		
		ArrayList<String> list = new ArrayList<>();
		long size = listOps.size(key);
		String value;
		for (long i = 0; i < size; i++) {
			value = listOps.rightPop(key);
			list.add(value);
		}
		
		return list;
	}

	public Long size(String key) {
		return listOps.size(key);
	}
	
}
