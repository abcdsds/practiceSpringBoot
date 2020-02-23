package com.first.first.account;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.Optional;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepositoryTest {

	@Autowired
	DataSource dataSource;
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	AccountRepository accountRepository;
	
	@Test
	public void Test() throws SQLException {
		
		Account account = new Account();
		account.setUsername("ds2");
		account.setPassword("pass");
		
		Account newAccount = accountRepository.save(account);
		
		assertThat(newAccount).isNotNull();
		
		Optional<Account> existingAccount = accountRepository.findByUsername(newAccount.getUsername());
		assertThat(existingAccount).isNotEmpty();
		
		Optional<Account> nonExistingAccount = accountRepository.findByUsername(null);
		assertThat(nonExistingAccount).isEmpty();
		
//		try(Connection con = dataSource.getConnection()) {
//
//			DatabaseMetaData metaData = con.getMetaData();
//			System.out.println(metaData.getURL());
//			System.out.println(metaData.getClass());
//			System.out.println(metaData.getDriverName());
//			System.out.println(metaData.getUserName());
//		}
	}
}
