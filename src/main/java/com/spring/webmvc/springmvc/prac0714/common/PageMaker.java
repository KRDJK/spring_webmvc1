package com.spring.webmvc.springmvc.prac0714.common;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// 페이지 렌더링 정보 생성
@Setter @Getter @ToString
@EqualsAndHashCode
public class PageMaker {

    private static final int PAGE_COUNT = 10; // 하단부 페이지 이동 버튼을 출력할 때 10번 페이지 이동 버튼까지 출력하고자 함.


    private int beginPage, endPage; // 페이지 이동 버튼이 몇번부터 시작해서, 몇번까지 표시할지!!

    private boolean prev, next; // false면 해당 버튼을 보이지 않게 할 것이다.

    private Page page; // 현재 위치한 페이지 정보

    private int totalCount; // 총 게시물 수를 알아야 마지막 페이징 버튼들 출력시
                            // 총 게시물이 274라면 28번까지만 버튼이 나오도록 설정할 수 있다.


    public PageMaker(Page page, int totalCount) {
        this.page = page;
        this.totalCount = totalCount;
        makePageInfo();
    }


    private void makePageInfo() {

    }
}