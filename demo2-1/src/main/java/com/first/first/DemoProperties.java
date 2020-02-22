package com.first.first;

import java.time.Duration;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@ConfigurationProperties("ds")
@Validated
public class DemoProperties {

	@NotEmpty
	private String name;
	
	private int age;
	private String fullName;
	
	//@DurationUnit(ChronoUnit.SECONDS) properties에서 s붙이면 알아서 자동 컨버전됨
	private Duration sessionTimeOut = Duration.ofSeconds(30);
	
	
	
	public Duration getSessionTimeOut() {
		return sessionTimeOut;
	}
	public void setSessionTimeOut(Duration sessionTimeOut) {
		this.sessionTimeOut = sessionTimeOut;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
		

	
}
