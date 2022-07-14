package com.spring.webmvc.springmvc.prac0714.repository;

import com.spring.webmvc.springmvc.prac0714.domain.Content;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardRepositoryImplTest {

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    BoardRepository repository;


    @Test
    @DisplayName("글 작성을 하면 DB 컬럼들이 다 채워져서 등록되어야 한다.")
    void writeTest() {
        Content content = new Content("ㄱㄷㅈ3", "ㅎㅇ3", "ㅎㅇ3");

        boolean result = repository.write(content);

        assertTrue(result);
    }


    @Test
    @Transactional
    @Rollback
    @DisplayName("글 번호를 주고 삭제를 시도하면 해당 글 번호를 가진 게시글이 삭제되어야 한다.")
    void deleteTest() {
        boolean result = repository.delete(2);

        assertTrue(result);
    }


    @Test
    @DisplayName("등록된 게시글들이 전부 조회되어야 한다.")
    void findAllTest() {
        List<Content> contentList = repository.findAllContent();

        for (Content content : contentList) {
            System.out.println(content);
        }
    }


    @Test
    @DisplayName("글 번호를 주면 해당 글번호를 가진 게시글을 상세조회해야 한다.")
    void findOneTest() {
        Content content = repository.findOneContent(2);

        log.info(content.toString());

        assertEquals("ㄱㄷㅈ", content.getWriter());
    }

}