package com.advan.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by haiming.wang on 2018/9/18.
 */
@Entity
public class Server {

    @Id
    private String id;

    private String name;

    private String os;

    // 服务器运行状态，0正常，1异常
    private Integer runningState;

    // 是否已被分配，0未分配，1已分配
    private Integer isAllocated;

    private String owner;

    private String modifiedBy;

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

    public Integer getRunningState() {
        return runningState;
    }

    public Integer getIsAllocated() {
        return isAllocated;
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

    public void setRunningState(Integer runningState) {
        this.runningState = runningState;
    }

    public void setIsAllocated(Integer isAllocated) {
        this.isAllocated = isAllocated;
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
}
