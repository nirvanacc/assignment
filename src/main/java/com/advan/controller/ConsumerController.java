package com.advan.controller;

import com.advan.bean.Admin;
import com.advan.bean.Consumer;
import com.advan.bean.Server;
import com.advan.bean.vo.ConsumerVO;
import com.advan.bean.vo.PageVO;
import com.advan.bean.vo.ServerVO;
import com.advan.dao.AdminDAO;
import com.advan.dao.ConsumerDAO;
import com.advan.dao.ServerDAO;
import com.advan.service.ConsumerService;
import com.advan.utils.result.Result;
import com.advan.utils.result.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by haiming.wang on 2018/9/17.
 */
@RestController
@RequestMapping("consumer")
public class ConsumerController {

    @Autowired
    ConsumerDAO consumerDAO;
    @Autowired
    ServerDAO serverDAO;
    @Autowired
    AdminDAO adminDAO;
    @Autowired
    ConsumerService consumerService;
    @Autowired
    ServerController serverController;

    /**
     * 普通用户登录
     * @param consumer
     * @return
     */
    @PostMapping("/login")
    public Result login(@RequestBody Consumer consumer){ // 通过前台验证，consumer必有nameh和password
        Result result = new Result();
        List<Consumer> consumerList = consumerDAO.findByName(consumer.getName());
        if(consumerList == null || consumerList.size() == 0) {
            result =  ResultUtil.error(101, "用户名不存在");
        } else {
            for(Consumer item:consumerList){
                if(item.getPassword().equals(consumer.getPassword())){
                    result = ResultUtil.success(item);
                } else {
                    result = ResultUtil.error(102, "用户名或密码错误");
                }
            }
        }
        return result;
    }

    /**
     * 用户name模糊查询
     * @param para
     * @return
     */
    @GetMapping("/fuzzy")
    public Result fuzzy(String para){
        para = "%"+para+"%";
        return ResultUtil.success(consumerDAO.findByNameLike(para));
    }

    /**
     * 分页查询用户
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/pageAll")
    public Result getAll(Integer page, Integer size){
        Page<Consumer> data = consumerService.pageAll(page, size);
        for(Consumer item:data.getContent()){
            item.setServerNum(serverDAO.pageServersByConsumerTotal(item.getId()));
        }
        PageVO pageVO = new PageVO();
        pageVO.setContent(toVO(data.getContent()));
        pageVO.setTotalElements(data.getTotalElements());
        return ResultUtil.success(pageVO);
    }

    /**
     * 添加/更新用户信息
     * @param consumer
     * @return
     */
    @PostMapping("/update")
    public Result update(@RequestBody Consumer consumer){
        if(consumer.getId() == null){
            consumer.setId(UUID.randomUUID().toString());
            consumer.setPassword("123");
        }
        consumer.setModifiedDate(new Date());
        consumerDAO.save(consumer);
        return ResultUtil.success();
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @GetMapping("/delete")
    public Result delete(String id){
        consumerDAO.delete(id);
        return ResultUtil.success();
    }

    /**
     * 类型转换
     * @param consumerList
     * @return
     */
    public List<ConsumerVO> toVO(List<Consumer> consumerList){
        List<ConsumerVO> consumerVOList = new ArrayList<>();
        for(Consumer item:consumerList){
            ConsumerVO consumerVO = new ConsumerVO();
            consumerVO.setId(item.getId());
            consumerVO.setName(item.getName());
            consumerVO.setPassword(item.getPassword());
            consumerVO.setPhone(item.getPhone());
            consumerVO.setEmail(item.getEmail());
            consumerVO.setServerNum(item.getServerNum());

            List<Server> serverList = serverDAO.findByOwner(item.getId());
            List<ServerVO> serverVOList = serverController.toVO(serverList);
            consumerVO.setServerVOList(serverVOList);

            consumerVO.setModifiedBy(item.getModifiedBy());
            consumerVO.setModifiedByText(adminDAO.findOne(item.getModifiedBy()).getName());

            consumerVO.setModifiedDate(item.getModifiedDate());
            consumerVOList.add(consumerVO);
        }
        return consumerVOList;
    }


}
