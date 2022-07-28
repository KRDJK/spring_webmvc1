package com.spring.webmvc.springmvc.chap02.api;

import com.spring.webmvc.springmvc.chap02.domain.Score;
import com.spring.webmvc.springmvc.chap02.repository.ScoreMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/api/v1/scores")
public class ScoreApiController {

    private final ScoreMapper mapper;


    @GetMapping("")
    public List<Score> list() {
        log.info("/api/v1/scores GET!!");

        List<Score> scoreList = mapper.findAll();

        return scoreList;
    }


    @GetMapping("/{stuNum}")
    public Score detail(@PathVariable int stuNum) {
        log.info("/api/v1/scores GET!! - stuNum = {}", stuNum);
        Score score = mapper.findOne(stuNum);
        return score;
    }


    @PostMapping("")
    public String save(@RequestBody Score score) {
        score.calcTotalAndAvg();
        score.calcGrade();
        log.info("/api/v1/scores - POST! - {}", score);

        boolean flag = mapper.save(score);

        return flag ? "save-success" : "save-fail";
    }


    @DeleteMapping("/{stuNum}")
    public String delete(@PathVariable int stuNum) {
        log.info("/api/v1/scores - DELETE! - {}", stuNum);

        boolean flag = mapper.remove(stuNum);

        return flag ? "del-success" : "del-fail";
    }
}
