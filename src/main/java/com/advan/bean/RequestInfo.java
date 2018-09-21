package com.advan.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by haiming.wang on 2018/9/21.
 */
@Entity
public class RequestInfo {
    @Id
    private String id;

    private String applicant;

    private String detail;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date requestDate;

    private String operator;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date operateDate;

    private Integer state; // 0待处理 1驳回 2已处理

    public String getId() {
        return id;
    }

    public String getApplicant() {
        return applicant;
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

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public Date getOperateDate() {
        return operateDate;
    }

    public Integer getState() {
        return state;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
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

    public void setOperateDate(Date operateDate) {
        this.operateDate = operateDate;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
