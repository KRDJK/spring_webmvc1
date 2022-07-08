package com.spring.webmvc.servlet.chap04.v3.controller;

import com.spring.webmvc.servlet.chap04.ModelAndView;

import java.util.Map;

public interface ControllerV3 {

    // 요청 정보 속 정보들을 가지고 일을 처리해라.
//    View process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
    // 위 매개변수 정보들을 모르게 하고자 한다.


    /**
     *
     * @param paramMap : 요청정보(쿼리 파라미터)를 모두 읽어서 맵에 담아줌.
     * @return ModelAndView:
     *         jsp(뷰 템플릿)에게 보낼 데이터 객체 (Model)과
     *         화면 처리를 위해 화면 객체(View)를 같이 처리하는 객체
     */

//    View process(Map<String, String> paramMap);
    ModelAndView process(Map<String, String> paramMap);

}
