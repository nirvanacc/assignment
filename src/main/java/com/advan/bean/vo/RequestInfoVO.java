package com.advan.bean.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by haiming.wang on 2018/9/21.
 */
public class RequestInfoVO {

    private String id;

    private String applicant;

    private String applicantText;

    private String detail;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date requestDate;

    private String operator;

    private String operatorText;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date operateDate;

    private Integer state; // 0待处理 1驳回 2已处理

    private String stateText;

    public String getId() {
        return id;
    }

    public String getApplicant() {
        return applicant;
    }

    public String getApplicantText() {
        return applicantText;
    }

    public String getDetail() {
        return detail;
    }

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public Date getRequestDate() {
        return requestDate;
    }

    public String getOperator() {
        return operator;
    }

    public String getOperatorText() {
        return operatorText;
    }

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public Date getOperateDate() {
        return operateDate;
    }

    public Integer getState() {
        return state;
    }

    public String getStateText() {
        return stateText;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public void setApplicantText(String applicantText) {
        this.applicantText = applicantText;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public void setOperatorText(String operatorText) {
        this.operatorText = operatorText;
    }

    public void setOperateDate(Date operateDate) {
        this.operateDate = operateDate;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public void setStateText(String stateText) {
        this.stateText = stateText;
    }
}
