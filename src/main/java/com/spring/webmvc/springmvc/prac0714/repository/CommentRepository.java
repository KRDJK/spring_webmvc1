package com.spring.webmvc.springmvc.prac0714.repository;

import com.spring.webmvc.springmvc.prac0714.domain.Comment;

import java.util.List;

public interface CommentRepository {

    // 댓글 전체목록 조회
    public List<Comment> findAllComment(int boardNum);

    // 댓글 작성 기능
    public boolean addCmt(Comment comment);

    // 댓글 삭제 기능
    public boolean deleteCmt(int boardNum, String writer);

    // 댓글 수정 기능
    public boolean modifyCmt(Comment comment);

    // 댓글 추천 기능
    public void upLikeCnt(int boardNum, String writer);
}
