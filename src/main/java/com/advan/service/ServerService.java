package com.advan.service;

import com.advan.bean.Server;
import com.advan.bean.vo.PageVO;
import com.advan.bean.vo.ServerVO;
import org.springframework.data.domain.Page;

import javax.xml.ws.Service;
import java.util.List;

/**
 * Created by haiming.wang on 2018/9/18.
 */
public interface ServerService {

    public Page<Server> pageAll(Integer page, Integer size);

}
