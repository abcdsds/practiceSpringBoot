package com.first.first.account;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountRepositoryTest2 {

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
		
		accountRepository.findByUsername(null);
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
