package com.advan.controller;

import com.advan.bean.Consumer;
import com.advan.dao.ConsumerDAO;
import com.advan.dao.ServerDAO;
import com.advan.service.ConsumerService;
import com.advan.utils.result.Result;
import com.advan.utils.result.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by haiming.wang on 2018/9/17.
 */
@RestController
@RequestMapping("consumer")
public class ConsumerController {

    @Autowired
    ConsumerDAO consumerDAO;

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


}
