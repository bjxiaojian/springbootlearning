package com.example.myFirstProject.service;

import com.example.myFirstProject.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    private User user;
    
    public User getUser(){
        return user;
    }

}