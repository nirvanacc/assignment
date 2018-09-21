package com.advan.bean.vo;

import java.util.List;

/**
 * Created by haiming.wang on 2018/9/20.
 */
public class PageVO {

    private List content;

    private Long totalElements;

    public List getContent() {
        return content;
    }

    public Long getTotalElements() {
        return totalElements;
    }

    public void setContent(List content) {
        this.content = content;
    }

    public void setTotalElements(Long totalElements) {
        this.totalElements = totalElements;
    }
}
