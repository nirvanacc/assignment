package com.advan.controller;

import com.advan.bean.Consumer;
import com.advan.bean.Server;
import com.advan.bean.vo.PageVO;
import com.advan.bean.vo.ServerVO;
import com.advan.dao.AdminDAO;
import com.advan.dao.ConsumerDAO;
import com.advan.dao.ServerDAO;
import com.advan.service.ServerService;
import com.advan.utils.result.Result;
import com.advan.utils.result.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by haiming.wang on 2018/9/18.
 */
@RestController
@RequestMapping("server")
public class ServerController {

    @Autowired ServerDAO serverDAO;
    @Autowired ConsumerDAO consumerDAO;
    @Autowired AdminDAO adminDAO;
    @Autowired ServerService serverService;

    /**
     * 所有设备分页
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/pageAll")
    public Result pageAllServers(Integer page, Integer size){
        PageVO pageVO = new PageVO();
        Page<Server> serverPage = serverService.pageAll(page, size);
        pageVO.setContent(toVO(serverPage.getContent()));
        pageVO.setTotalElements(serverPage.getTotalElements());
        return ResultUtil.success(pageVO);
    }

    /**
     * 添加/更新设备信息
     * @param server
     * @return
     */
    @PostMapping("/update")
    public Result add(@RequestBody Server server){
        if(server.getId() == null || server.getId() == ""){
            server.setId(UUID.randomUUID().toString());
        }
        server.setModifiedDate(new Date());
        serverDAO.save(server);
        return ResultUtil.success();
    }

    /**
     * 归还设备
     * @param server
     * @return
     */
    @PostMapping("/return")
    public Result returnServer(@RequestBody Server server){
        server.setIsAllocated(0);
        server.setOwner(null);
        serverDAO.save(server);
        return ResultUtil.success();
    }

    /**
     * 批量归还设备
     * @param serverList
     * @return
     */
    @PostMapping("/returnBatch")
    public Result returnBatch(@RequestBody List<Server> serverList){
        for(Server item:serverList){
            item.setIsAllocated(0);
            item.setOwner(null);
            serverDAO.save(item);
        }
        return ResultUtil.success();
    }

    /**
     * 删除设备
     * @param id
     * @return
     */
    @GetMapping("/delete")
    public Result delete(String id){
        serverDAO.delete(id);
        return ResultUtil.success();
    }

    /**
     * 批量删除设备
     * @param serverVOList
     * @return
     */
    @PostMapping("/deleteBatch")
    public Result deleteBatch(@RequestBody List<ServerVO> serverVOList){
        for(ServerVO item:serverVOList){
            delete(item.getId());
        }
        return ResultUtil.success();
    }

    /**
     * 设备多字段模糊查询
     * @param para
     * @return
     */
    @GetMapping("/fuzzy")
    public Result fuzzySearch(String para){
        para = "%"+para+"%";
        List<Server> allServers = new ArrayList<>();
        // 若参数意为服务器名
        List<Server> serverListByName = serverDAO.findByNameLike(para);
        // 若参数意为操作系统
        List<Server> serverListByOs = serverDAO.findByOsLike(para);
        // 若参数意为用户名，模糊查询到可能的Id，再拿到consumerId对应的所有server
        List<Server> serverListByOwner = new ArrayList<>();
        for(Consumer item:consumerDAO.findByNameLike(para)){
            List<Server> servers = serverDAO.findByOwner(item.getId());
            serverListByOwner.addAll(servers);
        }
        // 合并所有，去重
        allServers.addAll(serverListByName);
        allServers.addAll(serverListByOs);
        allServers.addAll(serverListByOwner);
        allServers = new ArrayList<Server>(new LinkedHashSet<>(allServers));
        return ResultUtil.success(toVO(allServers));
    }

    /**
     * 分页获取个人设备
     * @param id
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/pageByConsumer")
    public Result pageMyServers(String id, Integer page, Integer size){
        PageVO pageVO = new PageVO();
        List<Server> serverList = serverDAO.pageServersByConsumer(id, (page-1)*size, size);
        pageVO.setContent(toVO(serverList));
        pageVO.setTotalElements(serverDAO.pageServersByConsumerTotal(id));
        return ResultUtil.success(pageVO);
    }

    /**
     * 获取闲置设备
     * @return
     */
    @GetMapping("/usable")
    public Result getUsableServers(){
        return ResultUtil.success(toVO(serverDAO.findByIsAllocated(0)));
    }

    /**
     * 为设备添加所有人
     * @param serverList
     * @return
     */
    @PostMapping("/addOwner")
    public Result addOwner(@RequestBody List<Server> serverList){
        for(Server item:serverList){
            item.setIsAllocated(1);
            item.setModifiedDate(new Date());
            serverDAO.save(item);
        }
        return ResultUtil.success();
    }

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
