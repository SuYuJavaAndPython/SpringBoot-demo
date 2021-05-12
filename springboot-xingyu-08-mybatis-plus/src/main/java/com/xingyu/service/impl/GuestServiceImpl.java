package com.xingyu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xingyu.mapper.GuestMapper;
import com.xingyu.model.Guest;
import com.xingyu.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestServiceImpl extends ServiceImpl<GuestMapper,Guest> implements GuestService {

    @Autowired
    private GuestMapper guestMapper;

    public List<Guest> list() {
//        return guestMapper.selectList(null);
        return super.list();
    }

    @Override
    public void add(Guest guest) {
        super.save(guest);
    }

}
