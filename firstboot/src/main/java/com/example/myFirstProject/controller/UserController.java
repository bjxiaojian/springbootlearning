package com.example.myFirstProject.controller;

import com.example.myFirstProject.domain.User;
import com.example.myFirstProject.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @RestController:spring mvc的注解， 相当于@Controller与@ResponseBody的合体，可以直接返回json
 */
@RestController
@RequestMapping("/user")
@Api("userController相关api")
public class UserController {

    protected static Logger logger= LoggerFactory.getLogger(UserController.class);

  @Autowired
  private UserService userService;

//    @Autowired
//    private MyRedisTemplate myRedisTemplate;

  @ApiOperation("获取用户信息")
  @ApiImplicitParams({
      @ApiImplicitParam(paramType="header",name="username",dataType="String",required=true,value="用户的姓名",defaultValue="bjxiaojian"),
      @ApiImplicitParam(paramType="query",name="password",dataType="String",required=true,value="用户的密码",defaultValue="123")
  })
  @ApiResponses({
      @ApiResponse(code=400,message="请求参数没填好"),
      @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
  })
  @RequestMapping(value="/getUser",method= RequestMethod.GET)
  public User getUser(@RequestHeader("username") String username, @RequestParam("password") String password) {
    return userService.getUser(username,password);
  }

  @ApiOperation("添加用户")
  @ApiImplicitParams({
      @ApiImplicitParam(paramType="query",name="username",dataType="String",required=true,value="用户的姓名",defaultValue="bjxiaojian"),
      @ApiImplicitParam(paramType="query",name="password",dataType="String",required=true,value="用户的密码",defaultValue="123")
  })
  @ApiResponses({
      @ApiResponse(code=400,message="请求参数没填好"),
      @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
  })
  @RequestMapping(value="/addUser",method=RequestMethod.POST)
  public boolean addUser(@RequestParam("username") String username,
                         @RequestParam("password") String password) {
    return userService.addUser(username,password);
  }

  @ApiOperation("添加用户且返回已经设置了主键的user实例")
  @ApiImplicitParams({
      @ApiImplicitParam(paramType="query",name="username",dataType="String",required=true,value="用户的姓名",defaultValue="bjxiaojian"),
      @ApiImplicitParam(paramType="query",name="password",dataType="String",required=true,value="用户的密码",defaultValue="123")
  })
  @ApiResponses({
      @ApiResponse(code=400,message="请求参数没填好"),
      @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
  })
  @RequestMapping(value="/addUserWithBackId",method=RequestMethod.POST)
  public User addUserWithBackId(@RequestParam("username") String username,
                                @RequestParam("password") String password) {
    return userService.addUserWithBackId(username, password);
  }

  @ApiOperation("测试事务")
  @ApiImplicitParams({
      @ApiImplicitParam(paramType="query",name="username",dataType="String",required=true,value="用户的姓名",defaultValue="bjxiaojian"),
      @ApiImplicitParam(paramType="query",name="password",dataType="String",required=true,value="用户的密码",defaultValue="123")
  })
  @ApiResponses({
      @ApiResponse(code=400,message="请求参数没填好"),
      @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
  })
  @RequestMapping(value="/testTransaction",method=RequestMethod.GET)
  public void testTransaction(@RequestParam("username") String username,
                              @RequestParam("password") String password) {
    userService.testTransaction(username, password);
  }

//  @RequestMapping("/testJedisCluster")
//  public User testJedisCluster(@RequestParam("username") String username) {
//    String value = myRedisTemplate.get(MyConstants.USER_FORWARD_CACHE_PREFIX, username);
//    if (StringUtils.isBlank(value)) {
//      myRedisTemplate.set(MyConstants.USER_FORWARD_CACHE_PREFIX, username, JSON.toJSONString(getUser()));
//      return null;
//    }
//    return JSON.parseObject(value, User.class);
//  }

}