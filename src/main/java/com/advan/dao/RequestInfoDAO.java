package com.advan.dao;

import com.advan.bean.RequestInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by haiming.wang on 2018/9/21.
 */
public interface RequestInfoDAO extends JpaRepository<RequestInfo, String>{

    @Query(value = "select * from request_info where \"state\" = 0 LIMIT ?2 OFFSET ?1", nativeQuery = true)
    public List<RequestInfo> pageRequestUnsolved(Integer start, Integer size);

    @Query(value = "select \"count\"(*) from request_info where \"state\" = 0", nativeQuery = true)
    public Long unsolvedTotal();

    @Query(value = "select * from request_info where \"state\" != 0 LIMIT ?2 OFFSET ?1", nativeQuery = true)
    public List<RequestInfo> pageHisRequest(Integer start, Integer size);

    @Query(value = "select \"count\"(*) from request_info where \"state\" != 0", nativeQuery = true)
    public Long hisTotal();

}
