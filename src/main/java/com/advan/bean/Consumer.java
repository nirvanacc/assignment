package com.advan.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by haiming.wang on 2018/9/17.
 */
@Entity
public class Consumer {

    @Id
    private String id;

    private String name;

    private String password;

    private String phone;

    private String email;

    private Long serverNum;

    private String modifiedBy;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date modifiedDate;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public Long getServerNum() {
        return serverNum;
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

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setServerNum(Long serverNum) {
        this.serverNum = serverNum;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}

