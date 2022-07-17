package com.spring.webmvc.springmvc.prac0714.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Setter @Getter @ToString
@NoArgsConstructor
public class Content {
    // 서버에서 작성하는 데이터
    private int boardNum; // 글 번호

    // 게시글 각각 댓글 리스트들이 있다.
    private List<Comment> commentList; // 게시글이 생성된 직후에는 빈 리스트, 화면에도 안보이다가 하나 입력될 때부터 리스트 출력되어야 함.


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
