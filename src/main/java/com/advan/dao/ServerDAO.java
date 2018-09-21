package com.advan.dao;

import com.advan.bean.Server;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by haiming.wang on 2018/9/18.
 */
public interface ServerDAO extends JpaRepository<Server, String> {

    public List<Server> findByNameLike(String name);

    public List<Server> findByOsLike(String os);

    public List<Server> findByOwner(String consumerId);

    @Query(value = "SELECT * FROM \"server\" WHERE \"owner\" = ?1 LIMIT ?3 OFFSET ?2", nativeQuery = true)
    public List<Server> pageServersByConsumer(String id, Integer start, Integer size);

    @Query(value = "SELECT \"count\"(*) FROM \"server\" WHERE \"owner\" = ?1", nativeQuery = true)
    public Long pageServersByConsumerTotal(String id);

}
