package com.advan.service.impl;

import com.advan.bean.Consumer;
import com.advan.bean.Server;
import com.advan.bean.vo.ServerVO;
import com.advan.dao.AdminDAO;
import com.advan.dao.ConsumerDAO;
import com.advan.dao.ServerDAO;
import com.advan.service.AdminService;
import com.advan.service.ConsumerService;
import com.advan.service.ServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haiming.wang on 2018/9/18.
 */
@Service
public class ServerServiceImpl implements ServerService{

    @Autowired
    ConsumerDAO consumerDAO;
    @Autowired
    AdminDAO adminDAO;

    /**
     * 原始类转换为vo类
     * @param serverList
     * @return
     */
    public List<ServerVO> toVO(List<Server> serverList){
        List<ServerVO> serverVOList = new ArrayList<>(serverList.size());
        for (Server item : serverList) {
            ServerVO serverVO = new ServerVO();
            serverVO.setId(item.getId());
            serverVO.setName(item.getName());
            serverVO.setOs(item.getOs());
            if (item.getRunningState() == 0) {
                serverVO.setRunningState(0);
                serverVO.setRunningStateText("正常");
            } else {
                serverVO.setRunningState(1);
                serverVO.setRunningStateText("异常");
            }
            if (item.getIsAllocated() == 0) {
                serverVO.setIsAllocated(0);
                serverVO.setIsAllocatedText("未分配");
            } else {
                serverVO.setIsAllocated(1);
                serverVO.setIsAllocatedText("已分配");
                serverVO.setOwner(item.getOwner());
                serverVO.setOwnerText(consumerDAO.findOne(item.getOwner()).getName());
            }
            serverVO.setModifiedBy(item.getModifiedBy());
            serverVO.setModifiedByText(adminDAO.findOne(item.getModifiedBy()).getName());
            serverVO.setModifiedDate(item.getModifiedDate());
            serverVOList.add(serverVO);
        }
        return serverVOList;
    }


}
