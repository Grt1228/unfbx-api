package com.unfbx.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.unfbx.auth.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}