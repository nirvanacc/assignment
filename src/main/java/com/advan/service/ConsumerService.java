package com.advan.service;

import com.advan.bean.Consumer;

import java.util.List;

/**
 * Created by haiming.wang on 2018/9/17.
 */
public interface ConsumerService {

    public List<Consumer> getAll();

    public Consumer getById(String id);

    public List<Consumer> getByName(String name);

}
