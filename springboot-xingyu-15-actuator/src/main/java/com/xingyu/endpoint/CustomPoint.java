package com.xingyu.endpoint;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 自定义端点
 *      1.需要自己写一个类，类上写@Component交由spring管理
 *      2.类上写@Endpoint(id = "端点名")  声明是一个端点
 *      3.自定义访问该端点时的处理方法
 */
@Component
@Endpoint(id = "customPoint")
public class CustomPoint {

    /**
     * 端点访问时的处理方法，通过@ReadOperation来查找
     * 注意需要返回json数据
     * @return
     */
    @ReadOperation
    @ResponseBody
    public Map<String,String> custom(){
        Map<String,String> map = new HashMap<>();
        map.put("name", "myCustomPoint");
        return map;
    }
}
