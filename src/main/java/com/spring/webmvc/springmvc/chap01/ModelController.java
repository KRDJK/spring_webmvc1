package com.spring.webmvc.springmvc.chap01;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping ("/model") // or /model/* 이렇게 쓰면 하단부에서 /model을 생략할 수 있다!!
public class ModelController {

    private static class ModelUrl {
        public static final String HOBBIES = "/hobbies";
        public static final String HOBBIES2 = "/hobbies2";
        public static final String FORM = "/form";
        public static final String CHECK = "/age-check";
    }


    //========== JSP (꼭 jsp 파일일 필요는 없다.) 파일로 포워딩할 때 데이터 전달하기 ==========//
    // 방법 1. Model 객체 사용하기 : 컨트롤러와 jsp 파일 간 데이터 송신을 가능하게 해주는 운반 객체.
    @RequestMapping(ModelUrl.HOBBIES) // 위에 클래스에서 공통 경로 /model을 부여해줬기 때문에 [ /model/hobbies ] 가 된다.
    public String hobbies(Model model) {

        List<String> hList = new ArrayList<>();
        hList.add("산책");
        hList.add("뛰어놀기");
        hList.add("밥먹기");
        hList.add("낮잠자기");

        model.addAttribute("name", "멍멍이");
        model.addAttribute("hobbies", hList);


        // /WEB-INF/views/chap01/hobbies.jsp 로 보내게 될 것이다. 접두사 접미사 세팅 했었으니까!!
        return "chap01/hobbies";
    }


    // 방법 2. ModelAndView 사용하기  : 잘 안쓸거 같지만 이 방식도 알아둬야 한다. 좀 쓴다고 함.
    @RequestMapping(ModelUrl.HOBBIES2)
    public ModelAndView hobbies2() {
        List<String> hList = new ArrayList<>();
        hList.add("영화보기");
        hList.add("맛집가기");

        ModelAndView mv = new ModelAndView("chap01/hobbies");
        mv.addObject("name", "짹짹이");
        mv.addObject("hobbies", hList);

        return mv;
    }


    // age-form 띄우기
    @RequestMapping(ModelUrl.FORM)
    public String form() {
        return "chap01/age-form";
    }


    // 방법 3. 매개변수 쪽에 @ModelAttribute 사용하기
    
    // age 데이터 처리
    @RequestMapping(ModelUrl.CHECK)
                                // 이름 설정 가능 지금은 age로 보내야 하지만 a, b, c 등 jsp 파일과 맞춰주기만 하면 됨.
    public String check(@ModelAttribute("age") int age, Model model) { // 변수명이 받아온 쿼리 파라미터의 키값이랑 같으니까 이게 가능.

        // 나이로 출생년도 구해주기 (한국나이)
        int birthYear = LocalDate.now().getYear() - age + 1;

        model.addAttribute("bYear", birthYear); // 쿼리파라미터로 받아오는게 아니라 내부 계산이니까 따로 전달해줘야지!
//        model.addAttribute("age", age); // @ModelAttribute 를 활용해서 생략 가능해짐. key 값은 매개변수명으로 그대로 전달.

        return "chap01/age-result";
    }

}
