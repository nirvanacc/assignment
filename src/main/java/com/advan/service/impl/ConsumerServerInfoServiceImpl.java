package com.advan.service.impl;

import com.advan.bean.ConsumerServerInfo;
import com.advan.dao.ConsumerServerInfoDAO;
import com.advan.service.ConsumerServerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by haiming.wang on 2018/9/18.
 */
@Service
public class ConsumerServerInfoServiceImpl implements ConsumerServerInfoService {

    @Autowired
    ConsumerServerInfoDAO consumerServerInfoDAO;

    @Override
    public ConsumerServerInfo getById(String id) {
        return consumerServerInfoDAO.findOne(id);
    }

    @Override
    public List<ConsumerServerInfo> getByConsumerId(String consumerId) {
        return null;
    }
}
