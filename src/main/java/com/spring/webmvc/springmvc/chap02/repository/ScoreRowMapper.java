package com.spring.webmvc.springmvc.chap02.repository;

import com.spring.webmvc.springmvc.chap02.domain.Score;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ScoreRowMapper implements RowMapper<Score> {

    @Override
    public Score mapRow(ResultSet rs, int rowNum) throws SQLException {
//        s.setStuNum(rs.getInt("stu_num"));
//        s.setName(rs.getString("stu_name")); 이걸 테이블 행 수가 8개니까 8개를 다..? 비효율적

        return new Score(rs);
    }
}
