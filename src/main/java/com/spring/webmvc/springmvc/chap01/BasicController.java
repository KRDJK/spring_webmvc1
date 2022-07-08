package com.spring.webmvc.springmvc.chap01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller // 스프링 컨테이너에 빈 등록
// 스프링의 [ HandlerMapping ]이 찾아서 [ DispatcherServlet : 스프링 프론트 컨트롤러 ]에 연결함.
public class BasicController {


    // 클라이언트 요청 받기
    @RequestMapping("/spring/about") // 요청 URL을 적음.
    public String about() {
        System.out.println("about 요청이 들어옴!!");
        
        //  /WEB-INF/views/about.jsp 경로로 포워딩
        return "about"; // jsp 파일로 포워딩 or 리다이렉트
    }


    @RequestMapping("/spring/hello") // 요청 URL을 적음.
    public String hello() {
        System.out.println("hello 요청이 들어옴!!");

        //  /mvc/join 경로로 재요청 (redirect)
        return "redirect:/mvc/join"; // jsp 파일로 포워딩 or 리다이렉트
    }


    // ========== 요청 파라미터 받기 (Query Parameter) ========== //
    // 방법 1. HttpServletRequest 사용하기.
    // 예시 )) /spring/person?name=kim&age=30
    @RequestMapping("/spring/person")
    public String person(HttpServletRequest request) {
        String name = request.getParameter("name");
        String age = request.getParameter("age"); // 정수로 쓰고자 하면 변환이 필요함. 귀찮겠네

        System.out.println("name = " + name);
        System.out.println("age = " + age);

        return "";
    }


    // 방법 2. @RequestParam 사용하기
    // 예시 )) /spring/major?stu=kim&major=business&grade=3
    @RequestMapping("/spring/major")
    public String major(
            @RequestParam("stu") String aaa // 파라미터 명은 제대로 써줘야 하지만, 변수명은 내 마음대로 설정 가능.
            , @RequestParam("major") String mj // 지역변수랑 이름이 겹치는데 지역변수명을 바꾸는 리스크가 더 크다면 따로 써줘야 한다.
            , @RequestParam("grade") int ccc
    ) {

        String major = "기공";

        System.out.println("stu = " + aaa);
        System.out.println("major = " + mj);
        System.out.println("grade = " + ccc);

        return "";
    }

    // 방법 2의 좀 더 개선된 패치버전
    // 요청 파라미터 키값과 메서드 매개변수 이름이 같으면
    // @RequestParam 생략 가능
    @RequestMapping("/spring/major2")
    public String major2(String stu, String major, int grade) {
        System.out.println("학생명2 = " + stu);
        System.out.println("전공2 = " + major);
        System.out.println("학년2 = " + grade);

        return "";
    }
    
    
    // 방법 3. 커맨드 객체 이용하기 // 파라미터 키값이 엄청 많다면..???
    // 예시 )) /spring/order?oNum=22&goods=구두&amount=3&price=10000& ~~~~
    // 주의사항 1번 : 쿼리 파라미터 키값과 커맨드 객체(아래의 매개변수 order) 필드명이 같아야 인식함. (대소문자까지 완벽하게!!)
    // 주의사항 2번 : 반드시 setter / getter 가 있어야 함.
    @RequestMapping("/spring/order")
    public String order(Order order) {
        System.out.println(order);
        return "";
    }
    
}
