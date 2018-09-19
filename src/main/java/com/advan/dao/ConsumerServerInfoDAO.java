package com.advan.dao;

import com.advan.bean.ConsumerServerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by haiming.wang on 2018/9/18.
 */
public interface ConsumerServerInfoDAO extends JpaRepository<ConsumerServerInfo, String> {
}
