package com.xingyu.mapper2;

import com.xingyu.model.Guest;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuestMapper2 {

    @Select("select name,role from guest")
    List<Guest> selectAllGuest();

}
