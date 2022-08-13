package com.lihai.biyesheji.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * 业主维修统计报表
 *
 */
@NoArgsConstructor
@AllArgsConstructor
public class RepairTotal {

    private Integer rtid;
    private Integer year;
    private Integer month;
    private Integer count;

    public Integer getRtid() {
        return rtid;
    }

    public void setRtid(Integer rtid) {
        this.rtid = rtid;
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
