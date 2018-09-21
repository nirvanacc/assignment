package com.advan.controller;

import com.advan.bean.RequestInfo;
import com.advan.bean.Server;
import com.advan.bean.vo.PageVO;
import com.advan.service.RequestInfoService;
import com.advan.utils.result.Result;
import com.advan.utils.result.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * Created by haiming.wang on 2018/9/21.
 */
@RestController
@RequestMapping("requestInfo")
public class RequestInfoController {

    @Autowired
    RequestInfoService requestInfoService;

    /**
     * 所有服务器分页
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/pageAll")
    public Result pageAllRequest(Integer page, Integer size){
        PageVO pageVO = new PageVO();
        Page<RequestInfo> requestInfoPage = requestInfoService.pageAll(page, size);
//        pageVO.setContent(toVO(serverPage.getContent()));
//        pageVO.setFirst(serverPage.isFirst());
//        pageVO.setLast(serverPage.isLast());
//        pageVO.setTotalElements(serverPage.getTotalElements());
//        pageVO.setSize(serverPage.getSize());
//        pageVO.setTotalPages(serverPage.getTotalPages());
//        pageVO.setNumber(serverPage.getNumber());
//        pageVO.setNumberOfElements(serverPage.getNumberOfElements());
        return ResultUtil.success(requestInfoPage);
    }

    @PostMapping("/add")
    public Result add(@RequestBody RequestInfo requestInfo){
        requestInfoService.add(requestInfo);
        return ResultUtil.success();
    }
}
