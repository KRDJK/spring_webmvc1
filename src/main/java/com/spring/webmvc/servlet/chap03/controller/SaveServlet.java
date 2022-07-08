package com.spring.webmvc.servlet.chap03.controller;

import com.spring.webmvc.servlet.member.model.Member;
import com.spring.webmvc.servlet.member.repository.MemberRepository;
import com.spring.webmvc.servlet.member.repository.MemoryMemberRepo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/mvc/save") // 상대경로라면 그냥 save
                    // 왜?? save 이전 경로가 /mvc/join인데 상대경로로 save라고 쓰면 마지막 / 부분만 save로 바뀌어서 /mvc/save가 된다.
public class SaveServlet extends HttpServlet {

    // final을 걸면 도중에 저장소가 변경되는 것을 막을 수 있다.
    private final MemberRepository repository = MemoryMemberRepo.getInstance();

    @Override
    // 오버라이딩 룰 :
    // [more public ]하게, 리턴타입, 매개변수 타입 및 순서만 같으면 오버라이딩은 문제 없다.
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1. 회원가입 폼에서 날아온 회원 데이터 가져오기
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        String userName = request.getParameter("userName");


        //2. 회원 정보를 적절한 저장소에 저장
        Member member = new Member(account, password, userName);
        repository.save(member);


        //3. 홈 화면으로 이동 (리다이렉션)
        response.sendRedirect("/"); // index.html로 강제 이동.
    }
}
