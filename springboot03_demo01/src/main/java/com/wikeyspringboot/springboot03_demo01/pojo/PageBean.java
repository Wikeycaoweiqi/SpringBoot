package com.wikeyspringboot.springboot03_demo01.pojo;

import java.util.List;

/**
 * @author: wikey
 * @create: 2024-07-23 23:16
 * @Description:
 */
public class PageBean<T> {
    private Long total;
    private List<T> items;

    public PageBean() {
    }

    public PageBean(Long total, List<T> items) {
        this.total = total;
        this.items = items;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "total=" + total +
                ", items=" + items +
                '}';
    }
}