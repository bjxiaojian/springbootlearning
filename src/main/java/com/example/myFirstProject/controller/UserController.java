package com.example.myFirstProject.controller;

import com.alibaba.fastjson.JSON;
import com.example.myFirstProject.common.MyConstants;
import com.example.myFirstProject.domain.User;
import com.example.myFirstProject.redis.MyRedisTemplate;
import com.example.myFirstProject.service.UserService;
import com.example.myFirstProject.util.JacksonUtil;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController:spring mvc的注解， 相当于@Controller与@ResponseBody的合体，可以直接返回json
 */
@RestController
@RequestMapping("/user")
public class UserController {

//    protected static Logger logger= LoggerFactory.getLogger(UserController.class);

  @Autowired
  private UserService userService;

  @Autowired
  private MyRedisTemplate myRedisTemplate;

  @RequestMapping("/getUser")
  public User getUser() {
//        logger.info("hello {}", userService.getUser());
    System.out.println(JacksonUtil.encode(userService.getUser()));
    return userService.getUser();
  }

  @RequestMapping("/testJedisCluster")
  public User testJedisCluster(@RequestParam("username") String username) {
    String value = myRedisTemplate.get(MyConstants.USER_FORWARD_CACHE_PREFIX, username);
    if (StringUtils.isBlank(value)) {
      myRedisTemplate.set(MyConstants.USER_FORWARD_CACHE_PREFIX, username, JSON.toJSONString(getUser()));
      return null;
    }
    return JSON.parseObject(value, User.class);
  }

}