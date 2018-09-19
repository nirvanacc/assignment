package com.advan.controller;

import com.advan.bean.Consumer;
import com.advan.bean.Server;
import com.advan.bean.vo.ServerVO;
import com.advan.dao.ConsumerDAO;
import com.advan.dao.ServerDAO;
import com.advan.service.ServerService;
import com.advan.service.impl.ServerServiceImpl;
import com.advan.utils.result.Result;
import com.advan.utils.result.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by haiming.wang on 2018/9/18.
 */
@RestController
@RequestMapping("server")
public class ServerController {

    @Autowired
    ServerDAO serverDAO;
    @Autowired
    ConsumerDAO consumerDAO;

    private ServerServiceImpl util;

    /**
     * 获取所有服务器信息
     * @return
     */
    @GetMapping("/list")
    public Result getAll(){
//        return ResultUtil.success(util.toVO(serverDAO.findAll()));
        return ResultUtil.success(serverDAO.findAll());
    }

    /**
     * 通过id获取服务器
     * @param id
     * @return
     */
    @GetMapping("/get")
    public Result getById(String id){
        return ResultUtil.success(consumerDAO.findOne(id));
    }

    /**
     * 添加服务器
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

//    /**
//     * 更新服务器信息
//     * @param server
//     * @return
//     */
//    @PostMapping("/update")
//    public Result update(@RequestBody Server server){
//        server.setModifiedDate(new Date());
//        serverDAO.save(server);
//        return ResultUtil.success();
//    }

    /**
     * 通过id删除服务器
     * @param id
     * @return
     */
    @PostMapping("/delete")
    public Result delete(String id){
        serverDAO.delete(id);
        return ResultUtil.success();
    }

    @PostMapping("/deleteBatch")
    public Result deleteBatch(@RequestBody List<ServerVO> serverVOList){
        for(ServerVO item:serverVOList){
            delete(item.getId());
        }
        return ResultUtil.success();
    }

    @GetMapping("/fuzzy")
    public Result fuzzySearch(String para){
        para = "%"+para+"%";
        List<Server> allServers = new ArrayList<>();
        List<Server> serverListByName = serverDAO.findByNameLike(para);
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
        ServerServiceImpl util = new ServerServiceImpl();
        return ResultUtil.success(util.toVO(allServers));
    }
}
