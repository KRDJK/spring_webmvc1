package com.spring.webmvc.springmvc.chap02.controller;

import com.spring.webmvc.springmvc.chap02.domain.Score;
import com.spring.webmvc.springmvc.chap02.repository.ScoreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Log4j2
@RequiredArgsConstructor // 아래 final 생성자 생성을 위한 문구.
public class ScoreController {

    private final ScoreRepository repository;

//    @Autowired
//    public ScoreController(ScoreRepository repository) { // 빈에 등록된 repository가 ScoreRepositoryImpl 뿐이라서 자동으로 넣어준다.
//        this.repository = repository;
//    }



    // 점수 등록 및 조회 화면 열기 요청
    @RequestMapping("/score/list")
    public String list(Model model) {
        log.info("/score/list GET 요청!!");

        // jsp에게 점수 정보 리스트를 전달해야 함.
        model.addAttribute("scores", repository.findAll(""));

        return "chap02/score-list";
    }



    // 점수 신규 등록 요청
    @RequestMapping("/score/register")
        // 커맨드 객체를 매개변수로 받는다. 이건 jsp 파일에서 input 태그의 name이 score 객체의 필드명과 같아야 함.
    public String register(Score score) { // 스프링이 스코어 객체를 만들어서 넣어줬다.
                                            // 근데 스프링은 기본 생성자를 사용해서 객체를 만들고 입력받은 만큼만 setter로 채운다.
                                            // 그래서 총점, 평균, 총점이 구해지지 않았다. 기본생성자에 메서드를 넣어봤자 setter가 나중에 호출되기 때문에 의미가 없다.

        score.calcTotalAndAvg();
        score.calcGrade();

        log.info("/score/register POST! - " + score);

        return repository.save(score) ? "redirect:/score/list" : "redirect:/";
    }



    // 점수 삭제 요청
    @RequestMapping("/score/delete")
    public String delete(int stuNum) {
        log.info("/score/delete GET 요청!!");
        return repository.remove(stuNum) ? "redirect:/score/list" : "redirect:/";
    }



    // 상세 정보 조회 요청
    @RequestMapping("/score/detail")
    public String detail(int stuNum, Model model) {
        log.info("/score/detail GET 요청!!");

        Score score = repository.findOne(stuNum);

        model.addAttribute("s", score);

        return "chap02/score-detail";
    }


    // 이름 정렬 요청
    @RequestMapping("/score/list?sort=name")
    public String sortName(String name, Model model) {

        log.info("정렬 요청!! /score/list/sort= " + name);

        List<Score> scores = repository.findAll(name);

        model.addAttribute(scores);

        return "redirect:/score/list";
    }


    // 이름 정렬 요청
    @RequestMapping("/score/list?sort=grade")
    public String sortGrade(String grade, Model model) {

        log.info("정렬 요청!! /score/list/sort= " + grade);

        List<Score> scores = repository.findAll(grade);

        model.addAttribute(scores);

        return "chap02/score-list";
    }
}
