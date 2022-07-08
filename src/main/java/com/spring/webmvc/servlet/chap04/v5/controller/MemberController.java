package com.spring.webmvc.servlet.chap04.v5.controller;

import com.spring.webmvc.servlet.member.model.Member;
import com.spring.webmvc.servlet.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/mvc/v5/*") // 이런 요청이 들어오면 처리해라
//@Component
@Controller // 이 객체마저도 스프링 컨테이너에 등록.
public class MemberController {

    private final MemberRepository repository;


    @Autowired
    public MemberController(MemberRepository repository) {
        this.repository = repository;
    }


    // 회원 가입 양식 화면 요청
    @RequestMapping("/join")
    public String join() {
        return "reg_form";
    }


    // 회원 가입 실제 저장 요청
    @RequestMapping("/save")
    public String save(Member member) {
        repository.save(member);
        return "redirect:/";
    }


    // 회원 목록 조회 요청
    @RequestMapping("/show")
    public String show(Model model) {
        List<Member> members = repository.findAll();
        model.addAttribute("mList", members);
        return "members";
    }
}
