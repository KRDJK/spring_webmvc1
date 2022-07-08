package com.spring.webmvc.servlet.chap04.v1.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ControllerV1 {

    // 요청 정보 속 정보들을 가지고 일을 처리해라.
    void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;


}
