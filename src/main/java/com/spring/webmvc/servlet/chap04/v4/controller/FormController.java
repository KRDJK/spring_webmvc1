package com.spring.webmvc.servlet.chap04.v4.controller;

import com.spring.webmvc.servlet.chap04.Model;

import java.util.Map;

// 화면을 보여줄 컨트롤러
public class FormController implements ControllerV4 {

    @Override
    public String process(Map<String, String> paramMap, Model model) {

/*        // 물리적 경로
        String viewName = "/WEB-INF/views/reg_form.jsp";

        RequestDispatcher dp = request.getRequestDispatcher(viewName);
        dp.forward(request, response);*/

//        return new View("/WEB-INF/views/reg_form.jsp");
        return "reg_form";
    }
}
