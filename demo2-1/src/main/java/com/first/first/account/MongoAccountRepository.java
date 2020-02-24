package com.first.first.account;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoAccountRepository extends MongoRepository<MongoDBAccount, String>{

	Optional<Account> findByUsername(String username);

	Optional<MongoDBAccount> findByEmail(String email);

	
	
}
