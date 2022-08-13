package com.lihai.biyesheji.controller;

import com.lihai.biyesheji.common.Result;
import com.lihai.biyesheji.domain.Notice;
import com.lihai.biyesheji.mapper.NoticeMapper;
import com.lihai.biyesheji.service.NoticeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/notice")
public class NoticeController {

    @Resource
    private NoticeService noticeService;
    @Resource
    private NoticeMapper noticeMapper;

    //    查询
    @GetMapping("/find")
    public Result<?> find(@RequestParam String search){
        List<Notice> findall = noticeService.findall(search);
        return Result.success(findall);
    }

    //    新增
    @PostMapping("/add")
    public Result<?> insert(@RequestBody Notice notice){
        boolean a = noticeService.insertNotice(notice);
        if (a) {
            return Result.success();
        }else {
            return Result.error(-1,"新增失败");
        }
    }

    //    删除
    @DeleteMapping("/delete")
    public Result<?> delete(@RequestParam(value="noticeId") Integer noticeId){
        boolean a = noticeService.deleteNotice(noticeId);
        if (a) {
            return Result.success();
        }else {
            return Result.error(-1,"删除失败");
        }
    }


    //    更新
    @PutMapping("/update")
    public Result<?> update(@RequestBody Notice notice){
        boolean a = noticeService.updateNotice(notice);
        if (a){
            return Result.success();
        }
        return Result.error(-1,"更新失败");
    }





    //    App显示全部公告
    @GetMapping("/findApp")
    public Result<?> findApp(){
        List<Notice> findall = noticeMapper.findallApp();
        return Result.success(findall);
    }

}
