package com.spring.webmvc.springmvc.prac0714.repository;


import com.spring.webmvc.springmvc.prac0714.domain.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CommentRepositoryImpl implements CommentRepository {

    private final JdbcTemplate template;


    @Override
    public List<Comment> findAllComment(int boardNum) {
        String sql = "SELECT * FROM comments WHERE board_no=? ORDER BY reg_date";

        List<Comment> commentList = template.query(sql, (rs, rowNum) -> new Comment(rs), boardNum);

        return commentList;
    }


    @Override
    public boolean addCmt(Comment comment) {
        String sql = "INSERT INTO comments (board_no, writer, content) VALUES (?, ?, ?)";

        return template.update(sql, comment.getBoardNum(), comment.getWriter(), comment.getContent()) == 1;
    }


    @Override
    public boolean deleteCmt(int boardNum, String writer) {
        String sql = "DELETE FROM comments WHERE board_no=? AND writer=?";

        return template.update(sql, boardNum, writer) == 1;
    }


    @Override
    public boolean modifyCmt(Comment comment) {
        String sql = "UPDATE comments SET content=? WHERE board_no=? AND writer=?";

        return template.update(sql, comment.getContent(), comment.getBoardNum(), comment.getWriter()) == 1;
    }


    @Override
    public void upLikeCnt(int boardNum, String writer) {
        String sql = "UPDATE comments SET like_cnt = like_cnt+1 WHERE board_no=? AND writer=?";

        template.update(sql, boardNum, writer);
    }
}
