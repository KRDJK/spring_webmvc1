package com.spring.webmvc.chap04.v3.controller;

import com.spring.webmvc.chap04.View;
import com.spring.webmvc.member.model.Member;
import com.spring.webmvc.member.repository.MemberRepository;
import com.spring.webmvc.member.repository.MemoryMemberRepo;

import java.util.List;
import java.util.Map;

public class ShowController implements ControllerV3 {

    // 목록을 보여주려면 필요한 데이터를 필드로 갖고 있어야지.
    private final MemberRepository repository = MemoryMemberRepo.getInstance();

    @Override
    public View process(Map<String, String> paramMap) {

        List<Member> members = repository.findAll();

        // Model : Controller 와 view 사이의 데이터(여기선 리스트:members 데이터가 필요함)를 운반하는 수단 객체
        // 이름은 내 맘대로 정함 (key값이 됨.)
//        request.setAttribute("mList", members); // request 객체에 데이터를 저장
//                                                  mList라는 이름을 가진 멤버 리스트를 전달


        return new View("/WEB-INF/views/members.jsp");
    }
}
