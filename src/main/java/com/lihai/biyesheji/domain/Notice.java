package com.lihai.biyesheji.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.sql.Date;

/**
 * 公告实体类
 */

@NoArgsConstructor    //无参构造
@AllArgsConstructor  //有参构造
public class Notice {

    private Integer noticeId;
    private String noticeName;      //公告标题
    private String noticeMain;
    private Date noticeTime;

    public Integer getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(Integer noticeId) {
        this.noticeId = noticeId;
    }

    public String getNoticeName() {
        return noticeName;
    }

    public void setNoticeName(String noticeName) {
        this.noticeName = noticeName;
    }

    public String getNoticeMain() {
        return noticeMain;
    }

    public void setNoticeMain(String noticeMain) {
        this.noticeMain = noticeMain;
    }

    public Date getNoticeTime() {
        return noticeTime;
    }

    public void setNoticeTime(Date noticeTime) {
        this.noticeTime = noticeTime;
    }


}
