package com.first.first;

import java.sql.Connection;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class PostGreSQLRunner implements ApplicationRunner {

	@Autowired
	DataSource dataSource;

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub

		
		try(Connection connection = dataSource.getConnection()) {
			
			System.out.println(dataSource.getClass());
			connection.setAutoCommit(false); //트랜잭션적용
			System.out.println(connection.getMetaData().getDriverName());
			System.out.println(connection.getMetaData().getDriverVersion());
			System.out.println(connection.getMetaData().getURL());
			System.out.println(connection.getMetaData().getUserName());

			Statement statement = connection.createStatement();
			String sql = "CREATE TABLE account(ID INTEGER NOT NULL, name VARCHAR(255), PRIMARY KEY (id))";
			//USER는 postgre에선 KEYWORD라 사용하면안됨
			statement.executeUpdate(sql);
			connection.commit();
			//connection.close();
		}
		
		jdbcTemplate.execute("INSERT INTO account VALUES (2, 'ds') ");
		
	}



}
