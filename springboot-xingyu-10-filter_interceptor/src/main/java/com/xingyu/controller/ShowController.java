package com.xingyu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShowController {

    @GetMapping("/servlet")
    public String servlet(){
        System.out.println("我是controller");
        return "hello";
    }
}
