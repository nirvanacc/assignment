package com.advan.service.impl;

import com.advan.bean.Consumer;
import com.advan.bean.Server;
import com.advan.bean.vo.PageVO;
import com.advan.bean.vo.ServerVO;
import com.advan.dao.AdminDAO;
import com.advan.dao.ConsumerDAO;
import com.advan.dao.ServerDAO;
import com.advan.service.AdminService;
import com.advan.service.ConsumerService;
import com.advan.service.ServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haiming.wang on 2018/9/18.
 */
@Service
public class ServerServiceImpl implements ServerService{

    @Autowired ServerDAO serverDAO;

    @Override
    public Page<Server> pageAll(Integer page, Integer size) {
        Pageable pageable = new PageRequest(page-1, size);
        Page<Server> data = serverDAO.findAll(pageable);
        return data;
    }

}
