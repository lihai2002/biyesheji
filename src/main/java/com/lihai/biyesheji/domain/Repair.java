package com.lihai.biyesheji.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.sql.Date;

/**
 * 业主维修实体类
 */
@NoArgsConstructor    //无参构造
@AllArgsConstructor  //有参构造

public class Repair {
    private Integer repairId;           //id
    private Integer uid;                //报修用户
    private String repairMain;         //维修内容
    private Date repairTime;         //报修时间
    private String repairState;        //维修状态
    private String repairName;       //维修人员姓名
    private String repairPhone;     //维修人员电话
    private String repairRemark;    //维修评价
    private Double money;

    private User user;


    public Integer getRepairId() {
        return repairId;
    }

    public void setRepairId(Integer repairId) {
        this.repairId = repairId;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getRepairMain() {
        return repairMain;
    }

    public void setRepairMain(String repairMain) {
        this.repairMain = repairMain;
    }

    public Date getRepairTime() {
        return repairTime;
    }

    public void setRepairTime(Date repairTime) {
        this.repairTime = repairTime;
    }

    public String getRepairState() {
        return repairState;
    }

    public void setRepairState(String repairState) {
        this.repairState = repairState;
    }

    public String getRepairName() {
        return repairName;
    }

    public void setRepairName(String repairName) {
        this.repairName = repairName;
    }

    public String getRepairPhone() {
        return repairPhone;
    }

    public void setRepairPhone(String repairPhone) {
        this.repairPhone = repairPhone;
    }

    public String getRepairRemark() {
        return repairRemark;
    }

    public void setRepairRemark(String repairRemark) {
        this.repairRemark = repairRemark;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
