package com.xingyu.controller;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Component
public class TestController {

    @GetMapping("/")
    public String test(Model model){
        model.addAttribute("test","Test Security");
        return "welcome";
    }
}
