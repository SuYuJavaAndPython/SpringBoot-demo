package com.xingyu.service.impl;

import com.xingyu.mapper.GuestMapper;
import com.xingyu.mapper2.GuestMapper2;
import com.xingyu.model.Guest;
import com.xingyu.service.GuestService;
import com.xingyu.tk.mapper.TkGuestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestServiceImpl implements GuestService {

    //springboot整合mybatis mapper注入时显示could not autowire的错误，不影响使用，但是看着不爽
    //因为GuestMapper是接口，需要mybatis动态代理创建子类后才能创建子类对象自动注入
    // @Mapper和@MapperScan作用域是Runtime（class文件运行时才生效）
    // 而lombok的@Data这类注解作用域在SOURCE（源代码java文件中就生效了）
    //因此在项目启动前spring未读取到mybatis在运行时动态代理产生的代理对象也就会在加上@Autowired后报红
//    @Autowired
//    private GuestMapper guestMapper;

    //采用tk.mybatis提供的crud
//    @Autowired
//    private TkGuestMapper tkGuestMapper;

    //采用多数据源
    @Autowired
    private GuestMapper guestMapper;

    @Autowired
    private GuestMapper2 guestMapper2;

    public List<Guest> list() {
//        return guestMapper.selectAllGuest();
//        return tkGuestMapper.selectAll();
        return guestMapper2.selectAllGuest();
    }

}
