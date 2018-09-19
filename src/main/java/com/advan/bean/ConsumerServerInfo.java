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
public class ConsumerServerInfo {

    @Id
    private String id;

    private String consumerId;

    private String serverId;

    private String allocatedBy;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date allocatedDate;

    public String getId() {
        return id;
    }

    public String getConsumerId() {
        return consumerId;
    }

    public String getServerId() {
        return serverId;
    }

    public String getAllocatedBy() {
        return allocatedBy;
    }

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public Date getAllocatedDate() {
        return allocatedDate;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setConsumerId(String consumerId) {
        this.consumerId = consumerId;
    }

    public void setServerId(String serverId) {
        this.serverId = serverId;
    }

    public void setAllocatedBy(String allocatedBy) {
        this.allocatedBy = allocatedBy;
    }

    public void setAllocatedDate(Date allocatedDate) {
        this.allocatedDate = allocatedDate;
    }
}
