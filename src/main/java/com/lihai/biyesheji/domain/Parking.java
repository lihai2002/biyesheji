package com.lihai.biyesheji.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * 停车位实体类
 */

@NoArgsConstructor    //无参构造
@AllArgsConstructor  //有参构造
public class Parking {
    private Integer pid;        //
    private String parkingId;   //车位编号
    private Integer uid;        //车位主人
    private String parkingAddr;     //车位地址

    private User user;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getParkingId() {
        return parkingId;
    }

    public void setParkingId(String parkingId) {
        this.parkingId = parkingId;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getParkingAddr() {
        return parkingAddr;
    }

    public void setParkingAddr(String parkingAddr) {
        this.parkingAddr = parkingAddr;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
