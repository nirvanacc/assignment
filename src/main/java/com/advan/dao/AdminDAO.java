package com.advan.dao;

import com.advan.bean.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by haiming.wang on 2018/9/18.
 */
public interface AdminDAO extends JpaRepository<Admin, String> {

    public List<Admin> findByName(String name);

}
