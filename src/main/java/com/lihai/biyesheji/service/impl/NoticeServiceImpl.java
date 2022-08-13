package com.lihai.biyesheji.service.impl;

import com.lihai.biyesheji.domain.Notice;
import com.lihai.biyesheji.mapper.NoticeMapper;
import com.lihai.biyesheji.service.NoticeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {
    @Resource
    private NoticeMapper noticeMapper;

    // 条件查询
    @Override
    public List<Notice> findall(String search) {
        List<Notice> findall = noticeMapper.findall(search);
        return findall;
    }

    //新增一个公告
    @Override
    public boolean insertNotice(Notice notice) {
        boolean b = noticeMapper.insertNotice(notice);
        return b;
    }
    // 根据id删除公告
    @Override
    public boolean deleteNotice(Integer noticeId) {
        boolean b = noticeMapper.deleteNotice(noticeId);
        return b;
    }
    //更新公告
    @Override
    public boolean updateNotice(Notice notice) {
        boolean b = noticeMapper.updateNotice(notice);
        return b;
    }
}
