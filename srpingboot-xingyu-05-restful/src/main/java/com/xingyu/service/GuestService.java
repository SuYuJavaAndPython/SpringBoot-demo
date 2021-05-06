package com.xingyu.service;

import com.xingyu.bean.Guest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GuestService {

    List<Guest> list();

    void add(Guest guest);

    Guest selectOne(String name);

    void update(Guest guest);

}
