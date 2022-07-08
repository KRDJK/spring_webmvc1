package com.spring.webmvc.servlet.chap04.v1;

import com.spring.webmvc.servlet.chap04.v1.controller.ControllerV1;
import com.spring.webmvc.servlet.chap04.v1.controller.FormController;
import com.spring.webmvc.servlet.chap04.v1.controller.SaveController;
import com.spring.webmvc.servlet.chap04.v1.controller.ShowController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


// 프론트 컨트롤러란,, 모든 요청을 다 처리한다.
@WebServlet("/mvc/v1/*") // 이러면 /mvc/v1으로 시작하는 모든 요청을 다 받는다. 오호!!
public class FrontControllerV1 extends HttpServlet {

    /*
        1. /mvc/v1/join - 회원가입 폼 요청  ->  FormController 연결
        2. /mvc/v1/save - 회원가입 처리 요청 -> SaveController 연결
        3. /mvc/v1/show - 회원 목록 조회 요청 -> ShowController 연결
    */

    // 필드로 해시맵 사용 : 하위 컨트롤러들을 저장. 키값은 URL
    private final Map<String, ControllerV1> controllerMap = new HashMap<>();


    // 기본 생성자 생성.
    public FrontControllerV1() {
        controllerMap.put("/mvc/v1/join", new FormController());
        controllerMap.put("/mvc/v1/save", new SaveController());
        controllerMap.put("/mvc/v1/show", new ShowController());
    }


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        // 현재 들어온 요청 URI를 반환하는 메서드
        String uri = req.getRequestURI();
        System.out.println("front-controller 요청이 들어옴~~~:" + uri);


        // 컨트롤러 맵에서 방금 들어온 요청에 따른 적합한 컨트롤러를 꺼내옴.
        ControllerV1 controller = controllerMap.get(uri);

        if (controller == null) {
            resp.setStatus(404); // 그런 url에서는 내가 보여줄게 없다 라는 뜻. 404 = page not found -> 사용자 잘못
                                            // 500 = 자바 코드 에러. -> 개발자 잘못
            return; // 하단 컨트롤러.프로세스 실행하지 않고 메서드 종료.
        }


        controller.process(req, resp);
    }
}
