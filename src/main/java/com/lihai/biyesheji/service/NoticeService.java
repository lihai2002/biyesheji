package com.lihai.biyesheji.service;

import com.lihai.biyesheji.domain.Notice;


import java.util.List;

public interface NoticeService {
    // 条件查询
    List<Notice> findall(String search);
    //新增一个公告
    boolean insertNotice(Notice notice);
    // 根据id删除公告
    boolean deleteNotice(Integer noticeId);
    //更新公告
    boolean updateNotice(Notice notice);

}
