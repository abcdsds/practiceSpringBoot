package com.first.first;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.connector.Connector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.first.first.account.MongoAccountRepository;
import com.first.first.account.MongoDBAccount;

@SpringBootApplication
@RestController
//@EnableConfigurationProperties(DemoProperties.class) 자동으로 등록되어있음
public class Demo21Application {

	@GetMapping("/hello")
	public String test() {
		return "hello Spring!";
	}
	
	@Bean
	public ServletWebServerFactory serverFactory() {
		
		TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
		tomcat.addAdditionalTomcatConnectors(createStandardConnector());
		return tomcat;
				
	}
	
	private Connector createStandardConnector() {
		
		//새로운 커넥터로 8443포트의 원래 커넥터와는 다른 커넥터
		
		Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
		connector.setPort(8080);
		
		return connector;
	}
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	@Autowired
	MongoAccountRepository mongoAccountRepository;
	
	@Bean
	public ApplicationRunner applicationRunner() {
		
		
		return args -> {
			MongoDBAccount acc = new MongoDBAccount();
			acc.setEmail("ds@ggg");
			acc.setUsername("ds");
			
			//mongoTemplate.insert(acc);
			mongoAccountRepository.insert(acc);
			System.out.println("finished");
			
		};
	}
	
	
	public static void main(String[] args) throws LifecycleException {
		
		//SpringApplication.run(Demo21Application.class, args);
		
		SpringApplication spa = new SpringApplication(Demo21Application.class);
		//spa.addListeners(new SampleListener());
		spa.run(args);
		
//
//		Tomcat tomcat = new Tomcat();
//		tomcat.setPort(9090);
//
//		tomcat.getHost().setAppBase("work");
//		System.out.println(tomcat.getHost().getAppBase());
//		Context context = tomcat.addContext("/", "/");
//
//		HttpServlet servlet = new HttpServlet() {
//
//			@Override
//			protected void doGet(HttpServletRequest req, HttpServletResponse resp)
//					throws ServletException, IOException {
//				// TODO Auto-generated method stub
//				PrintWriter writer = resp.getWriter();
//				writer.println("<html><head><title>");
//				writer.println("Hey, Tomcat");
//				writer.println("</title></head>");
//				writer.println("<body><h1>Hello TOmcat<h1></body>");
//				writer.println("</html>");
//			}
//
//		};
//
//		String ServletName = "demoServlet";
//		tomcat.addServlet("/", ServletName, servlet);
//		context.addServletMappingDecoded("/hello", ServletName); // hello 경로에 요청이 오면 demoServlet가 보여지게됨
//		
//		
//		tomcat.getConnector();
//		tomcat.start();

		// tomcat.getServer().await();

//		SpringApplication spa = new SpringApplication(Demo21Application.class);
//		spa.setWebApplicationType(WebApplicationType.NONE);
//		spa.run(args);


	}
}
