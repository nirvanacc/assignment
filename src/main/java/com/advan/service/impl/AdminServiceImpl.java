package com.advan.service.impl;

import com.advan.bean.Admin;
import com.advan.dao.AdminDAO;
import com.advan.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by haiming.wang on 2018/9/18.
 */
@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    AdminDAO adminDAO;

    @Override
    public Admin getById(String id) {
        return adminDAO.findOne(id);
    }

    @Override
    public List<Admin> getByName(String name) {
        return adminDAO.findByName(name);
    }
}
