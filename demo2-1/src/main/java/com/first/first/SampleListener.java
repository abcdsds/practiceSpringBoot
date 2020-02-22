package com.first.first;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class SampleListener implements ApplicationListener<ApplicationStartedEvent>{

//	@Override
//	public void onApplicationEvent(ApplicationStartingEvent event) {
//		// TODO Auto-generated method stub
//		
//		System.out.println("=======================");
//		System.out.println("application is starting");
//		System.out.println("=======================");
//
//		
//	}

	@Override
	public void onApplicationEvent(ApplicationStartedEvent event) {
		// TODO Auto-generated method stub

		System.out.println("=======================");
		System.out.println("application is starting");
		System.out.println("=======================");
	}
	
	

}
