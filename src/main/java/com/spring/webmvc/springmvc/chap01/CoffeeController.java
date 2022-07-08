package com.spring.webmvc.springmvc.chap01;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/coffee")
public class CoffeeController {

    private static class ModelUrl {
        public static final String ORDER = "/order";
        public static final String CHECK = "/check";
    }


    @RequestMapping(ModelUrl.ORDER)
    public String order() {
        return "chap01/coffee-order";
    }

    @RequestMapping(ModelUrl.CHECK)
    public String check(String coffeeName, int price, Model model) {



        return "chap01/coffee-result";
    }


}
