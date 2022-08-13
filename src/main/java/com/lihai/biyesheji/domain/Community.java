package com.lihai.biyesheji.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor    //无参构造
@AllArgsConstructor  //有参构造
public class Community {

    private Integer communityId;
    private String communityName;
    private String communityAddr;
    private Double communityArea;
    private Integer buildingTotal;  //楼栋数量
    private Integer userTotal;      //用户数量
    private String developer; //开发商
    private String wuye;        //物业公司
    private String state;       //状态

    public Integer getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Integer communityId) {
        this.communityId = communityId;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public String getCommunityAddr() {
        return communityAddr;
    }

    public void setCommunityAddr(String communityAddr) {
        this.communityAddr = communityAddr;
    }

    public Double getCommunityArea() {
        return communityArea;
    }

    public void setCommunityArea(Double communityArea) {
        this.communityArea = communityArea;
    }

    public Integer getBuildingTotal() {
        return buildingTotal;
    }

    public void setBuildingTotal(Integer buildingTotal) {
        this.buildingTotal = buildingTotal;
    }

    public Integer getUserTotal() {
        return userTotal;
    }

    public void setUserTotal(Integer userTotal) {
        this.userTotal = userTotal;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getWuye() {
        return wuye;
    }

    public void setWuye(String wuye) {
        this.wuye = wuye;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
