package com.lihai.biyesheji.controller;

import com.lihai.biyesheji.common.Result;
import com.lihai.biyesheji.domain.Event;
import com.lihai.biyesheji.service.EventService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/event")
public class  EventController {

    @Resource
    private EventService eventService;

    //    查询
    @GetMapping("/find")
    public Result<?> find(@RequestParam String search){
        List<Event> findall = eventService.findall(search);
        return Result.success(findall);
    }

    //    新增
    @PostMapping("/add")
    public Result<?> insert(@RequestBody Event event){
        boolean a = eventService.insertEvent(event);
        if (a) {
            return Result.success();
        }else {
            return Result.error(-1,"新增失败");
        }
    }

    //    删除
    @DeleteMapping("/delete")
    public Result<?> delete(@RequestParam(value="eventId") Integer eventId){
        boolean a = eventService.deleteEvent(eventId);
        if (a) {
            return Result.success();
        }else {
            return Result.error(-1,"删除失败");
        }
    }


    //    更新
    @PutMapping("/update")
    public Result<?> update(@RequestBody Event event){
        boolean a = eventService.updateEvent(event);
        if (a){
            return Result.success();
        }
        return Result.error(-1,"更新失败");
    }
}
