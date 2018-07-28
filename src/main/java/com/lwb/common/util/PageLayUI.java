package com.lwb.common.util;

import java.util.List;


/**
 * 针对layui分页返回值
 */
public class PageLayUI<T> {
    private int code; //返回状态码
    private String msg; //返回信息
    private int count; //返回行数
    private List data; // 返回数据列表

    public PageLayUI(){}

    public PageLayUI(Page page){
        data = page.getRecords();
        count = page.getTotal();
        code = 0;
        msg="";
    }

    public PageLayUI(int count,List data){
        data = data;
        count = count;
        code = 0;
        msg="";
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }
}
