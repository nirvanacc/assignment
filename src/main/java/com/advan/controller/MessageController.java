package com.advan.controller;

import com.advan.bean.Message;
import com.advan.dao.MessageDAO;
import com.advan.utils.result.Result;
import com.advan.utils.result.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;

/**
 * Created by haiming.wang on 2018/9/21.
 */
@RestController
@RequestMapping("message")
public class MessageController {

    @Autowired
    MessageDAO messageDAO;

    /**
     * 获取用户消息
     * @param id
     * @return
     */
    @GetMapping("/getByConsumer")
    public Result getMyMessage(String id){
        return ResultUtil.success(messageDAO.getByReceiverOrderByPostDateDesc(id));
    }

    /**
     * 删除消息
     * @param id
     * @return
     */
    @GetMapping("/delete")
    public Result delete(String id){
        messageDAO.delete(id);
        return ResultUtil.success();
    }

    /**
     * 添加消息
     * @param message
     * @return
     */
    @PostMapping("/update")
    public Result update(@RequestBody Message message){
        message.setId(UUID.randomUUID().toString());
        message.setPostDate(new Date());
        messageDAO.save(message);
        return ResultUtil.success();
    }

}
