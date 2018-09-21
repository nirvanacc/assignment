package com.advan.service.impl;

import com.advan.bean.RequestInfo;
import com.advan.bean.Server;
import com.advan.dao.RequestInfoDAO;
import com.advan.service.RequestInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * Created by haiming.wang on 2018/9/21.
 */
@Service
public class RequestInfoServiceImpl implements RequestInfoService{

    @Autowired
    RequestInfoDAO requestInfoDAO;

    @Override
    public Page<RequestInfo> pageAll(Integer page, Integer size) {
        Pageable pageable = new PageRequest(page-1, size);
        Page<RequestInfo> data = requestInfoDAO.findAll(pageable);
        return data;
    }

    @Override
    public void add(RequestInfo requestInfo) {
        requestInfo.setId(UUID.randomUUID().toString());
        requestInfo.setRequestDate(new Date());
        requestInfo.setState(0);
        requestInfoDAO.save(requestInfo);
    }
}
