package com.advan.controller;

import com.advan.bean.Admin;
import com.advan.bean.RequestInfo;
import com.advan.bean.Server;
import com.advan.bean.vo.PageVO;
import com.advan.bean.vo.RequestInfoVO;
import com.advan.bean.vo.ServerVO;
import com.advan.dao.AdminDAO;
import com.advan.dao.ConsumerDAO;
import com.advan.dao.RequestInfoDAO;
import com.advan.service.RequestInfoService;
import com.advan.utils.result.Result;
import com.advan.utils.result.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by haiming.wang on 2018/9/21.
 */
@RestController
@RequestMapping("requestInfo")
public class RequestInfoController {

    @Autowired
    RequestInfoService requestInfoService;
    @Autowired
    RequestInfoDAO requestInfoDAO;
    @Autowired
    ConsumerDAO consumerDAO;
    @Autowired
    AdminDAO adminDAO;

    /**
     * 所有服务器分页
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/pageUnsloved")
    public Result pageUnsloved(Integer page, Integer size){
        PageVO pageVO = new PageVO();
        pageVO.setContent(toVO(requestInfoDAO.pageRequestUnsolved((page-1)*size, size)));
        pageVO.setTotalElements(requestInfoDAO.unsolvedTotal());
        return ResultUtil.success(pageVO);
    }

    @GetMapping("/pageHis")
    public Result pageHis(Integer page, Integer size){
        PageVO pageVO = new PageVO();
        pageVO.setContent(toVO(requestInfoDAO.pageHisRequest((page-1)*size, size)));
        pageVO.setTotalElements(requestInfoDAO.hisTotal());
        return ResultUtil.success(pageVO);
    }

    @PostMapping("/add")
    public Result add(@RequestBody RequestInfo requestInfo){
        requestInfoService.add(requestInfo);
        return ResultUtil.success();
    }

    @PostMapping("/update")
    public Result update(@RequestBody RequestInfo requestInfo){
        requestInfo.setOperateDate(new Date());
        requestInfoDAO.save(requestInfo);
        return ResultUtil.success();
    }

    @GetMapping("/delete")
    public Result delete(String id){
        requestInfoDAO.delete(id);
        return ResultUtil.success();
    }

    /**
     * 原始类转换为vo类
     * @param requestInfoList
     * @return
     */
    public List<RequestInfoVO> toVO(List<RequestInfo> requestInfoList){
        List<RequestInfoVO> requestInfoVOList = new ArrayList<>(requestInfoList.size());
        for (RequestInfo item : requestInfoList) {
            RequestInfoVO requestInfoVO = new RequestInfoVO();
            requestInfoVO.setId(item.getId());
            requestInfoVO.setApplicant(item.getApplicant());
            requestInfoVO.setApplicantText(consumerDAO.findOne(item.getApplicant()).getName());
            requestInfoVO.setDetail(item.getDetail());
            requestInfoVO.setRequestDate(item.getRequestDate());
            if(item.getOperator() != null){
                requestInfoVO.setOperator(item.getOperator());
                requestInfoVO.setOperatorText(adminDAO.findOne(item.getOperator()).getName());
                requestInfoVO.setOperateDate(item.getOperateDate());
            }
            requestInfoVO.setState(item.getState());
            if(item.getState() == 0){
                requestInfoVO.setStateText("待处理");
            } else if(item.getState() == 1){
                requestInfoVO.setStateText("驳回");
            } else {
                requestInfoVO.setStateText("已批准");
            }
            requestInfoVOList.add(requestInfoVO);
        }
        return requestInfoVOList;
    }
}
