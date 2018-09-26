package com.advan.service;

import com.advan.bean.Consumer;
import org.springframework.data.domain.Page;

/**
 * Created by haiming.wang on 2018/9/17.
 */
public interface ConsumerService {

    public Page<Consumer> pageAll(Integer page, Integer size);

}
