package com.spring.webmvc.chap04.v2.controller;

import com.spring.webmvc.chap04.View;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ControllerV2 {

    // 요청 정보 속 정보들을 가지고 일을 처리해라.
    View process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;


}
