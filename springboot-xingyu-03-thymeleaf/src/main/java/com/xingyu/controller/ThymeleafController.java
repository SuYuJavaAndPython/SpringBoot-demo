package com.xingyu.controller;

import com.xingyu.bean.Restaurant;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ThymeleafController {

    @RequestMapping("/thymeleaf")
    public String thymeleaf(Model model){
//        model.addAttribute("name","<h2>陈文豪</h2>");
        Restaurant restaurant = new Restaurant("小陈","小徐");
        model.addAttribute("restaurant", restaurant);
        return "/thymeleaf/index";
    }

    @RequestMapping("/welcome")
    public String welcome(){
        return "/thymeleaf/welcome";
    }
}
