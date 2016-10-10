package com.example.myFirstProject.controller;

import com.example.myFirstProject.domain.User;
import com.example.myFirstProject.service.UserService;
import com.example.myFirstProject.util.JacksonUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController:spring mvc的注解，
 * 相当于@Controller与@ResponseBody的合体，可以直接返回json
 */
@RestController
@RequestMapping("/user")
public class UserController {

//    protected static Logger logger= LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/getUser")
    public User getUser() {
//        logger.info("hello {}", userService.getUser());
        System.out.println(JacksonUtil.encode(userService.getUser()));
        return userService.getUser();
    }

}