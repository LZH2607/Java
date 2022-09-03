package com.test.mapper;

import com.test.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    @Select("select * from user;")
    List<User> selectAll();
    @Select("select * from user where id = #{id};")
    User selectById(int id);
}
