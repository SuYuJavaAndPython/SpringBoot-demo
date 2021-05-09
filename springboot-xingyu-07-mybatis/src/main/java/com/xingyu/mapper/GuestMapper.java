package com.xingyu.mapper;

import com.xingyu.model.Guest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 猜测：
 * 加@Mapper为了让mybatis动态代理创建该接口的子类
 * 加@Repository为了让spring帮我们管理这个接口的对象，然后创建子类对象自动注入到spring的ioc容器中
 */
//@Mapper
@Repository
public interface GuestMapper {

    @Select("select name,role from guest")
    List<Guest> selectAllGuest();
}
