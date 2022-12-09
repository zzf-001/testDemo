package com.zzf.asyndemo.mapper;


import com.zzf.asyndemo.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    @Insert({
            "insert into users (id,userName,password,email) " ,
            "values (#{user.id},#{user.userName},#{user.password},#{user.email})"
    })
    int insertUser(@Param("user") User user);

    @Select({
            "select * from users"
    })
    List<User> getUser();
}
