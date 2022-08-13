package com.lihai.biyesheji.mapper;

import com.lihai.biyesheji.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository //标识为持久层组件
@Mapper
public interface UserMapper{


//    增加用户
    boolean insertUser(User user);
//    更新用户信息
    boolean updateUser(User user);

//    账户金额重置
    boolean updateMoney(@Param("money") Double money,@Param("uid") Integer uid);

    // 通过uid、查询单个用户
    User findOne(Integer uid);

    //根据账号查询用户
    User findOneUserId(String userId);

//    根据账号删除
    void deleteUser(String userId);

//    查询
    List<User> findall(String search);
    // 根据小区id查询该小区所有用户
    List<User> findallCommunityId(Integer communityId);


//----------------------------------------------------App-------------------------

//   app用户登录
    User login(User user);

//    用户修改密码
    boolean resetPwd( User user);

    //    更新用户信息App
    boolean updateUserApp(User user);

}
