package com.first.first;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import com.first.first.account.RedisAccount;
import com.first.first.account.RedisAccountRepository;

//@Component
public class RedisRunner implements ApplicationRunner{
	
	@Autowired
	StringRedisTemplate redisTemplate;

	@Autowired
	RedisAccountRepository redisAccountRepository; 
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		ValueOperations<String, String>values = redisTemplate.opsForValue();
		values.set("ds", "jds");
		values.set("springboot", "2.1");
		values.set("hello", "world");
		
		RedisAccount acc = new RedisAccount();
		acc.setEmail("ds@gmail.com");
		acc.setUsername("ds");
		
		redisAccountRepository.save(acc);
		
		Optional<RedisAccount> byId = redisAccountRepository.findById(acc.getId()); 
		System.out.println(byId.get().getUsername());
		System.out.println(byId.get().getEmail());
		
		
	}
	

}
