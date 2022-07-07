package com.spring.webmvc.chap04.v3.controller;

import com.spring.webmvc.chap04.View;

import java.util.Map;

// 화면을 보여줄 컨트롤러
public class FormController implements ControllerV3 {

    @Override
    public View process(Map<String, String> paramMap) {

/*        // 물리적 경로
        String viewName = "/WEB-INF/views/reg_form.jsp";

        RequestDispatcher dp = request.getRequestDispatcher(viewName);
        dp.forward(request, response);*/

        return new View("/WEB-INF/views/reg_form.jsp");

    }
}
