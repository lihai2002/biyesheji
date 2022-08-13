package com.lihai.biyesheji.service.impl;
import com.lihai.biyesheji.domain.Community;
import com.lihai.biyesheji.domain.Room;
import com.lihai.biyesheji.domain.User;
import com.lihai.biyesheji.mapper.CommunityMapper;
import com.lihai.biyesheji.mapper.RoomMapper;
import com.lihai.biyesheji.mapper.UserMapper;
import com.lihai.biyesheji.service.RoomService;
import com.lihai.biyesheji.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Resource
    private RoomMapper roomMapper;
    @Resource
    private RoomService roomService;
    @Resource
    private CommunityMapper communityMapper;


//    增加一个用户
    @Override
    public boolean insertUser(User user) {
        Room room = roomMapper.findOneBuildIdRoomId(user.getBuildId(),user.getRoomId()); //查询对应房间
        //判断该房间是否存在
        if (room.getState().equals("未入住")){
            if(user.getUserPassword() == null){     //默认密码为123456
                user.setUserPassword("123456");
            }
            user.setMoney((double) 0);
            boolean b = userMapper.insertUser(user);    //个人信息存储到数据库
            User oneUser = userMapper.findOneUserId(user.getUserId());  //查询当前注册用户
            room.setUid(oneUser.getUid());
            room.setPeopleCount(user.getPeopleCount());
            room.setState("已入住");
            roomService.updateRoom(room);      //更新该房间信息

            List<User> users = userMapper.findallCommunityId(user.getCommunityId());    //根据小区id查询该小区所有用户
            int size = users.size();
            Community community = communityMapper.findOneCommunityId(user.getCommunityId());    //查询该小区详细信息
            community.setUserTotal(size);
            communityMapper.update(community);  //跟新该小区的用户总数

            return b;
        }else {
            return false;
        }
    }

    //    根据id删除用户
    @Override
    public void deleteUser(String userId) {
        User user = userMapper.findOneUserId(userId);   //查询到该用户
        userMapper.deleteUser(userId);
        List<User> users = userMapper.findallCommunityId(user.getCommunityId());    //根据小区id查询该小区所有用户
        int size = users.size();
        Community community = communityMapper.findOneCommunityId(user.getCommunityId());    //查询该小区详细信息
        community.setUserTotal(size);
        communityMapper.update(community);  //跟新该小区的用户总数
    }
    // 根据条件进行模糊查询

    //更新用户信息
    public  boolean updateUser(User user) {
        boolean i = userMapper.updateUser(user);
        return i;
    }

    // 账户充值
    public boolean chongZhi(User user) {
        Integer uid = user.getUid();        //获取前端传的充值账户id
        User one = userMapper.findOne(uid);  //查询需要充值的用户
        Double money1 = one.getMoney();//获取需要充值的用户原有的账户余额
        Double money2 = money1 + user.getMoney();//总额=原有余额+充值金额
        boolean b = userMapper.updateMoney(money2,uid);//调用充值方法
        return b;
    }

//    条件查询全部用户
    @Override
    public List<User> findall(String search) {
        List<User> users = userMapper.findall(search);
        return users;
    }

    //app用户登录
    @Override
    public User login(User user) {
        User login = userMapper.login(user);
        if(login != null){
            Community community = communityMapper.findOneCommunityId(login.getCommunityId());   //查询登录用户的小区
            login.setCommunityName(community.getCommunityName());
            Room room = roomMapper.findOneUid(login.getUid()); //查询登录用户对应的房间信息
            login.setBuildId(room.getBuildId());
            login.setRoomId(room.getRoomId());
        }
        return login;
    }



//    用户修改密码
    @Override
    public boolean resetPwd(  User user) {
        boolean b = userMapper.resetPwd(user);

        if (b){
            return true;
        }
        return false;
    }

    //更新用户信息App
    public  boolean updateUserApp(User user) {
        boolean i = userMapper.updateUserApp(user);
        return i;
    }


}
