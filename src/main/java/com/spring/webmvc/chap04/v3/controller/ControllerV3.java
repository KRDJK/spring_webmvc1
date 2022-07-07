package com.spring.webmvc.chap04.v3.controller;

import com.spring.webmvc.chap04.View;

import java.util.Map;

public interface ControllerV3 {

    // 요청 정보 속 정보들을 가지고 일을 처리해라.
//    View process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
    // 위 매개변수 정보들을 모르게 하고자 한다.


    /**
     *
     * @param paramMap : 요청정보(쿼리 파라미터)를 모두 읽어서 맵에 담아줌.
     * @return
     */

    View process(Map<String, String> paramMap);

}
