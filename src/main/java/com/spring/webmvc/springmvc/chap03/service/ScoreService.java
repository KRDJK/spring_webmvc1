package com.spring.webmvc.springmvc.chap03.service;

import com.spring.webmvc.springmvc.chap02.domain.Score;
import com.spring.webmvc.springmvc.chap02.repository.ScoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

// 컨트롤러와 저장소(repo) 사이의 중간 로직 처리
    // 컨트롤러가 의존객체로 저장소 객체를 가지는게 아니라 서비스 객체를 의존하고
    // 서비스 객체는 저장소 객체에 의존한다.
@Service // 스프링 빈 등록 : @Component 가 들어있음.
@RequiredArgsConstructor
public class ScoreService {

    private final ScoreRepository repository;


    // 점수 목록 요청 중간 처리 메서드
    public List<Score> listService(String sort) {

        // jsp 에게 점수 정보 리스트를 전달해야 함.
        List<Score> scoreList = repository.findAll(sort);

        // 이름 마킹 처리
        processMarkName(scoreList);

        return scoreList;
    }
    
    
    // 점수 저장 요청 중간 처리
    public boolean saveService(Score score) {
        score.calcTotalAndAvg();
        score.calcGrade();

        return repository.save(score);
    }


    // 점수 삭제 요청 중간처리
    public boolean deleteService(int stuNum) {
        return repository.remove(stuNum);
    }


    // 점수 개별 조회 요청 중간처리
    public Score detailService(int stuNum) {
        return repository.findOne(stuNum);
    }


    
    // 컨트롤 + 알트 + M 으로 코드를 메서드로 추출
    private void processMarkName(List<Score> scoreList) {
        // 이름 마킹 처리 (성 빼고 *처리)
        for (Score score : scoreList) {
            String original = score.getName();
            String markName = String.valueOf(original.charAt(0));
            for (int i = 0; i < original.length() - 1; i++) {
                markName += "*"; // 이렇게 +를 쓰는거보다 StringBuilder를 쓰는게 더 좋다.
            }
            score.setName(markName.toString());
        }
    }
}
