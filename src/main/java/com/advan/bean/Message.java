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
public class Message {

    @Id
    private String id;

    private String receiver;

    private String text;

    private String poster;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date postDate;

    public String getId() {
        return id;
    }

    public String getReceiver() {
        return receiver;
    }

    public String getPoster() {
        return poster;
    }

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public Date getPostDate() {
        return postDate;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
