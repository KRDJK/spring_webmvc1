package com.spring.webmvc.servlet.chap03.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


// WEB-INF 폴더에 있는 reg_form.jsp 를 열어주는 요청 처리만 담당할 것이다.
@WebServlet("/mvc/join") // 맨 앞에 [ / ]를 안붙이면 기본값이 [./] 가 된다. 절대경로가 아닌 상대경로가 됨.
            // 상대경로 save로 이동하는 무언가가 있다면 /mvc/save가 됨.  ../ 였다면 앞에 /mvc 없이 /save
public class JoinServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 물리적 경로
        String viewName = "/WEB-INF/views/reg_form.jsp";


        RequestDispatcher dp = req.getRequestDispatcher(viewName);
        dp.forward(req, resp); // req와 resp의 정보를 들고 viewName 링크로 가라

    }
}
