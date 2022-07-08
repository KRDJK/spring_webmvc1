package com.spring.webmvc.servlet.chap04;

import java.util.HashMap;
import java.util.Map;

public class Model {

    private Map<String, Object> model = new HashMap<>();


    // 모델 객체에 데이터를 저장하는 메서드.
    public void addAttribute(String key, Object o) {
        model.put(key, o);
    }


    public Map<String, Object> getModel() {
        return model;
    }
}
