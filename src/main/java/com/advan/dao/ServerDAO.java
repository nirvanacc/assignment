package com.advan.dao;

import com.advan.bean.Server;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by haiming.wang on 2018/9/18.
 */
public interface ServerDAO extends JpaRepository<Server, String> {

    public List<Server> findByNameLike(String name);

    public List<Server> findByOsLike(String os);

    public List<Server> findByOwner(String consumerId);

}
