package com.lihai.biyesheji.domain;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * 收入实体类
 */
@NoArgsConstructor    //无参构造
@AllArgsConstructor  //有参构造
public class Money {
    private Integer mid;
    private Integer year;
    private Integer month;
    private Double money;

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
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

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
}
