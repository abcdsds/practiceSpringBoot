//package com.first.first;
//
//import org.apache.catalina.LifecycleException;
//import org.apache.catalina.connector.Connector;
//import org.apache.catalina.startup.Tomcat;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.WebApplicationType;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
//import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.web.bind.annotation.GetMapping;
//
////@Configuration
////@ComponentScan
////@EnableAutoConfiguration
//
////@SpringBootApplication
//public class Demo2Application {
//
//	public static void main(String[] args) throws LifecycleException {
//
//		////////////////////////////////////////////////////////////////////////
//		//@EnableAutoConfiguration 은 web application으로 만들려고함
//		//@Configuration
//		//@ComponentScan
//		//@EnableAutoConfiguration
//		// 이 3가지를 다 사용하는것이 @SpringBootApplication
//		//@EnableAutoConfiguration autoconfigure 안에
//		// org.springframework.boot.autoconfigure.EnableAutoConfiguration
//		// 으로 키값을 설정함
//		// 다 적용시키는건아니고 @conditional로 적용여부를 체크함
//		
//		SpringApplication application = new SpringApplication(Demo2Application.class);
//		application.setWebApplicationType(WebApplicationType.NONE);
//		application.run(args);
//
//		// SpringApplication.run(Demo2Application.class, args);
//		
//		////////////////////////////////////////////////////////////////////////
//		
//		////////////////////////////////////////////////////////////////////////
//		
//		Tomcat tomcat = new Tomcat();
//		tomcat.setPort(9090);
//		
//		//tomcat.getHost().setAppBase("work");
//		System.out.println(tomcat.getHost().getAppBase());
//		tomcat.addContext("/", "../work"); // 내꺼 appbase가 webapps로 되어있어서 work로 바꿔줌 아니면 위에서 setAppbase로 work로바꿔줘도됨
//		
//		tomcat.getConnector(); // tomcat 9이상은 이거 있어야 켜짐
//		tomcat.start();
//		
//		//tomcat.getServer().await();
//		
//		/////////////////////////////////////////////////////////////////////////
//	}
//	
//	@GetMapping("/hello")
//	public String test() {
//		return "hello Spring!";
//	}
//	
//	@Bean
//	public ServletWebServerFactory serverFactory() {
//		
//		TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
//		tomcat.addAdditionalTomcatConnectors(createStandardConnector());
//		return tomcat;
//				
//	}
//	
//	private Connector createStandardConnector() {
//		
//		//새로운 커넥터로 8443포트의 원래 커넥터와는 다른 커넥터
//		
//		Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
//		connector.setPort(8080);
//		
//		return connector;
//	}
//	
//	
//	
//	// 2.1버전 이후에는 에러남
//	// The bean 'holoman', defined in com.first.first.Demo21Application, could not be registered. A bean with that name has already been defined in class path resource [com/first/first/HolomanConfiguration.class] and overriding is disabled.
//	// Consider renaming one of the beans or enabling overriding by setting spring.main.allow-bean-definition-overriding=true
//	//
//	
//	@Bean
//	public Holoman holeman() {
//		Holoman holoman= new Holoman();
//		holoman.setHowLong(60);
//		holoman.setName("ds");
//		return holoman;
//	}
//
//}
