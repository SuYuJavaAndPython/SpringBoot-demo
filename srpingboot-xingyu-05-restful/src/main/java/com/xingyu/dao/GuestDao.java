package com.xingyu.dao;

import com.xingyu.bean.Guest;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GuestDao {

    private static List<Guest> guestList = new ArrayList<>();

    static{
        guestList.add(new Guest("老陈","老板"));
        guestList.add(new Guest("小法","扫地"));
        guestList.add(new Guest("小陈","厨师"));
        guestList.add(new Guest("小何","搬运工"));
        guestList.add(new Guest("小熊","前台"));
        guestList.add(new Guest("小王","前台"));
    }

    public List<Guest> list(){
        return guestList;
    }

    public void add(Guest guest){
        guestList.add(guest);
    }

    public Guest selectOne(String name){
        for(Guest guest : guestList){
            if(guest.getName().equals(name)){
                return guest;
            }
        }
        return null;
    }

    public void update(Guest guest){
        for(Guest g : guestList){
            if(g.getName().equals(guest.getName())){
                g.setRole(guest.getRole());
                break;
            }
        }
    }

    public void delete(String name){
        for(Guest guest : guestList){
            if(guest.getName().equals(name)){
                guestList.remove(guest);
                break;
            }
        }
    }
}
