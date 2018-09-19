package com.advan.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by haiming.wang on 2018/9/18.
 */
@Entity
public class Admin {

    @Id
    private String id;

    private String name;

    private String password;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
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
}
