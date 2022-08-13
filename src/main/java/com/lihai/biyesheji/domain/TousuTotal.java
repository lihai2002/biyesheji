package com.lihai.biyesheji.domain;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * 投诉统计报表实体类
 */
@NoArgsConstructor    //无参构造
@AllArgsConstructor  //有参构造

public class TousuTotal {
    private Integer ttid;
    private Integer year;
    private Integer month;
    private Integer count;

    public Integer getTtid() {
        return ttid;
    }

    public void setTtid(Integer ttid) {
        this.ttid = ttid;
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
