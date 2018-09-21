package com.advan.service;

import com.advan.bean.RequestInfo;
import com.advan.bean.Server;
import org.springframework.data.domain.Page;

/**
 * Created by haiming.wang on 2018/9/21.
 */
public interface RequestInfoService {

    public Page<RequestInfo> pageAll(Integer page, Integer size);

    public void add(RequestInfo requestInfo);
}
