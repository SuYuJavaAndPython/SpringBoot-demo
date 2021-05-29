package com.xingyu.controller;

import com.xingyu.bean.Person;
import com.xingyu.bean.Restaurant;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class ThymeleafController {

    @RequestMapping("/thymeleaf")
    public String thymeleaf(Model model){
//        model.addAttribute("name","<h2>陈文豪</h2>");
        Restaurant restaurant = new Restaurant("小陈","小徐");
        model.addAttribute("restaurant", restaurant);
        model.addAttribute("msg", "yes");
        model.addAttribute("num", 1);

        List<Person> personList = new ArrayList<>();
        Person person1 = new Person("student1", 18);
        Person person2 = new Person("student2", 19);
        Person person3 = new Person("student3", 20);
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        model.addAttribute("personList", personList);

        model.addAttribute("data",new Date());
        model.addAttribute("str","suyu");

        model.addAttribute("info","中国");

        return "/thymeleaf/index";
    }

    @RequestMapping("/welcome")
    public String welcome(){
        return "/thymeleaf/welcome";
    }
}
