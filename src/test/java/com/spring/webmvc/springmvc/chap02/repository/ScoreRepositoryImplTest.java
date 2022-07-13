package com.spring.webmvc.springmvc.chap02.repository;

import com.spring.webmvc.springmvc.chap02.domain.Score;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest // 의존성 주입을 테스트 라인에서 사용 가능. 테스트할거면 써줘야 함.
class ScoreRepositoryImplTest {

    @Autowired
    ScoreRepository repository;

    @Test
    @DisplayName("회원 정보가 데이터베이스 테이블에 삽입되어야 한다.")
    void saveTest() {
        Score s = new Score("가나다", 100, 88, 92);

        boolean result = repository.save(s);

        assertTrue(result);
    }


    @Test
    @DisplayName("특정 학번에 해당하는 회원 정보가 데이터베이스 테이블에서 삭제되어야 한다.")
    @Transactional
    @Rollback
    void removeTest() {
        // given : 내가 이걸 주면
        int stuNum = 2;


        // when : 이 타이밍에 given을 주면
        boolean result = repository.remove(stuNum);


        // then : 결과가 이러할 것이다.
        assertTrue(result);
    }


    @Test
    @DisplayName("모든 점수 정보를 조회해야 한다.")
    void findAllTest() {
        List<Score> scoreList = repository.findAll();

        scoreList.forEach(s -> System.out.println(s));
    }


    @Test
    @DisplayName(("특정 학번을 주면 그 학번을 가진 점수 정보를 조회해야 한다."))
    void findOneTest() {
        int stuNum = 1;

        Score score = repository.findOne(stuNum);

        System.out.println(score);

        assertEquals("빡빡이", score.getName());
    }
}