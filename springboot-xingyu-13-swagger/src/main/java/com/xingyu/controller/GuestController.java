package com.xingyu.controller;

import com.xingyu.bean.Guest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 原有的基于资源的请求接口设计按HTTP创始人的说法改为基于CRUD的请求接口设计
 * 体现在表现层的状态改变  如/guest/list    -->     /guest  该请求方式为GET
 * 增删改查 --> POST DELETE PUT GET
 * @RequestMapping("/guest")
 * 请求以/guest开头的到这个类中找对应的Restful接口
 */
@RestController
@RequestMapping("/guest")
@Api(tags = "嘉宾相关的接口")
public class GuestController {

    @GetMapping
    @ApiOperation(value = "查询嘉宾列表", notes="功能：以List<Guest>形式返回所有嘉宾信息")
    public String list(Model model){
        return "welcome";
    }

    @GetMapping("/toAdd")
    @ApiIgnore
    public String toAdd(){
        return "add";
    }

    @PostMapping
    @ApiOperation(value = "添加嘉宾信息", notes = "根据传来的嘉宾信息进行添加")
    public String add(Guest guest){
        return "redirect:/guest";
    }

    /**
     * @ApiIgnore api文档中不展示此接口
     * @param name
     * @param model
     * @return
     */
    @GetMapping("/toUpdate/{name}")
    @ApiIgnore
    public String toUpdate(@PathVariable("name") String name, Model model){
        return "update";
    }

    @PutMapping
    @ApiOperation(value = "修改嘉宾信息", notes = "根据传来的嘉宾信息对原有信息进行覆盖")
    public String update(Guest guest){
        return "redirect:/guest";
    }

    @DeleteMapping("/{name}")
    @ApiOperation(value="删除嘉宾信息", notes="根据嘉宾名字删除对应嘉宾")
    @ApiImplicitParam(paramType="delete", name = "name", value = "嘉宾名字", required = true)
    public String delete(@PathVariable("name") String name){
        return "redirect:/guest";
    }

}
