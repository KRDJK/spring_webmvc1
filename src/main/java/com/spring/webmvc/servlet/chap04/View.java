package com.spring.webmvc.servlet.chap04;

import lombok.Getter;
import lombok.Setter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 뷰를 포워딩하는 기능
@Setter @Getter
public class View {

    private String viewName; // 포워딩할 뷰의 경로


    // v3에서 개선하고자 작성. 생성자로 초기화되는 부분에서 완성됨.
    private String prefix; // 접두사 (ex: /WEB-INF/views/ ) // setter로 향후 변경 가능
    private String suffix; // 접미사 (ex: .jsp ) // setter로 향후 변경 가능

    private boolean redirect; // 리다이렉트인지 확인 true면 redirect / false면 포워딩

    public View(String viewName) {
        this.prefix = "/WEB-INF/views/";
        this.suffix = ".jsp";
        if (!isRedirect(viewName)) {
            this.viewName = prefix + viewName + suffix;
        } else {
            // 리다이렉트면
            this.viewName = viewName.substring(viewName.indexOf(":") + 1);
                            // 비긴 인덱스 부터 ~ 끝 인덱스 미만까지 , 비긴 인덱스만 쓰면 거기서부터 끝까지!! 그래서 : 기준 +1 인덱스부터!!
        }
    }


    // 포워딩 기능
    public void render(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!this.redirect){
            RequestDispatcher dp = request.getRequestDispatcher(viewName);
            dp.forward(request, response);
        } else {
            response.sendRedirect(viewName);
        }
    }


    // 현재 뷰네임이 포워딩인지 리다이렉트인지 확인하는 메서드
    private boolean isRedirect(String viewName) {
        return this.redirect = viewName.contains("redirect:");
    }

}
