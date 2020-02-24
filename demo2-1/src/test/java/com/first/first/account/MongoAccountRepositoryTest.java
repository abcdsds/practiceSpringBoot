package com.first.first.account;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataMongoTest
class MongoAccountRepositoryTest {

	@Autowired
	MongoAccountRepository mongoAccountRepository;
	
	
	@Test
	void findByEmail() {
		MongoDBAccount acc = new MongoDBAccount();
		acc.setUsername("ds2");
		acc.setEmail("ds@gmail.com");
		
		mongoAccountRepository.save(acc);
		
		Optional<MongoDBAccount> byId = mongoAccountRepository.findById(acc.getId());
		assertThat(byId).isNotEmpty();
		
		
		Optional<MongoDBAccount> byEmail = mongoAccountRepository.findByEmail(acc.getEmail());
		assertThat(byEmail).isNotEmpty();
		assertThat(byEmail.get().getUsername()).isEqualTo("ds2");
		
	}

}
