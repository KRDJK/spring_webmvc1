package com.spring.webmvc.springmvc.prac0714.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.ResultSet;
import java.sql.SQLException;

@Setter @Getter @ToString
@NoArgsConstructor
public class Content {
    // 서버에서 작성하는 데이터
    private int boardNum; // 글 번호



    // 클라이언트가 전달할 데이터
    private String writer; // 작성자

    private String title; // 글 제목

    private String content; // 글 내용

    private int viewCount; // 조회수

    private String regDate; // 등록일자 (+수정일자?)



    public Content(String writer, String title, String content) {
        this.writer = writer;
        this.title = title;
        this.content = content;
    }


    public Content(ResultSet rs) throws SQLException {
        this.boardNum = rs.getInt("board_no");
        this.writer = rs.getString("writer");
        this.title = rs.getString("title");
        this.content = rs.getString("content");
        this.viewCount = rs.getInt("view_cnt");
        this.regDate = rs.getString("reg_date");
    }
}
