package com.lihai.biyesheji.domain;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * 业主维修统计报表
 *
 */
@NoArgsConstructor
@AllArgsConstructor
public class RepairgTotal {

    private Integer rgtid;
    private Integer year;
    private Integer month;
    private Integer count;

    public Integer getRtid() {
        return rgtid;
    }

    public void setRtid(Integer rtid) {
        this.rgtid = rtid;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

}

