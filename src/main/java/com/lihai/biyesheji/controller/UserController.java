package com.lihai.biyesheji.controller;

import com.lihai.biyesheji.common.Result;
import com.lihai.biyesheji.domain.User;
import com.lihai.biyesheji.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

//    查询
    @GetMapping("/find")
    public Result<?> find(@RequestParam String search){
        List<User> findall = userService.findall(search);
        return Result.success(findall);
    }

//    新增
    @PostMapping("/add")
    public Result<?> insert(@RequestBody User user){
        boolean a = userService.insertUser(user);
        if (a){
            return Result.success();
        }else {
            return Result.error(-1,"新增用户失败");
        }
    }

//    删除
    @DeleteMapping("/delete")
    public Result<?> delete(@RequestParam(value="userId") String userId){
       userService.deleteUser(userId);
        return Result.success();
    }

    //    更新用户信息
    @PutMapping("/update")
    public Result<?> update(@RequestBody User user){
        boolean b = userService.updateUser(user);
        if (b){
            return Result.success();
        }
        return Result.error(-1,"更新失败");
    }

    //  账户充值
    @PutMapping("/money")
    public Result<?> chongZhi(@RequestBody User user){
        boolean b = userService.chongZhi(user);
        if (b){
            return Result.success();
        }
        return Result.error(-1,"更新失败");
    }


//---------------------------------------APP----------------------------------------------------


    //   app用户登录
    @PostMapping("/login")
    public Result<?> login(@RequestBody User user){
        if(user.getUserPhone() !=null && user.getUserPassword() != null){
            User login = userService.login(user);
            if (login != null){
                return Result.success(login);
            }
            return Result.error(-1,"用户名或密码错误");
        }else{
            return Result.error(-1,"账户或密码为空");
        }

    }



//    用户注册
    @PostMapping("/zhuce")
    public Result<?> zhuce(@RequestBody User user){
        boolean a = userService.insertUser(user);
        if (a){
            return Result.success();
        }else {
            return Result.error(-1,"注册失败,房屋不存在或已有人入住");
        }
    }


//    用户更新密码
    @PostMapping("/resetPwd")
    public Result<?> resetPwd(@RequestBody User user){
        boolean b = userService.resetPwd(user);
        if (b){
            return Result.success();
        }else{
            return Result.error(-1,"修改密码失败");
        }

    }

    //    App更新用户信息
    @PostMapping("/updateApp")
    public Result<?> updateApp(@RequestBody User user){
        boolean b = userService.updateUserApp(user);
        if (b){
            return Result.success();
        }
        return Result.error(-1,"更新失败");
    }


}
