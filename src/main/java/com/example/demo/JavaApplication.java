package com.example.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
public class JavaApplication {
	
	List<String> clusterNodes = (List<String>) Arrays.asList("127.0.0.1:6375");

	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
//		JedisConnectionFactory factory = new JedisConnectionFactory();
//		factory.setHostName("localhost");
//		factory.setPort(6381);
		return new JedisConnectionFactory(new RedisClusterConfiguration(clusterNodes));
	}
	
	@Bean
	RedisTemplate<String,Token> redisTemplate() {
		RedisTemplate<String,Token> redisTemplate = new RedisTemplate<String,Token>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		return redisTemplate;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(JavaApplication.class, args);
	}

}
