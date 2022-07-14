package com.spring.webmvc.springmvc.prac0714.repository;

import com.spring.webmvc.springmvc.prac0714.domain.Content;

import java.util.List;

public interface BoardRepository {

    // 게시글 작성
    public boolean write(Content content);

    // 게시글 삭제
    public boolean delete(int boardNum);


    // 게시글 수정
    public boolean modify(Content content);


    // 조회수 상승
    public void upViewCount(int boardNum);


    // 게시글 목록 조회
    public List<Content> findAllContent();


    // 게시글 상세 조회
    public Content findOneContent(int boardNum);
}
