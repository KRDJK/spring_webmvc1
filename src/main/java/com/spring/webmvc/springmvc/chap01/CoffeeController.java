package com.spring.webmvc.springmvc.chap01;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2 // 로그 남기기
@RequestMapping("/coffee")
public class CoffeeController {

    private static class ModelUrl {
        public static final String ORDER = "/order";
        public static final String CHECK = "/check";
    }


    @RequestMapping(ModelUrl.ORDER)
    public String order() {
        log.info("/coffee/order GET Request"); // 로그 남기기
        return "chap01/coffee-order";
    }

    @RequestMapping(ModelUrl.CHECK)
    public String check(String menu, int price, Model model) {
        log.info("/coffee/check POST! - [" + menu + ", " + price + "]");

        model.addAttribute("menu", menu);
        model.addAttribute("price", price);

        return "chap01/coffee-result";
    }


}
