package com.xingyu.controller;

import com.xingyu.bean.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        model.addAttribute("info","Freemarker");
        List<Person> personList = new ArrayList<>();
        Person person1 = new Person("student1", 18);
        Person person2 = new Person("student2", 19);
        Person person3 = new Person("student3", 20);
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        model.addAttribute("personList", personList);

        model.addAttribute("testNull",null);
        return "/freemarker/index";
    }
}
