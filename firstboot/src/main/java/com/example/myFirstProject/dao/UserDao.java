package com.example.myFirstProject.dao;

import com.example.myFirstProject.domain.User;
import com.example.myFirstProject.exception.UserException;
import com.example.myFirstProject.mapper.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class UserDao {
    
    @Autowired
    private UserMapper userMapper;
    
    public int insertUser(String username, String password){
        return userMapper.insertUser(username, password);
    }
    
    public int insertUserWithBackId(User user){
        return userMapper.insertUserWithBackId(user);
    }

    public void testTransactional(String username){
        throw new UserException("测试事务");
    }

    /**
     * 测试 mybatis and or联查
     */
     public User getUserByIdAndUsernameOrPassword(Integer id, String username, String password){
        return userMapper.getUserByIdAndUsernameOrPassword(id, username, password);
     }
}