package com.spring.webmvc.springmvc.chap03;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Log4j2
public class RequestController {

    // 1.
    @RequestMapping(value = "/req/hello", method = RequestMethod.POST) // 이러면 post 요청에서만 작동하게 됨.
    // 레거시 프로젝트에서는 위에 같은 코드가 많다. 알아둬야 함.
//    @PostMapping("/req/hello")
    @ResponseBody // 리턴 값 그대로 다이렉트로 전달하는거!!
    public String hello() {
        log.info("/req/hello 요청!!");
        return "hello!!!"; // @ResponseBody 에 의해 "hello!!!" 가 바로 화면에 띄워짐.
                    // but, 페이지 소스 보기를 하면 어떤 html 구조없이 텍스트만 달랑 있다.
    }



    // 2.
//    @RequestMapping(value = "/req/bye", method = RequestMethod.GET) // 이러면 get 요청에서만 작동하게 됨.
    @GetMapping("/req/bye")
    @ResponseBody
    public String bye() {
        log.info("/req/bye GET 요청!!");
        return "bye!!!";
    }



    // 3.
    // 경로(URL)에서 파라미터 데이터를 가져오고자 한다면??   => 유행하는 방식이라고 함 쿼리파라미터로 받는거보다
        // /member/kim 하면 kim에 대한 정보가 나왔으면 한다. 어케??


    // a태그에서의 링크나 주소창으로 접근하면 무조건 get 방식으로 데이터가 들어온다!!! post 방식 사용 불가!!
      // 주소창 접근시엔 주소창에 직접 필요한 값들을 입력해야지만 접근 가능하기 때문에 그런듯?? 그걸 다시 암호화 해주는 방식은 없는거 같다.


    @GetMapping("/member/{un}") // {} 안에는 식별자 이름을 적는데, 이건 내 마음대로 정하면 된다.
                                // 여러개 있으면 계속 뒤에 /{}을 하면 된다.
    @ResponseBody
    public String member(@PathVariable("un") String userName) { // {값}이랑 매개변수명이 같으면 ("") 부분 생략 가능
                        // [ @PathVariable ] 이게 생략되면 쿼리 파라미터 값으로 받는다고 인식하기 때문에 이 경우에서는 생략하면 안된다.

        return "I am " + userName;
    }
}
