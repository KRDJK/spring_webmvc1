package com.spring.webmvc.chap04.chap03.controller;

import com.spring.webmvc.servlet.member.model.Member;
import com.spring.webmvc.servlet.member.repository.MemberRepository;
import com.spring.webmvc.servlet.member.repository.MemoryMemberRepo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/mvc/show")
public class ShowServlet extends HttpServlet {

    // 목록을 보여주려면 필요한 데이터를 필드로 갖고 있어야지.
    private final MemberRepository repository = MemoryMemberRepo.getInstance();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Member> members = repository.findAll();
//        System.out.println(members);

        // Model : Controller 와 view 사이의 데이터(여기선 리스트:members 데이터가 필요함)를 운반하는 수단 객체
        // - 여기서 모델의 역할은 Request 객체가 담당
        
                                // 이름은 내 맘대로 정함 (key값이 됨.)
        req.setAttribute("mList", members); // request 객체에 데이터를 저장

        String viewName = "/WEB-INF/views/members.jsp";
        RequestDispatcher dp = req.getRequestDispatcher(viewName);
        dp.forward(req, resp);

    }

}
