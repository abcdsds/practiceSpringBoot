package com.first.first.account;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface RedisAccountRepository extends CrudRepository<RedisAccount, String>{

	Optional<Account> findByUsername(String username);

	
	
}
