package com.sovava.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sovava.pojo.Location;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LocationDao extends BaseMapper<Location> {
}
