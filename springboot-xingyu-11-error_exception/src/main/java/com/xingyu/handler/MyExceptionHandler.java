package com.xingyu.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ControllerAdvice 基于aop实现的
 */
@ControllerAdvice
public class MyExceptionHandler {

    /**
     * 在此处分异常类型进行不同的处理
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ModelAndView handler(Exception e){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("error");
        mv.addObject("message", e.getMessage());
        return mv;
    }
}
