package com.xingyu.controller;

import com.xingyu.bean.Food;
import com.xingyu.bean.Vegetables;
import com.xingyu.config.FoodConfig;
import com.xingyu.config.VegetablesConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController
 * 是@Controller和@ResponseBody的组合
 * 作用：返回json形式的响应结果或直接响应字符串 而不是视图（jsp，html）
 */
@RestController
public class JsonController {

    @RequestMapping("/string")
    public String string(){
        return "string";
    }

    /**
     * 读取application中的配置信息
     */
//    @Value("${food.ice}")
//    private String ice;
//    @Value("${food.price}")
//    private String price;

    @Value("${info.name}")
    private String name;
    @Value("${info.password}")
    private String password;

    @RequestMapping("jasypt")
    public String jasypt(){
        return name + " " + password;
    }


    @Autowired
    private FoodConfig foodConfig;

    @RequestMapping("/json")
    public Food json(){
        Food food = new Food(foodConfig.getIce(),foodConfig.getPrice(),foodConfig.getTastes());
        return food;
    }

    @Autowired
    private VegetablesConfig vegetablesConfig;

    @RequestMapping("/vegetables")
    public Vegetables vegetables(){
        Vegetables vegetables = new Vegetables(vegetablesConfig.getPotato(),vegetablesConfig.getEggplant(),vegetablesConfig.getGreenPepper());
        return vegetables;
    }


}
