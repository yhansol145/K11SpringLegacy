package com.kosmo.k11springlegacy;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import env.BoardConnection;
import env.EnvApplicationConfig;
import env.UserConnection;

@Controller
public class EnvironmentController {
	
	@RequestMapping("/environment/main1")
	public String main1(Model model) {
		
		//1. 스프링 컨테이너 생성
		ConfigurableApplicationContext ctx = 
				new GenericXmlApplicationContext();
		
		//2. Environment 객체 생성
		ConfigurableEnvironment env = 
				ctx.getEnvironment();
		
		//3. 외부파일을 읽어올 준비를 한다.
		MutablePropertySources propertySources =
				env.getPropertySources();
		
		String adminIdStr = "";
		String adminPwStr = "";
		
		try {
			//4. 외부파일의 경로를 지정한 후 addLast()로 프로퍼티 소스를 추가한다.
			/*
			classpath : 해당 키워드는 프로젝트를 배포했을때 classes폴더
				하위로 export되는 경로를 가리킨다. 우리가 작성했던 java파일이나
				그 외 xml파일 등이 포함된다.
			 */
			String envPath = 
					"classpath:EnvAdmin.properties";
			propertySources.addLast(
					new ResourcePropertySource(envPath));
			
			//5. 파일의 내용을 읽어 변수에 저장한다.
			adminIdStr = env.getProperty("admin.id");
			adminPwStr = env.getProperty("admin.pw");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//Model 객체에 속성 저장
		model.addAttribute("adminID", adminIdStr);
		model.addAttribute("adminPW", adminPwStr);
		
		return "05Environment/main1";
	}
	
	/*
	외부파일읽기2 : XML 설정파일에서 프로퍼티 파일을 명시한 후
		직접 빈을 생성하여 주입받는 방법
	 */
	@RequestMapping("/environment/main2")
	public String main2(Model model) {
		
		//프로퍼티 파일의 위치를 명시한 XML 설정파일을 통해 스프링 컨테이너를 생성한다.
		AbstractApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:EnvAppCtx.xml");
		
		//프로퍼티 파일의 값을 저장한 빈(자바객체)을 주입받는다.
		UserConnection userCon =
				ctx.getBean("userConnection", UserConnection.class);
		
		//Model 객체에 저장한 후 뷰를 호출한다.
		model.addAttribute("mainUserId", userCon.getMainUserId());
		model.addAttribute("mainUserPw", userCon.getMainUserPw());
		model.addAttribute("subUserId", userCon.getSubUserId());
		model.addAttribute("subUserPw", userCon.getSubUserPw());
		
		return "05Environment/main2";
	}
	
	/*
	외부파일읽기3 : 어노테이션을 이용한 외부파일 참조. XML설정파일 대신
		EnvApplicationConfig 클래스를 이용하여 외부파일을 읽어온다.
	 */
	@RequestMapping("/environment/main3")
	public String main3(Model model) {
		
		//어노테이션 기반 스프링 컨테이너 생성
		AnnotationConfigApplicationContext ctx = new
				AnnotationConfigApplicationContext(
						EnvApplicationConfig.class);
		
		//설정파일에서 생성한 빈 주입받기
		BoardConnection bConn = 
				ctx.getBean("boardConfig", BoardConnection.class);
		/*
		어노테이션을 통해 XML설정 파일을 대체하는 경우 @Bean을 붙인
		메소드명이 빈의 참조변수가 된다.
		
			@Bean
			public BoardConnection boardConfig() {
				==> BoardConnection boardConfig = new BoardConnection()
					와 동일한 의미를 가진다.
		 */
		
		//모델 객체에 저장 후 뷰 호출
		model.addAttribute("id", bConn.getUser());
		model.addAttribute("pass", bConn.getPass());
		model.addAttribute("driver", bConn.getDriver());
		model.addAttribute("url", bConn.getUrl());
		
		return "05Environment/main3";
	}

}
