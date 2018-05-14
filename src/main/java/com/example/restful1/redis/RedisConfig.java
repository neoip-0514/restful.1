package com.example.restful1.redis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

@Configuration
public class RedisConfig {

	@Value("${spring.redis.host}")
	private String redisHost;
	@Value("${spring.redis.port}")
	private int redisPort;
	
	@Bean
	public JedisConnectionFactory jedisConnectionFactory() {
		
		JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
		jedisConnectionFactory.setHostName(redisHost);
		jedisConnectionFactory.setPort(redisPort);
		jedisConnectionFactory.setTimeout(0);
		jedisConnectionFactory.setUsePool(true);
		
		return jedisConnectionFactory;
	}
	
	@Bean
	public StringRedisTemplate redisTemplate(JedisConnectionFactory jedisConnectionFactory) {
		
		StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
		stringRedisTemplate.setConnectionFactory(jedisConnectionFactory);
		
		return stringRedisTemplate;
	}
}
