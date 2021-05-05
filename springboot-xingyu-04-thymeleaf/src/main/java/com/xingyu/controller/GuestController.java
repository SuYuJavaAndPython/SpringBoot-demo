package com.xingyu.controller;

import com.xingyu.bean.Guest;
import com.xingyu.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class GuestController {

    @Autowired
    private GuestService guestService;

    @RequestMapping("/guest/list")
    public String list(Model model){
        List<Guest> guestList = guestService.list();
        model.addAttribute("guestList", guestList);
        return "welcome";
    }

    @RequestMapping("/guest/toAdd")
    public String toAdd(){
        return "add";
    }

    @RequestMapping("/guest/add")
    public String add(Guest guest){
        guestService.add(guest);
        return "redirect:/guest/list";
    }

    @RequestMapping("/guest/toUpdate")
    public String toUpdate(String name, Model model){
        Guest guest = guestService.selectOne(name);
        model.addAttribute("guest", guest);
        return "update";
    }

    @RequestMapping("/guest/update")
    public String update(Guest guest){
        System.out.println(guest);
        guestService.update(guest);
        return "redirect:/guest/list";
    }

    @RequestMapping("/guest/delete")
    public String delete(String name){
        List<Guest> guestList = guestService.list();
        for(Guest guest : guestList){
            if(guest.getName().equals(name)){
                guestList.remove(guest);
                break;
            }
        }
        return "redirect:/guest/list";
    }

}
