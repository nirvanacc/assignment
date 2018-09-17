package com.advan.service.impl;

import com.advan.com.advan.dao.ConsumerRepository;
import com.advan.entity.Consumer;
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
    ConsumerRepository consumerRepository;

    @Override
    public List<Consumer> getAll() {
        return consumerRepository.findAll();
    }
}
