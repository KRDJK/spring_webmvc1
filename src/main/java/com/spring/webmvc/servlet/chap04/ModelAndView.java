package com.spring.webmvc.servlet.chap04;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class ModelAndView {

    private View view; // 뷰 기능 포함하면서 추가로 아래의 맵을 하나 더 갖고 있다. 이게 컴포지션을 이용한 확장!!!

    // jsp에게 데이터를 전송할 모델 객체
    private Model model;



    public ModelAndView(String viewName) {
        this.view = new View(viewName);
    }


    // 모델 객체에 데이터를 추가하는 메서드
    public void addAttribute(String key, Object o) {
        model.getModel().put(key, o); // 일단 맵에 담고 만다.
    }


    public void render(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.view.render(req, resp);
    }


    public Map<String, Object> getModel() {
        return model.getModel();
    }

    public void setModel(Model model) {
        this.model = model;
    }
}
