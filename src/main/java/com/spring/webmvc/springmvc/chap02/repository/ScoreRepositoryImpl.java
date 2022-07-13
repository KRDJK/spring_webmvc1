package com.spring.webmvc.springmvc.chap02.repository;

import com.spring.webmvc.springmvc.chap02.domain.Score;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

// 스프링 jdbc를 써볼 것이다.
@Repository // 이 클래스가 저장소라고 명시하면서 스프링 컨테이너에 빈 등록하는 것. (@component 보다 저장소인걸 더 명시!)
@RequiredArgsConstructor // final 필드를 초기화 해주는 생성자 선언 !! 아래의 @Autowired 부분을 대신 해준다.
public class ScoreRepositoryImpl implements ScoreRepository {

    // 스프링 JDBC - JDBC Template : JDBC를 단순화
    private final JdbcTemplate template; // 생성자 없이 final을 쓰면 에러남.
    // final을 붙이는 이유!! 프로그램 실행 도중 객체가 변경되면 안되기 때문에.



//    @Autowired // 밑에 매개변수 부분을 자동으로 넣어달라는 요구. 생성자가 하나면 생략 가능함.
//    public ScoreRepositoryImpl(JdbcTemplate template) {
//        this.template = template;
//    }



    @Override
    public boolean save(Score score) {
        String sql = "INSERT INTO tbl_score VALUES (seq_tbl_score.nextval, ?, ?, ?, ?, ?, ?, ?)";

        // INSERT, UPDATE, DELETE는 템플릿의 update() 메서드 활용. update() 메서드는 삽입된 행의 개수를 리턴함.
        return template.update(sql, score.getName(),
                score.getKor(), score.getEng(), score.getMath(),
                score.getTotal(), score.getAverage(), score.getGrade().toString()) == 1;
    }


    @Override
    public List<Score> findAll(String sort) {
        String sql = "SELECT * FROM tbl_score";

        if (sort.equals("name"))  {
            sql += " ORDER BY stu_name";
        } else if (sort.equals("grade")) {
            sql += " ORDER BY grade";
        }

        // SELECT문의 경우는 query() 메서드를 사용한다.

         /* 다른 방법 1. ( 익명 클래스 활용 : 하단 메서드 부분 조금 오버라이딩 하자고 클래스 파일 새로 만들거야??? )
        return template.query(sql, new RowMapper<Score>() {
            @Override
            public Score mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Score(rs); // 알아서 반복문 돌려서 한 행씩 가져다 줄거다.
            }
        });
         */


        // 다른 방법 2. ( 방법 1의 람다식 버전 : 익명 클래스를 보다 더 간소하게 코드 작성 가능! => 메서드 하나만 있는 클래스라서 람다식 적용 가능 )
        // https://velog.io/@heoseungyeon/%EB%9E%8C%EB%8B%A4-%ED%91%9C%ED%98%84%EC%8B%9D : 람다 표현식 정리된 블로그
//        return template.query(sql, (rs, rowNum) -> new Score(rs));

        List<Score> scoreList = template.query(sql, new ScoreRowMapper());

        return scoreList;
    }


    @Override
    public Score findOne(int stuNum) {

        String sql = "SELECT * FROM tbl_score WHERE stu_num=?";

        // 단일 건수 조회시 queryForObject(sql, RowMapper, ? 개수만큼 전달...) 메서드 사용.
        Score score = template.queryForObject(sql, new ScoreRowMapper(), stuNum);

        return score;
    }


    @Override
    public boolean remove(int stuNum) {
        String sql = "DELETE FROM tbl_score WHERE stu_num=?";
        return template.update(sql, stuNum) == 1;
    }

//    @Override
//    public List<Score> sortName() {
//        String sql = "SELECT"
//        return null;
//    }
//
//    @Override
//    public List<Score> sortGrade() {
//        return null;
//    }
}
