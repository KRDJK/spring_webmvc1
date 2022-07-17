package com.spring.webmvc.springmvc.prac0714.service;

import com.spring.webmvc.springmvc.prac0714.domain.Comment;
import com.spring.webmvc.springmvc.prac0714.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository repository;


    // 댓글 목록 요청 중간 처리 메서드
    public List<Comment> listCmtService(int boardNum) {
        List<Comment> commentList = repository.findAllComment(boardNum);

        return commentList;
    }

    // 댓글 등록 요청 중간 처리 메서드
    public boolean addCmtService(Comment comment) {
        return repository.addCmt(comment);
    }

    // 댓글 삭제 요청 중간 처리 메서드
    public boolean delCmtService(int boardNum, String writer) {
        return repository.deleteCmt(boardNum, writer);
    }

    // 댓글 수정 요청 중간 처리 메서드
    public boolean modCmtService(Comment comment) {
        return repository.modifyCmt(comment);
    }

    // 댓글 추천 반영 요청 중간 처리 메서드
    public void upLikeCmtService(int boardNum, String writer) {
        repository.upLikeCnt(boardNum, writer);
    }
}
