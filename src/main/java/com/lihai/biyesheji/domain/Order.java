package com.lihai.biyesheji.domain;

import cn.hutool.core.annotation.Alias;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;

/**
 * 账单实体类
 */
@NoArgsConstructor    //无参构造
@AllArgsConstructor  //有参构造
@ToString
public class Order {

    private Integer oid;            //账单号
    private String produceTime;       //产生账单时间
    private String orderName;       //账单类型
    private Integer uid;            //用户ID
    private Double orderMoney;      //费用金额
    private String orderState;      //缴费状态
    private Date payTime;           //用户缴费时间
    private User user;
    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public String getProduceTime() {
        return produceTime;
    }

    public void setProduceTime(String produceTime) {
        this.produceTime = produceTime;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Double getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(Double orderMoney) {
        this.orderMoney = orderMoney;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
