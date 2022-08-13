package com.lihai.biyesheji.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.sql.Date;

/**
 * 突发事件实体类
 */

@NoArgsConstructor    //无参构造
@AllArgsConstructor  //有参构造

public class Event {
    private Integer eventId;        //事件id
    private String eventName;       //事件标题
    private String eventMain;       //事件内容
    private Date eventTime;         //发生时间
    private String eventChuli;      //处理措施

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventMain() {
        return eventMain;
    }

    public void setEventMain(String eventMain) {
        this.eventMain = eventMain;
    }

    public Date getEventTime() {
        return eventTime;
    }

    public void setEventTime(Date eventTime) {
        this.eventTime = eventTime;
    }

    public String getEventChuli() {
        return eventChuli;
    }

    public void setEventChuli(String eventChuli) {
        this.eventChuli = eventChuli;
    }
}
