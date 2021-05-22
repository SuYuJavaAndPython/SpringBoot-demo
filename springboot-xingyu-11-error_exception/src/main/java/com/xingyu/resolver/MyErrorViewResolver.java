package com.xingyu.resolver;

import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 实现ErrorViewResolver后仅说明MyErrorViewResolver是一个错误视图的解析者
 * 但并不被spring使用，需加@Component表示组件，交由spring管理
 */
@Component
public class MyErrorViewResolver implements ErrorViewResolver {

    @Override
    public ModelAndView resolveErrorView(HttpServletRequest request, HttpStatus status,
                                         Map<String, Object> model) {
        if(status.equals(HttpStatus.NOT_FOUND)){
            System.out.println(status);
            System.out.println(model);
            ModelAndView mv = new ModelAndView();
            mv.setViewName("my404");
            return mv;
        }
        return null;
    }
}
