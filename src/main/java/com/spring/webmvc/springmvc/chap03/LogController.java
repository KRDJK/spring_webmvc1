package com.spring.webmvc.springmvc.chap03;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//@Log4j2
@Slf4j // @Log4j2 랑 기능은 같다고 보면 된다.
public class LogController {

    @RequestMapping("/log/test")
    @ResponseBody // 클라이언트에게 직접 데이터 응답
    // 직접 응답된 데이터는 페이지 소스 보기를 해봐야 태그가 아무것도 나오지 않는다.
    public String logTest() {

        System.out.println("log!!"); // 얘는 로그남기기용으로 좋지 않다.
        // 왜 안좋냐?! -> 로그의 레벨을 지정할 수 없다.

        /*  로그 레벨 종류 : 아래로 갈수록 로그 레벨이 높다.
            trace: 로컬 pc에서 테스트 용으로 찍는 로그 (메롱메롱같이 쓰잘데 없는거 찍는 것도 가능)
            debug: 개발 서버에서 찍는 로그
            info: 운영 서버에서 찍는 로그
            warn: 경고사항에 대한 로그
            error: 에러 상황에 대한 로그
        */
        log.trace(" trace log!!");
        log.debug(" debug log!!");
        log.info(" info log!!");
        log.warn(" warn log!!");
        log.error(" error log!!");

        log.trace("메롱");
        log.debug(" parameter ");

        try {
            log.info("info log");
        } catch (Exception e) {
            log.error(" 심각한 에러!");
//            throw new Exception();
        }

        return "hello";
    }

}
