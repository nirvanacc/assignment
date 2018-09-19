package com.advan.dao;

import com.advan.bean.Consumer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by haiming.wang on 2018/9/17.
 */
public interface ConsumerDAO extends JpaRepository<Consumer, String>{

    public List<Consumer> findByName(String name);

    public List<Consumer> findByNameLike(String name);
}
