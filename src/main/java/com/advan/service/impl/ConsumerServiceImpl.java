package com.advan.service.impl;

import com.advan.dao.ConsumerDAO;
import com.advan.bean.Consumer;
import com.advan.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by haiming.wang on 2018/9/17.
 */
@Service
public class ConsumerServiceImpl implements ConsumerService{

    @Autowired
    ConsumerDAO consumerDAO;

    @Override
    public List<Consumer> getAll() {
        return consumerDAO.findAll();
    }

    @Override
    public Consumer getById(String id) {
        return consumerDAO.findOne(id);
    }

    @Override
    public List<Consumer> getByName(String name) {
        return consumerDAO.findByName(name);
    }
}
