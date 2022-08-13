package com.lihai.biyesheji.mapper;

import com.lihai.biyesheji.domain.Notice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeMapper {

    // 条件查询
    List<Notice> findall(String search);
    //新增一个公告
    boolean insertNotice(Notice notice);
    // 根据id删除公告
    boolean deleteNotice(Integer noticeId);
    //更新公告
    boolean updateNotice(Notice notice);


    // 条件查询
    List<Notice> findallApp();


}
