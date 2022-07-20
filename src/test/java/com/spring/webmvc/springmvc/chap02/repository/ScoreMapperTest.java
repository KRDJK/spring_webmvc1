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

@SpringBootTest
class ScoreMapperTest {

    @Autowired
    ScoreMapper mapper; // 접근제한자 붙이는거 아님


    @Test
    @DisplayName("스코어 객체를 만들어서 매개변수로 넣어주면 그 스코어 객체가 db에도 등록되어야 한다.")
    void saveTest() {
        Score score = new Score();
        score.setName("테스트영");
        score.setKor(90);
        score.setEng(85);
        score.setMath(70);
        score.calcTotalAndAvg();
        score.calcGrade();

        boolean flag = mapper.save(score);

        assertTrue(flag);
    }


    @Test
    @DisplayName("학번을 주면 해당 학번을 가진 학생이 지워져야 한다.")
    @Transactional
    @Rollback
    void removeTest() {
        boolean flag = mapper.remove(7);

        assertTrue(flag);
    }


    @Test
    @DisplayName("등록된 학생의 점수 목록들을 다 보여줘야 한다.")
    void findAllTest() {
        mapper.findAll().forEach(System.out::println);
    }


    @Test
    @DisplayName("특정 학번을 주면 그 학번의 학생이 조회되어야 한다.")
    void findOneTest(){
        Score score = mapper.findOne(22);

        System.out.println("score = " + score);

        assertEquals("테스트영", score.getName());
    }


    @Test
    @DisplayName("전체 학생 수가 몇 명인지 조회한다.")
    void totalStudent() {
        int total = mapper.totalStudent();

        assertTrue(total == 7);
    }
}