package com.lihai.biyesheji.mapper;

import com.lihai.biyesheji.domain.Community;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommunityMapper {

    // 查找所有小区
    List<Community> findall ();

    //根据id查找小区
    Community findOneCommunityId(Integer communityId);

//    更新小区资料
    boolean update(Community community);

    // 根据id删除小区
    boolean delete(Integer communityId);
}
