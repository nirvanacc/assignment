package com.advan.controller;

import com.advan.dao.MessageDAO;
import com.advan.utils.result.Result;
import com.advan.utils.result.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by haiming.wang on 2018/9/21.
 */
@RestController
@RequestMapping("message")
public class MessageController {

    @Autowired
    MessageDAO messageDAO;

    @GetMapping("/getByConsumer")
    public Result getMyMessage(String id){
        return ResultUtil.success(messageDAO.getByReceiverOrderByPostDateDesc(id));
    }

    @GetMapping("/delete")
    public Result delete(String id){
        messageDAO.delete(id);
        return ResultUtil.success();
    }

}
