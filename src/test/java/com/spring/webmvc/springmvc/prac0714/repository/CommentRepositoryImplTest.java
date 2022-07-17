package com.spring.webmvc.springmvc.prac0714.repository;

import com.spring.webmvc.springmvc.prac0714.domain.Comment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CommentRepositoryImplTest {

    @Autowired
    CommentRepository repository;


    @Test
    @DisplayName("게시글 번호와 함께 새로운 댓글 객체를 추가하면 DB에 반영되어야 한다.")
    void addCmtTest() {
        Comment comment = new Comment();
        comment.setBoardNum(3);
        comment.setWriter("김동진");
        comment.setContent("댓글 등록 확인");

        boolean result = repository.addCmt(comment);

        assertTrue(result);
    }


    @Test
    @DisplayName("삭제할 댓글이 달린 게시글 번호와 삭제 대상 댓글 작성자를 알려주면 삭제되어야 한다.")
    void deleteCmtTest() {
        boolean result = repository.deleteCmt(3, "김동진");

        assertTrue(result);
    }


    @Test
    @DisplayName("게시글 번호가 주어지면 해당 게시물에 달린 댓글 목록을 불러와야 한다.")
    void findAllCmtTest() {
        List<Comment> commentList = repository.findAllComment(2);

        assertTrue(commentList.size() == 0);
    }

    @Test
    @DisplayName("수정 내용이 주어지면 댓글이 수정되어야 한다.")
    void modifyCmtTest() {
        Comment comment = new Comment();

        comment.setBoardNum(3);
        comment.setWriter("김동진");
        comment.setContent("댓글 수정 확인");

        boolean result = repository.modifyCmt(comment);

        assertTrue(result);
    }
    
    // 댓글 추천 테스트
}