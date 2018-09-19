package com.advan.bean.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by haiming.wang on 2018/9/18.
 */
public class ServerVO {

    private String id;

    private String name;

    private String os;

    private Integer runningState;

    private String runningStateText;

    private Integer isAllocated;

    private String isAllocatedText;

    private String owner;

    private String ownerText;

    private String modifiedBy;

    private String modifiedByText;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date modifiedDate;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOs() {
        return os;
    }

    public String getOwner() {
        return owner;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public void setOwnerText(String ownerText) {
        this.ownerText = ownerText;
    }

    public void setModifiedByText(String modifiedByText) {
        this.modifiedByText = modifiedByText;
    }

    public String getOwnerText() {

        return ownerText;
    }

    public String getModifiedByText() {
        return modifiedByText;
    }

    public Integer getRunningState() {
        return runningState;
    }

    public String getRunningStateText() {
        return runningStateText;
    }

    public Integer getIsAllocated() {
        return isAllocated;
    }

    public String getIsAllocatedText() {
        return isAllocatedText;
    }

    public void setRunningState(Integer runningState) {
        this.runningState = runningState;
    }

    public void setRunningStateText(String runningStateText) {
        this.runningStateText = runningStateText;
    }

    public void setIsAllocated(Integer isAllocated) {
        this.isAllocated = isAllocated;
    }

    public void setIsAllocatedText(String isAllocatedText) {
        this.isAllocatedText = isAllocatedText;
    }
}
