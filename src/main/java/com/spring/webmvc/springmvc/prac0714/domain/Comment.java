package com.spring.webmvc.springmvc.prac0714.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

@Getter @Setter
@NoArgsConstructor
@ToString
public class Comment {

    private int boardNum; // 댓글이 등록된 게시글 번호

    private String writer; // 댓글 작성자

    private String content; // 댓글 내용

    private Date regDate; // 댓글 작성일자

    private int likeCount; // 댓글 추천수


    public Comment(String writer, String content) {
        this.writer = writer;
        this.content = content;
    }


    public Comment(ResultSet rs) throws SQLException {
        this.boardNum = rs.getInt("board_no");
        this.writer = rs.getString("writer");
        this.content = rs.getString("content");
        this.regDate = rs.getDate("reg_date");
        this.likeCount = rs.getInt("like_cnt");
    }

}
