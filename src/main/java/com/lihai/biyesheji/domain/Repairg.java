package com.lihai.biyesheji.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.sql.Date;

/**
 * 公共维修实体类
 */
@NoArgsConstructor    //无参构造
@AllArgsConstructor  //有参构造

public class Repairg {
    private Integer repairgId;           //id
    private String repairgMain;         //维修内容
    private String repairgState;        //维修状态
    private String repairgName;       //维修人员姓名
    private String repairgPhone;     //维修人员电话
    private Double money;
    private Date repairgTime;       //维修时间

    public Integer getRepairgId() {
        return repairgId;
    }

    public void setRepairgId(Integer repairgId) {
        this.repairgId = repairgId;
    }

    public String getRepairgMain() {
        return repairgMain;
    }

    public void setRepairgMain(String repairgMain) {
        this.repairgMain = repairgMain;
    }

    public String getRepairgState() {
        return repairgState;
    }

    public void setRepairgState(String repairgState) {
        this.repairgState = repairgState;
    }

    public String getRepairgName() {
        return repairgName;
    }

    public void setRepairgName(String repairgName) {
        this.repairgName = repairgName;
    }

    public String getRepairgPhone() {
        return repairgPhone;
    }

    public void setRepairgPhone(String repairgPhone) {
        this.repairgPhone = repairgPhone;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Date getRepairgTime() {
        return repairgTime;
    }

    public void setRepairgTime(Date repairgTime) {
        this.repairgTime = repairgTime;
    }
}
