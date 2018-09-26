package com.advan.service.impl;

import com.advan.bean.Consumer;
import com.advan.dao.ConsumerDAO;
import com.advan.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Created by haiming.wang on 2018/9/17.
 */
@Service
public class ConsumerServiceImpl implements ConsumerService{

    @Autowired
    ConsumerDAO consumerDAO;

    @Override
    public Page<Consumer> pageAll(Integer page, Integer size) {
        Pageable pageable = new PageRequest(page-1, size);
        Page<Consumer> data = consumerDAO.findAll(pageable);
        return data;
    }
}
