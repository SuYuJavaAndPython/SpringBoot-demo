package com.xingyu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * @Controller  是视图层使用的注解
 * @RestContrroller 是返回json数据时使用的注解
 */
@Controller
public class FtlController {

    @RequestMapping("/ftl")
    public String index(Model model){
        System.out.println("请求ftl");
        model.addAttribute("now", new Date().toString());
        return "/freemarker/index";
    }
}
