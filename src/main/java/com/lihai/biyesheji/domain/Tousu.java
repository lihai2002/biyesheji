package com.lihai.biyesheji.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.sql.Date;

/**
 * 投诉实体类
 */
@NoArgsConstructor    //无参构造
@AllArgsConstructor  //有参构造

public class Tousu {

    private Integer tid;        //id
    private Integer uid;        //用户ID号
    private String tousuName;   //投诉标题
    private String tousuMain;   //投诉内容
    private Date tousuTime;     //投诉时间
    private String replyState;  //回复状态
    private String tousuReply;  //回复内容
    private Date replyTime;     //回复时间
    private  User user;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getTousuName() {
        return tousuName;
    }

    public void setTousuName(String tousuName) {
        this.tousuName = tousuName;
    }

    public String getTousuMain() {
        return tousuMain;
    }

    public void setTousuMain(String tousuMain) {
        this.tousuMain = tousuMain;
    }

    public Date getTousuTime() {
        return tousuTime;
    }

    public void setTousuTime(Date tousuTime) {
        this.tousuTime = tousuTime;
    }

    public String getReplyState() {
        return replyState;
    }

    public void setReplyState(String replyState) {
        this.replyState = replyState;
    }

    public String getTousuReply() {
        return tousuReply;
    }

    public void setTousuReply(String tousuReply) {
        this.tousuReply = tousuReply;
    }

    public Date getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
