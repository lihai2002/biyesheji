package com.lihai.biyesheji.service;

import com.lihai.biyesheji.domain.User;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface UserService {

    //新增一个用户
    boolean insertUser(User user);
    // 根据id删除用户
    void deleteUser(String userId);
    //更新用户
    boolean updateUser(User user);

    //充值
    boolean chongZhi(User user);

//    查询
    List<User> findall(String search);

//    app用户登录
    User login(User user);


//    用户修改密码
    boolean resetPwd(  User user);
    //App用户修改信息
    boolean updateUserApp(User user);

}
