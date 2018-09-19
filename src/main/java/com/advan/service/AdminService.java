package com.advan.service;

import com.advan.bean.Admin;

import java.util.List;

/**
 * Created by haiming.wang on 2018/9/18.
 */
public interface AdminService {

    public Admin getById(String id);

    public List<Admin> getByName(String name);

}
