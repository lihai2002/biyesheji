package com.lihai.biyesheji.mapper;

import com.lihai.biyesheji.domain.Event;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EventMapper {

    // 条件查询
    List<Event> findall(String search);
    //新增突发事件
    boolean insertEvent(Event event);
    // 根据id删除突发事件
    boolean deleteEvent(Integer eventId);
    //更新突发事件
    boolean updateEvent(Event event);
}
