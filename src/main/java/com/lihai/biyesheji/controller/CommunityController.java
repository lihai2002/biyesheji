package com.lihai.biyesheji.controller;

import com.lihai.biyesheji.common.Result;
import com.lihai.biyesheji.domain.Community;
import com.lihai.biyesheji.service.CommunityService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/community")
public class CommunityController {
    @Resource
    private CommunityService communityService;

//    查找所有小区
    @GetMapping("/findall")
    public Result<?> findall(){
        List<Community> findall = communityService.findall();
        return Result.success(findall);
    }
    //    更新小区资料
    @PutMapping("/update")
    public  Result<?> update(@RequestBody Community community){
        boolean update = communityService.update(community);
        if (update){
            return Result.success();
        }else {
            return Result.error(-1,"更新失败");
        }
    }

    //    删除小区
    @DeleteMapping("/delete")
    public Result<?> delete(@RequestParam("communityId") Integer communityId){
        boolean delete = communityService.delete(communityId);
        if (delete){
            return Result.success();
        }else {
            return Result.error(-1,"删除失败");
        }
    }



}
