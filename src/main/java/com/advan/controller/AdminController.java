package com.advan.controller;

import com.advan.bean.Admin;
import com.advan.service.AdminService;
import com.advan.utils.result.Result;
import com.advan.utils.result.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by haiming.wang on 2018/9/18.
 */
@RestController
@RequestMapping("admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    /**
     * 管理员登录
     * @param admin
     * @return
     */
    @PostMapping("/login")
    public Result login(@RequestBody Admin admin){ // 通过前台验证，admin必有nameh和password
        Result result = new Result();
        List<Admin> adminList = adminService.getByName(admin.getName());
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





}
