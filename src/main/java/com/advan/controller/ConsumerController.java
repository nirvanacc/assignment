package com.advan.controller;

import com.advan.entity.Consumer;
import com.advan.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/list")
    public List<Consumer> getALL(){
        return consumerService.getAll();
    }

}
