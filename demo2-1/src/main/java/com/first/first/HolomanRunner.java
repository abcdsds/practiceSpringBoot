package com.first.first;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class HolomanRunner implements ApplicationRunner {

	
	private Logger log = LoggerFactory.getLogger(HolomanRunner.class);
	
	@Autowired
	private String hello;
	
	@Autowired
	DemoProperties demoProperties;
	
	@Autowired
	Holoman holoman;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		log.debug("=======================");
		log.debug(hello);
		//log.info(demoProperties.getAge());
		log.debug(demoProperties.getName());
		//log.info(demoProperties.getSessionTimeOut());
		
		
//		System.out.println(holoman);
//		System.out.println("========================");
//		System.out.println(hello);
//		System.out.println(demoProperties.getAge());
//		System.out.println(demoProperties.getName());
//		System.out.println(demoProperties.getFullName());
//		System.out.println(demoProperties.getSessionTimeOut());
//		System.out.println("========================");
	}
	
	
}
