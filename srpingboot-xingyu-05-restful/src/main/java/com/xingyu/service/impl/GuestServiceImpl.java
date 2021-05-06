package com.xingyu.service.impl;

import com.xingyu.bean.Guest;
import com.xingyu.dao.GuestDao;
import com.xingyu.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestServiceImpl implements GuestService {

    @Autowired
    private GuestDao guestDao;

    public List<Guest> list() {
        return guestDao.list();
    }

    public void add(Guest guest) {
        guestDao.add(guest);
    }

    @Override
    public Guest selectOne(String name) {
        return guestDao.selectOne(name);
    }

    @Override
    public void update(Guest guest) {
        guestDao.update(guest);
    }
}
