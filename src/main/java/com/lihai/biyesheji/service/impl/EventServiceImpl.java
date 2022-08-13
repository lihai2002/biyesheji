package com.lihai.biyesheji.service.impl;

import com.lihai.biyesheji.domain.Event;
import com.lihai.biyesheji.mapper.EventMapper;
import com.lihai.biyesheji.service.EventService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    @Resource
    private EventMapper eventMapper;

    // 条件查询
    @Override
    public List<Event> findall(String search) {
        List<Event> findall = eventMapper.findall(search);
        return findall;
    }
    //新增突发事件
    @Override
    public boolean insertEvent(Event event) {
        boolean b = eventMapper.insertEvent(event);
        return b;
    }

    // 根据id删除突发事件
    @Override
    public boolean deleteEvent(Integer eventId) {
        boolean b = eventMapper.deleteEvent(eventId);
        return b;
    }
    //更新突发事件
    @Override
    public boolean updateEvent(Event event) {
        boolean b = eventMapper.updateEvent(event);
        return b;
    }

}
