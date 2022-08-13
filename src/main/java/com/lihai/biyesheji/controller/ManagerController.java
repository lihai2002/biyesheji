package com.lihai.biyesheji.controller;


import com.lihai.biyesheji.common.Result;
import com.lihai.biyesheji.domain.Manager;
import com.lihai.biyesheji.service.ManagerService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/manager")
public class ManagerController {

    @Resource
    private ManagerService managerService;

//    管理员登录
    @PostMapping("/login")
    public Result<?> login(@RequestBody Manager manager){
        Manager login = managerService.login(manager);
        if (login != null){
            return Result.success(login);
        }
        return Result.error(-1,"用户名或密码错误");
    }

    //个人信息查询,根据id
    @GetMapping("/find")
    public Result<?> find(@RequestParam Integer managerId ){
        Manager manager = managerService.find(managerId);
        return Result.success(manager);
    }

    //修改个人资料
    @PutMapping("/update")
    public Result<?> update(@RequestBody Manager manager){
        boolean update = managerService.update(manager);
        if (update){
            return Result.success();
        }else {
            return Result.error(-1,"修改个人信息失败");
        }
    }

}
