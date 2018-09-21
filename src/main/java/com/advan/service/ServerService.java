package com.advan.service;

import com.advan.bean.Server;
import org.springframework.data.domain.Page;

/**
 * Created by haiming.wang on 2018/9/18.
 */
public interface ServerService {

    public Page<Server> pageAll(Integer page, Integer size);

}
