package com.xingyu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyErrorController {

    @RequestMapping("/myError404")
    public String myError(){
        return "myError404";
    }

    @RequestMapping("/testError")
    public String error() throws Exception {
        throw new Exception("测试异常");
    }
}
