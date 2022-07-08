package com.spring.webmvc.servlet.chap04.v4.controller;

import com.spring.webmvc.servlet.chap04.Model;
import com.spring.webmvc.servlet.member.model.Member;
import com.spring.webmvc.servlet.member.repository.MemberRepository;
import com.spring.webmvc.servlet.member.repository.MemoryMemberRepo;

import java.util.Map;

// 회원가입 정보를 저장해줄 (진짜로 회원으로 등록해줄) 컨트롤러
public class SaveController implements ControllerV4 {

    private final MemberRepository repository = MemoryMemberRepo.getInstance();


    @Override
    public String process(Map<String, String> paramMap, Model model) {
        //1. 회원가입 폼에서 날아온 회원 데이터 가져오기 : 리팩토링함


        //2. 회원 정보를 적절한 저장소에 저장
        repository.save(new Member(paramMap.get("account")
                                , paramMap.get("password")
                                , paramMap.get("userName")));


        //3. 홈 화면으로 이동 (리다이렉션)
//        response.sendRedirect("/");

//        return null; // 이 컨트롤러에서는 포워딩을 하지 않기 때문에 null 리턴!!

        return "redirect:/"; // 이렇게 해서 보내면 리다이렉트 해주겠다고 사전에 정해놓고 약속하는 것!
    }
}
