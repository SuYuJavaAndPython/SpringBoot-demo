package com.xingyu.controller;

import com.xingyu.bean.Guest;
import com.xingyu.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 原有的基于资源的请求接口设计按HTTP创始人的说法改为基于CRUD的请求接口设计
 * 体现在表现层的状态改变  如/guest/list    -->     /guest  该请求方式为GET
 * 增删改查 --> POST DELETE PUT GET
 * @RequestMapping("/guest")
 * 请求以/guest开头的到这个类中找对应的Restful接口
 */
@RestController
@RequestMapping("/guest")
public class GuestController {

    @Autowired
    private GuestService guestService;

    @GetMapping
    public List<Guest> list(){
        return guestService.list();
    }

    @GetMapping("/{id}")
    public Guest selectOne(@PathVariable("id") Integer id){
        Guest guest = guestService.selectOne(id);
        System.out.println("查询单个结果："+guest);
        return guest;
    }

    @PutMapping
    public Guest updateGuest(Guest guest){
        return guestService.updateGuest(guest);
    }

    @DeleteMapping("/{id}")
    public String deleteGuestByID(@PathVariable("id") Integer id){
        if(id != 0){
            guestService.deleteGuest(id);
        }else{
            guestService.deleteAllGuest();
        }
        return "success";
    }
}
