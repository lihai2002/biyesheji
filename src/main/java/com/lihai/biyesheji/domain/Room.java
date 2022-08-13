package com.lihai.biyesheji.domain;

import cn.hutool.core.annotation.Alias;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 房屋实体类
 */
@NoArgsConstructor    //无参构造
@AllArgsConstructor  //有参构造
@ToString
public class Room {

    private Integer id;          //id
    @Alias("房屋号")   //起别名
    private Integer roomId;     //房屋id
    @Alias("房主Id")
    private Integer uid;         //房屋所属用户
    @Alias("所属楼号")
    private Integer buildId;    //所属楼栋
    @Alias("房屋面积")
    private Integer area;       //房屋面积
    @Alias("入住状态")
    private String state;        //入住状态
    @Alias("常住人数")
    private Integer peopleCount;    //常住人数
    private User user;
    private Building building;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getBuildId() {
        return buildId;
    }

    public void setBuildId(Integer buildId) {
        this.buildId = buildId;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(Integer peopleCount) {
        this.peopleCount = peopleCount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }
}
