package com.spring.webmvc.springmvc.chap02.controller;

import com.spring.webmvc.springmvc.chap02.domain.Score;
import com.spring.webmvc.springmvc.chap02.repository.ScoreMapper;
import com.spring.webmvc.springmvc.chap02.repository.ScoreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@Log4j2
@RequiredArgsConstructor // 아래 final 생성자 생성을 위한 문구.
public class ScoreController {
    // 얘의 역할은? 요청 경로를 받아서 파라미터가 필요하면 파라미터를 받고 비즈니스 로직을 실행 후 jsp에 던지거나 리다이렉트를 한다.
    // 근데 왜 list 메서드에서 이름 마킹 처리 같은 중간 단계 일을 하고 있니?? -> 개선이 필요한 사항이다. -> 다른 애한테 맡겨라. (서비스라는 레이어를 둘거다.)

    private final ScoreMapper repository;

//    @Autowired
//    public ScoreController(ScoreRepository repository) { // 빈에 등록된 repository가 ScoreRepositoryImpl 뿐이라서 자동으로 넣어준다.
//        this.repository = repository;
//    }



    // 점수 등록 및 조회 화면 열기 요청
    @RequestMapping("/score/list")
    public String list(@RequestParam(defaultValue = "num") String sort, Model model) {
        log.trace("/score/list GET 요청!! - param - {}", sort);


//        List<Score> scoreList = repository.findAll(sort); 기본 jdbc 템플릿 활용시
//        List<Score> scoreList = repository.findAll(); // mybatis로 변경시
        List<Score> scoreList = repository.findAll(sort); // mybatis로 변경 후 order by 도 학습한 뒤

        // 이름 마킹 처리 (성 빼고 *처리)
        for (Score score : scoreList) {
            String original = score.getName();
            String markName = String.valueOf(original.charAt(0));
            for (int i = 0; i < original.length() - 1; i++) {
                markName += "*"; // 이렇게 +를 쓰는거보다 StringBuilder를 쓰는게 더 좋다.
            }
            score.setName(markName.toString());
        }

        // jsp에게 점수 정보 리스트를 전달해야 함.
        model.addAttribute("scores", scoreList);

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

        log.trace("/score/register POST! - " + score);

        return repository.save(score) ? "redirect:/score/list" : "redirect:/";
    }



    // 점수 삭제 요청
    @RequestMapping("/score/delete")
                        // sn으로 변수명을 설정하고 싶으면 @RequestParm ("sn")
    public String delete(int stuNum) {
        log.trace("/score/delete GET - param1: {}", stuNum);
        return repository.remove(stuNum) ? "redirect:/score/list" : "redirect:/";
    }



    // 상세 정보 조회 요청
    @RequestMapping("/score/detail")
    public ModelAndView detail(int stuNum) {
        log.trace("/score/detail GET 요청!!");

        Score score = repository.findOne(stuNum);

//        model.addAttribute("s", score);
        ModelAndView mv = new ModelAndView("chap02/score-detail");
        mv.addObject("s", score);


        return mv;
    }

}
