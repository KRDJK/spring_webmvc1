package com.spring.webmvc.page_move;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/work")
public class WorkServlet extends HttpServlet {

    public WorkServlet() {
        System.out.println("workServlet 생성자 호출!");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("work 요청이 들어옴!");

        // 1. redirect : 재요청    -> 얘는 주소창까지 강제이동 페이지로 이동시킨다.
//        resp.sendRedirect("/info");
//        resp.sendRedirect("/jsp/result.jsp"); // 이 페이지로 이동 시키려고 한다.
            // 얘는 쿼리스트링으로 짜장면이라고 넣어줘도 음식명을 인식하지 못하네


        // 2. forword : 강제 이동 -> redirect랑 같이 쓸 수 없다.   얘는 /work라는 주소창이 남아있다.
        RequestDispatcher rd = req.getRequestDispatcher("/jsp/result.jsp"); // 얘는 음식명을 기억하네

        rd.forward(req, resp);


    }
}
