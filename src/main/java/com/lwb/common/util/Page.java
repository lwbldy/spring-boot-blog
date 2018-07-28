package com.lwb.common.util;

import java.util.List;
import java.util.Map;

/**
 * 实现分页辅助类
 * @param <T>
 */
public class Page<T> {

    /**
     * 总页数
     */
    private int pages;

    /**
     * 每页显示条数，默认 10
     */
    private int size = 10;

    /**
     * 总数
     */
    private int total;

    /**
     * 当前页
     */
    private int current = 1;

    /**
     * 查询数据列表
     */
    private List<T> records =null;

    /**
     * 查询参数
     */
    private Map<String, Object> condition;

    /**
     * 分页起始行
     */
    private int offset;
    // 每页显示多少数据
    private int limit;
    //排序
    private String sort;

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }


    public int getOffset() {
        return (current-1) * size;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return size;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getPages() {
        return (total + size - 1) / size;
    }

//    public void setPages(int pages) {
//        this.pages = pages;
//    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }

    public Map<String, Object> getCondition() {
        return condition;
    }

    public void setCondition(Map<String, Object> condition) {
        this.condition = condition;
    }
}
