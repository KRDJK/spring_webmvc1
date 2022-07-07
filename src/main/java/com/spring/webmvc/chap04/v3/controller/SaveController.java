package com.spring.webmvc.chap04.v3.controller;

import com.spring.webmvc.chap04.View;
import com.spring.webmvc.member.model.Member;
import com.spring.webmvc.member.repository.MemberRepository;
import com.spring.webmvc.member.repository.MemoryMemberRepo;

import java.util.Map;

// 회원가입 정보를 저장해줄 (진짜로 회원으로 등록해줄) 컨트롤러
public class SaveController implements ControllerV3 {

    private final MemberRepository repository = MemoryMemberRepo.getInstance();


    @Override
    public View process(Map<String, String> paramMap) {
        //1. 회원가입 폼에서 날아온 회원 데이터 가져오기
        String account = paramMap.get("account");
        String password = paramMap.get("password");
        String userName = paramMap.get("userName");


        //2. 회원 정보를 적절한 저장소에 저장
        Member member = new Member(account, password, userName);
        repository.save(member);


        //3. 홈 화면으로 이동 (리다이렉션)
//        response.sendRedirect("/");

        return null; // 이 컨트롤러에서는 포워딩을 하지 않기 때문에 null 리턴!!
    }
}
