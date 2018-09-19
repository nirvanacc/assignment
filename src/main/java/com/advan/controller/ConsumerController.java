package com.advan.controller;

import com.advan.bean.Consumer;
import com.advan.service.ConsumerService;
import com.advan.utils.result.Result;
import com.advan.utils.result.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by haiming.wang on 2018/9/17.
 */
@RestController
@RequestMapping("user")
public class ConsumerController {

    @Autowired
    ConsumerService consumerService;

    /**
     * 普通用户登录
     * @param consumer
     * @return
     */
    @PostMapping("/login")
    public Result login(Consumer consumer){ // 通过前台验证，consumer必有nameh和password
        Result result = new Result();
        List<Consumer> consumerList = consumerService.getByName(consumer.getName());
        if(consumerList == null || consumerList.size() == 0) {
            result =  ResultUtil.error(777, "用户名不存在");
        } else {
            for(Consumer item:consumerList){
                if(item.getPassword().equals(consumer.getPassword())){
                    result = ResultUtil.success(item);
                } else {
                    result = ResultUtil.error(778, "用户名或密码错误");
                }
            }
        }
        return result;
    }

    @GetMapping("/list")
    public Result getAll(){
        return ResultUtil.success(consumerService.getAll());
    }

}
