package com.example.myFirstProject.mapper;

import com.example.myFirstProject.domain.User;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    
    @Insert("INSERT INTO userinfo(username, password) VALUES(#{username},#{password})")
    public int insertUser(@Param("username") String username, @Param("password")  String password);
    
    /**
     * 插入用户，并将主键设置到user中
     * 注意：返回的是数据库影响条数，即1
     * 因为配置了mybatis.typeAliasesPackage=com.example.myFirstProject.domain，User成为模型类，所以不用加@Param
     */
    public int insertUserWithBackId(User user);

    public User getUserByIdAndUsernameOrPassword(@Param("id") Integer id, @Param("username") String username, @Param("password") String password);
}