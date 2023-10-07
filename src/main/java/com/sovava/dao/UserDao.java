package com.sovava.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sovava.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserDao extends BaseMapper<User> {
    void updateImg(@Param("filename") String fileName);
}
