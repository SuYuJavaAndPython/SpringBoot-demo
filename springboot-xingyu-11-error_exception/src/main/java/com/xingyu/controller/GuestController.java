package com.xingyu.controller;

import com.xingyu.bean.Guest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

@Controller
public class GuestController {

    /**
     * @Valid 直接放在bean前面用于检验它是否符合注解规则
     * 校验不通过时默认返回400 和 错误信息
     * 默认的校验方式是遍历bean的所有属性挨个校验，失败结果全部返回
     * 修改默认的返回规则：添加BindResult类型的参数
     *                  （放置在具有@Valid参数的后面，这样才能获取到错误信息）
     *                  自行处理返回结果
     * @param guest
     * @return
     */
    @PostMapping("guest")
    @ResponseBody
    public String addGuest(@Valid Guest guest, BindingResult bindingResult){
        if(bindingResult.getErrorCount() > 0){
            StringBuffer buffer = new StringBuffer();
            List<FieldError> fieldErrorList = bindingResult.getFieldErrors();
            for(FieldError fieldError : fieldErrorList){
                buffer.append(fieldError.getField());
                buffer.append("\t");
                buffer.append(fieldError.getDefaultMessage());
                buffer.append("\n");
            }
            return buffer.toString();
        }
        return "success";
    }
}
