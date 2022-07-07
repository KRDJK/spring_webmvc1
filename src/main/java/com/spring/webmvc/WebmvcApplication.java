package com.spring.webmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages = "com.spring.webmvc") // 서블릿을 모두 컨테이너에 등록한다.
														// 메인 메서드가 실행될 때 등록된 서블릿들의 객체가 모두 생성된다.
public class WebmvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebmvcApplication.class, args);
	}

}
