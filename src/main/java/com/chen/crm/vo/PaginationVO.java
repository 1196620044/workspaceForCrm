package com.chen.crm.vo;

import java.util.List;

/**
 * @Author: 86176
 * @Date: 2020/7/27 02:35
 * @Description:
 */
public class PaginationVO<T> {

    private int total;
    private List<T> dataList;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }
}
