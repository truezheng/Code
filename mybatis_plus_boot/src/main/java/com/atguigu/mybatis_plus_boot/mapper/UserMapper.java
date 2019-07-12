package com.atguigu.mybatis_plus_boot.mapper;

import com.atguigu.mybatis_plus_boot.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> {
}
