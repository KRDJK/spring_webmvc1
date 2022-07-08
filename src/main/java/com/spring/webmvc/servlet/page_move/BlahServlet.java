package com.spring.webmvc.servlet.page_move;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

@WebServlet("/blah") // blah.jsp를 열 수 있는 url을 만들어준다.
public class BlahServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        resp.sendRedirect("/WEB-INF/blah.jsp");
        // 클라이언트 쪽에서는 이걸 못여는데 sendRedirect는 다시 이걸 요청하기 때문에!! 클라이언트가 접근 시도를 한거처럼 된다.


        // 모델에 데이터 담기
        req.setAttribute("msg", "안뇽하세요~"); // msg라는 key값으로 blah.jsp에 데이터가 들어간다.
        req.setAttribute("number", 200);

//        req.setAttribute("hobbys", Arrays.asList("수영", "독서", "수면")); // 리턴 타입이 리스트가 된다.
        req.setAttribute("hobbys", new ArrayList<>(Arrays.asList("취미 한개"))); // 빈리스트를 보내보자.


        RequestDispatcher dp = req.getRequestDispatcher("/WEB-INF/blah.jsp");
        dp.forward(req, resp);
        // 서버에서 실행했기 때문에 접근이 가능함과 동시에 경로를 띄워 알려주지 않는다.


    }
}
