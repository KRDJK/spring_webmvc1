package com.spring.webmvc.servlet.chap04.v2.controller;

import com.spring.webmvc.servlet.chap04.View;
import com.spring.webmvc.servlet.member.model.Member;
import com.spring.webmvc.servlet.member.repository.MemberRepository;
import com.spring.webmvc.servlet.member.repository.MemoryMemberRepo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ShowController implements ControllerV2 {

    // 목록을 보여주려면 필요한 데이터를 필드로 갖고 있어야지.
    private final MemberRepository repository = MemoryMemberRepo.getInstance();

    @Override
    public View process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Member> members = repository.findAll();

        // Model : Controller 와 view 사이의 데이터(여기선 리스트:members 데이터가 필요함)를 운반하는 수단 객체
        // - 여기서 모델의 역할은 Request 객체가 담당


        // 이름은 내 맘대로 정함 (key값이 됨.)
        request.setAttribute("mList", members); // request 객체에 데이터를 저장


        /*String viewName = "/WEB-INF/views/members.jsp";
        RequestDispatcher dp = request.getRequestDispatcher(viewName);
        dp.forward(request, response);*/

        return new View("/WEB-INF/views/members.jsp");
    }
}
