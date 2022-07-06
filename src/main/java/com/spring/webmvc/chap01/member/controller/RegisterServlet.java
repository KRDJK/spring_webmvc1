package com.spring.webmvc.chap01.member.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//  /register-form 요청을 처리할 서블릿 클래스
// 회원 가입 양식을 보여주고~~ 회원가입 버튼을 누르면 메모리에 저장시켜줘

@WebServlet("/register-form") // 괄호속 url 요청이 온다면 니가 처리해라고 이 클래스에 말하는 것.
public class RegisterServlet extends HttpServlet { // 서블릿 클래스는 httpServlet을 상속해야함.

    // 핵심 비즈니스 로직
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // 회원가입 폼을 그려야 한다. ( SSR )
        PrintWriter w = response.getWriter(); // 그릴려면 펜이 필요함.

        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");


        w.write("<!DOCTYPE html>\n");
        w.write("<html lang='ko'>\n");
        w.write("<head>\n");
//        w.write("<meta charset='EUC-KR'>\n");
        w.write("<title>register-form</title>\n");
        w.write("<style>label { display: block; }</style>\n");

        w.write("</head>\n");
        w.write("<body>\n");
                                                // 보안에 관련된 데이터가 있을 때는 'post'로 해라
        w.write("<form action='/reg-process' method='post'>\n"); // 내가 입력한 데이터를 가지고 회원가입 시켜줘라는 요청이 또 발생한다.
        w.write("<label># account: <input type='text' name='account'></label>\n"); // name 태그 속 account가 쿼리 스트링(or 쿼리파라미터)의 key가 된다.
        w.write("<label># password: <input type='password' name='password'></label>\n");
        w.write("<label># username: <input type='text' name='userName'></label>\n");
        w.write("<label><button type='submit'>register</button></label>\n");



        w.write("</form>\n");

        w.write("</body>\n");
        w.write("</html>\n");

        // 이걸 다 html로 그려서 응답 데이터로 보낸다.
    }
    
}
