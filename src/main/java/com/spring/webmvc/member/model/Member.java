package com.spring.webmvc.member.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter
@ToString
public class Member {

    // 이게 static이 아니라면 ++ 해봐야 다 0에서 1이된다. 왜?? 객체 생성때마다 초기값이 0인 시퀀스가 생성되니까!!
    // static이면 공유가 되니까
    private static int sequence; // 회원 일련번호

    private int userNum;
    private String account;
    private String password;
    private String userName;

    
    public Member() {
        this.userNum = ++sequence;
    }

    public Member(String account, String password, String userName) {
        this(); // 기본 생성자 호출
        this.account = account;
        this.password = password;
        this.userName = userName;
    }
}
