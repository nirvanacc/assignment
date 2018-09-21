package com.advan.dao;

import com.advan.bean.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by haiming.wang on 2018/9/21.
 */
public interface MessageDAO extends JpaRepository<Message, String>{

    public List<Message> getByReceiverOrderByPostDateDesc(String receiver);
}
