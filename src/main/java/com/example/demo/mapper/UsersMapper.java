package com.example.demo.mapper;

import com.example.demo.model.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UsersMapper {

    @Select("select * from users where username=#{username}")
    Users selectByUsername(String username);
}
