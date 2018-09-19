package com.advan.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

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

}

