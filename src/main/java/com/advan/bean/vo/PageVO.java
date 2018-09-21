package com.advan.bean.vo;

import java.util.List;

/**
 * Created by haiming.wang on 2018/9/20.
 */
public class PageVO {

    private List<ServerVO> content;

    private boolean first;

    private boolean last;

    private Integer totalPages;

    private Long totalElements;

    private Integer number;

    private Integer numberOfElements;

    private Integer size;

    private boolean sort;

    public List<ServerVO> getContent() {
        return content;
    }

    public boolean isFirst() {
        return first;
    }

    public boolean isLast() {
        return last;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public Long getTotalElements() {
        return totalElements;
    }

    public Integer getNumber() {
        return number;
    }

    public Integer getNumberOfElements() {
        return numberOfElements;
    }

    public Integer getSize() {
        return size;
    }

    public boolean isSort() {
        return sort;
    }

    public void setContent(List<ServerVO> content) {
        this.content = content;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    public void setLast(boolean last) {
        this.last = last;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public void setTotalElements(Long totalElements) {
        this.totalElements = totalElements;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setNumberOfElements(Integer numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public void setSort(boolean sort) {
        this.sort = sort;
    }
}
