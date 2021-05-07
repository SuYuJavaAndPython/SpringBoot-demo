package com.xingyu.service.impl;

import com.xingyu.bean.Guest;
import com.xingyu.dao.GuestDao;
import com.xingyu.repository.GuestRepository;
import com.xingyu.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestServiceImpl implements GuestService {

    @Autowired
    private GuestRepository guestRepository;

    public List<Guest> list() {
        return guestRepository.findAll();
    }

}
