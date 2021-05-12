package com.xingyu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xingyu.model.Guest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GuestService extends IService<Guest> {

    List<Guest> list();

    void add(Guest guest);

}
