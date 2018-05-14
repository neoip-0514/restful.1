package com.example.restful1.redis;

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
		logger.debug("key[%s] size=[%d]", key, listOps.size(key));
	}
	
	public String getValue(String key) {
		
		String value = listOps.rightPop(key);
		
		return value;
	}
	
}
