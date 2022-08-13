package com.lihai.biyesheji.domain;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * 楼栋实体类
 */
@NoArgsConstructor    //无参构造
@AllArgsConstructor  //有参构造
public class Building {

    private Integer buildId;     //楼号
    private Integer communityId;
    private Integer managerId;  //管理员id
    private Integer roomTotal;  //房间总数
    private Integer roomYes;    //已入住
    private Manager manager;     //管理员
    private Community community;


    public Integer getBuildId() {
        return buildId;
    }

    public void setBuildId(Integer buildId) {
        this.buildId = buildId;
    }

    public Integer getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Integer communityId) {
        this.communityId = communityId;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public Integer getRoomTotal() {
        return roomTotal;
    }

    public void setRoomTotal(Integer roomTotal) {
        this.roomTotal = roomTotal;
    }

    public Integer getRoomYes() {
        return roomYes;
    }

    public void setRoomYes(Integer roomYes) {
        this.roomYes = roomYes;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Community getCommunity() {
        return community;
    }

    public void setCommunity(Community community) {
        this.community = community;
    }
}
