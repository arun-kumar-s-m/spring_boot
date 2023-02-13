package com.example.demo;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class InterfaceRepositoryImpl implements InterfaceRepository{
	
	private RedisTemplate<String,Token> redisTemplate;
	private HashOperations hashOperations;

	public InterfaceRepositoryImpl(RedisTemplate<String, Token> redisTemplate) {
		super();
		this.redisTemplate = redisTemplate;
		hashOperations = redisTemplate.opsForHash();
	}

	@Override
	public void save(Token token) {
		// TODO Auto-generated method stub
		hashOperations.put("TOKEN",token.getShort_url(),token);
		
	}

	@Override
	public Token findById(String short_url) {
		return (Token)hashOperations.get("TOKEN",short_url);
	}

}
