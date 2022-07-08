package com.spring.webmvc.springmvc.chap01;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hw")
public class LoginController {

    private static class ModelUrl {
        public static final String FORM ="/s-login-form"; // 슬래시를 기준으로 분기를 나눠야 함.
        public static final String CHECK ="/s-login-check";
    }

    /*
        1번 요청 : 로그인 폼 화면 열어주기
        - 요청 URL : /hw/s-login-form
        - 포워딩 jsp 파일 경로 : /WEB-INF/views/chap01/s-form.jsp
        - html form : 아이디랑 비번을 입력받으세요.


        2번 요청 : 로그인 검증하기
        - 로그인 검증: 아이디를 grape111이라고 쓰고 비번을 ggg9999라고 쓰면 성공이라고 고정해놓고 시작

        - 요청 URL : /hw/s-login-check
        - 포워딩 jsp 파일 경로 : /WEB-INF/views/chap01/s-result.jsp
        - jsp에게 전달할 데이터: 로그인 성공여부, 아이디 없는 경우, 비번 틀린 경우
    */

    @RequestMapping(ModelUrl.FORM)
    public String form() {
        return "chap01/s-form";
    }


    @RequestMapping(ModelUrl.CHECK)
    public String check(String id, String password, Model model) {

        // 검증 과정
        if (id.equals("grape111")) {
            if (password.equals("ggg9999")) {
                model.addAttribute("flag", "clear");
            } else {
                model.addAttribute("flag", "wrong");
            }
        } else {
            model.addAttribute("flag", "notExist");
        }

        return "chap01/s-result";
    }

}
