package com.lihai.biyesheji.service;

import com.lihai.biyesheji.domain.Event;

import java.util.List;

public interface EventService {

    // 条件查询
    List<Event> findall(String search);
    //新增突发事件
    boolean insertEvent(Event event);
    // 根据id删除突发事件
    boolean deleteEvent(Integer eventId);
    //更新突发事件
    boolean updateEvent(Event event);

}
