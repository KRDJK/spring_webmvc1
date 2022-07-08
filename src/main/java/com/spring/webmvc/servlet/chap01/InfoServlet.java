package com.spring.webmvc.servlet.chap01;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*
    # 서블릿 : http 요청과 응답 데이터를 쉽게 처리할 수 있도록
              도와주는 자바의 API
*/

@WebServlet("/info") // 우리 사이트에서 어떤 정보를 얻고 싶으면 [ /info ]를 해라라는 뜻

// [/info]로 들어오는 것들을 하위 service 부분의 req에서 다 받겠다는 뜻!!

public class InfoServlet extends HttpServlet {

    public InfoServlet() { // TomCat이란 애가 이걸 호출하고 아래의 service 메서드까지 실행시킨거다.
        System.out.println("InfoServlet 생성자 호출!!");
    }

//    private String name = "바보";

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("info 요청이 들어왔습니다.");

//        this.name = req.getParameter("name");


        // 요청 정보 받기
        double height = Double.parseDouble(req.getParameter("height"));
        double weight = Double.parseDouble(req.getParameter("weight"));

        // 응답 정보 생성하기
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html"); // 상대방에게 응답할 때 html 스타일로 응답할거다.

        PrintWriter w = resp.getWriter();

        w.write("<html>");
        w.write("<body>");

        double bmi = calcBMI(height, weight);
        w.write("<h1>당신의 체질량 지수는 " + bmi + "입니다.</h1>");

        if (bmi > 25.0) {
            w.write("<h2>과체중입니다.</h2>");
        } else if (bmi < 18.5) {
            w.write("<h2>저체중입니다.</h2>");
        } else {
            w.write("<h2>정상 체중입니다.</h2>");
        }

        w.write("</body>");
        w.write("</html>");

    }

    @Override
    public void destroy() {
        System.out.println("서블릿 destroyed!!");
    }


    private double calcBMI(double cm, double kg) {
        double m = cm / 100;
        double bmi = kg / (m * m);
        return bmi;
    }

}
