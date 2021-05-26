package com.xingyu.dao;

import com.xingyu.bean.Guest;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Mapper
@Repository
public interface GuestDao {

    @Select("select * from guest")
    List<Guest> list();

    @Select("select * from guest where id = #{id}")
    Guest selectOne(Integer id);

    @Update("update guest set name=#{name}, role=#{role} where id=#{id}")
    void updateGuest(Guest guest);

    @Delete("delete from guest where id=#{id}")
    void deleteGuest(Integer id);

    @Delete("delete from guest")
    void deleteAllGuest();

}
