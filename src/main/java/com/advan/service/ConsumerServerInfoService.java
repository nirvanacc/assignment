package com.advan.service;

import com.advan.bean.ConsumerServerInfo;

import java.util.List;

/**
 * Created by haiming.wang on 2018/9/18.
 */
public interface ConsumerServerInfoService {

    public ConsumerServerInfo getById(String id);

    public List<ConsumerServerInfo> getByConsumerId(String consumerId);

}
