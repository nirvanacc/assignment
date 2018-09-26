package com.advan.controller;

import com.advan.bean.Admin;
import com.advan.dao.AdminDAO;
import com.advan.service.AdminService;
import com.advan.utils.result.Result;
import com.advan.utils.result.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Created by haiming.wang on 2018/9/18.
 */
@RestController
@RequestMapping("admin")
public class AdminController {

    @Autowired
    AdminDAO adminDAO;

    /**
     * 管理员登录
     * @param admin
     * @return
     */
    @PostMapping("/login")
    public Result login(@RequestBody Admin admin){ // 通过前台验证，admin必有nameh和password
        Result result = new Result();
        List<Admin> adminList = adminDAO.findByName(admin.getName());
        if(adminList == null || adminList.size() == 0) {
            result =  ResultUtil.error(101, "用户名不存在");
        } else {
            for(Admin item:adminList){
                if(item.getPassword().equals(admin.getPassword())){
                    result = ResultUtil.success(item);
                } else {
                    result = ResultUtil.error(102, "用户名或密码错误");
                }
            }
        }
        return result;
    }

    /**
     * 添加管理员
     * @param admin
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody Admin admin){
        admin.setId(UUID.randomUUID().toString());
        adminDAO.save(admin);
        return ResultUtil.success();
    }





}
