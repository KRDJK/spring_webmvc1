package com.spring.webmvc.servlet.chap04.v4;


import com.spring.webmvc.servlet.chap04.Model;
import com.spring.webmvc.servlet.chap04.ModelAndView;
import com.spring.webmvc.servlet.chap04.v4.controller.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;


// 프론트 컨트롤러란,, 모든 요청을 다 처리한다.
@WebServlet("/mvc/v4/*") // 이러면 /mvc/v4으로 시작하는 모든 요청을 다 받는다. 오호!!
public class FrontControllerV4 extends HttpServlet {

    /*
        1. /mvc/v4/join - 회원가입 폼 요청  ->  FormController 연결
        2. /mvc/v4/save - 회원가입 처리 요청 -> SaveController 연결
        3. /mvc/v4/show - 회원 목록 조회 요청 -> ShowController 연결
        4. /mvc/v4/member - 회원 상세 조회 요청 -> FindOneController 연결
        5. /mvc/v4/remove - 회원 삭제 요청
    */


    // 필드로 해시맵 사용 : 하위 컨트롤러들을 저장. 키값은 URL
    private final Map<String, ControllerV4> controllerMap = new HashMap<>();


    // 기본 생성자 생성. 스프링에서는 의존성 주입에 의해서 여기에 또 알아서 다 넣어준다.
    public FrontControllerV4() {
        controllerMap.put("/mvc/v4/join", new FormController());
        controllerMap.put("/mvc/v4/save", new SaveController());
        controllerMap.put("/mvc/v4/show", new ShowController());
        controllerMap.put("/mvc/v4/member", new FindOneController());
        controllerMap.put("/mvc/v4/remove", new RemoveController());
    }


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        // 현재 들어온 요청 URI를 반환하는 메서드
        String uri = req.getRequestURI();
        System.out.println("front-controller 요청이 들어옴~~~:" + uri);


        // 컨트롤러 맵에서 방금 들어온 요청에 따른 적합한 컨트롤러를 꺼내옴.
        ControllerV4 controller = controllerMap.get(uri);


        if (controller == null) {
            resp.setStatus(404); // 그런 url에서는 내가 보여줄게 없다 라는 뜻. 404 = page not found -> 사용자 잘못
                                            // 500 = 자바 코드 에러. -> 개발자 잘못
            return; // 하단 컨트롤러.프로세스 실행하지 않고 메서드 종료.
        }


        // 요청 파라미터( query parameter )를 전부 읽어서 하위 컨트롤러들에게 보내줌.
        // key : 쿼리 파라미터의 key, value : 쿼리 파라미터의 value
        Map<String, String> paramMap = createParamMap(req);
//        System.out.println("paramMap = " + paramMap);


//        Map<String, String[]> parameterMap = req.getParameterMap();
//        System.out.println("쿼리 파라미터 맵: " + parameterMap);


        Model model = new Model(); // 모델 객체 생성해서 하위 컨트롤러에게 전달
        String viewName = controller.process(paramMap, model);
        ModelAndView mv = new ModelAndView(viewName);
        mv.setModel(model); // 모델앤뷰 객체에 데이터 모델 저장.


        // 모델 데이터를 jsp로 전송
        modelToView(req, mv);


        // 화면 렌더링
        mv.render(req, resp);

    }

    private void modelToView(HttpServletRequest req, ModelAndView mv) {
        Map<String, Object> model = mv.getModel(); // 모델에 담고 말았던걸 가져와야지

        for (String key : model.keySet()) {
            req.setAttribute(key, model.get(key));
        }
    }


    private Map<String, String> createParamMap (HttpServletRequest req) {
        Map<String, String> paramMap = new HashMap<>();

        // 요청 파라미터( query parameter )를 전부 읽어서 하위 컨트롤러들에게 보내줌.
        // key : 쿼리 파라미터의 key, value : 쿼리 파라미터의 value
        Enumeration<String> parameterNames = req.getParameterNames();
        // 얘는 쿼리 파라미터의 key값만 가져온다.

        while (parameterNames.hasMoreElements()) {
            String key = parameterNames.nextElement();
            String value = req.getParameter(key);

            paramMap.put(key, value);
        }
        return paramMap;
    }
}
