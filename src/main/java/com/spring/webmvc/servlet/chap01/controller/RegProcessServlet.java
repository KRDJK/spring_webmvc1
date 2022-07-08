package com.spring.webmvc.servlet.chap01.controller;

import com.spring.webmvc.servlet.member.model.Member;
import com.spring.webmvc.servlet.member.repository.MemberRepository;
import com.spring.webmvc.servlet.member.repository.MemoryMemberRepo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


// 실질적으로 회원가입 데이터를 받아서 처리하는(회원가입을 진짜로 시켜주는) 서블릿
@WebServlet("/reg-process")
public class RegProcessServlet extends HttpServlet {

    private MemberRepository repository = MemoryMemberRepo.getInstance();


    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 1. 회원가입 폼에서 날아온 회원 데이터 가져오기
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        String userName = request.getParameter("userName");


        // 2. 위에서 받아온 회원 정보들을 적절한 저장소(저장소가 변동가능성이 있음을 유념하라)에 저장
                                    // 인터페이스를 상속해서 역할에 저장하라. 구현체는 다른 곳에서 넣어주고 !
        Member member = new Member(account, password, userName);
        repository.save(member);


        // 3. 홈 화면으로 이동 (리다이렉션 : redirection) : 로그인 성공했으니 다시 홈화면으로 !!
        response.sendRedirect("/");
    }


}
