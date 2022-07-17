package com.spring.webmvc.springmvc.prac0714.service;

import com.spring.webmvc.springmvc.prac0714.domain.Content;
import com.spring.webmvc.springmvc.prac0714.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService { // DB와 Controller 간의 소통을 하게 해주는 중간 다리 클래스 (단일 책임 원칙을 지키기 위해)

    private final BoardRepository repository;

    private final CommentService service;


    // 게시판 목록 요청 중간 처리 메서드
    public List<Content> listService() {
        List<Content> contentList = repository.findAllContent();

        // 중간 처리 필요하면 여기 작성
        
        return contentList;
    }


    // 게시판 글 상세 조회 요청 중간 처리 메서드
    public Content detailService(int boardNum){

        // 중간 처리 필요하면 여기 작성
        // 중간 처리 1. 조회수 증가
        repository.upViewCount(boardNum);


        Content content = repository.findOneContent(boardNum);
        // 해당 게시글 댓글까지
        content.setCommentList(service.listCmtService(boardNum));

        return content;
    }


    // 게시판 글 작성 요청 중간 처리 메서드
    public boolean writeService(Content content) {
        return repository.write(content);
    }


    // 게시판 글 삭제 요청 중간 처리 메서드
    public boolean deleteService(int boardNum) {
        return repository.delete(boardNum);
    }


    // 게시판 글 수정 요청 중간 처리 메서드
    public boolean modifyService(Content content) {
        return repository.modify(content);
    }


}
