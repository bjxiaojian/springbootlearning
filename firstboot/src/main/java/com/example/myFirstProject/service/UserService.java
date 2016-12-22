package com.example.myFirstProject.service;

import com.example.myFirstProject.dao.UserDao;
import com.example.myFirstProject.domain.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

  private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

  @Autowired
  private User user;

  @Autowired
  private UserDao userDao;

  public boolean addUser(String username, String password) {
    return userDao.insertUser(username, password) == 1 ? true : false;
  }

  public User addUserWithBackId(String username, String password) {
    User user = new User();
    user.setUsername(username);
    user.setPassword(password);
    userDao.insertUserWithBackId(user);//该方法后，主键已经设置到user中了
    return user;
  }


  public User getUser(String username, String password) {
    return new User(username, password);
  }

  @Transactional
  public void testTransaction(String username, String password){
    System.out.println(userDao.insertUser(username, password));
    userDao.testTransactional(username);
  }

  public User getUserByIdAndUsernameOrPassword(Integer id, String username, String password){
    User user = userDao.getUserByIdAndUsernameOrPassword(id, username, password);
    LOGGER.info("getUserByIdAndUsernameOrPassword success! user:'{}'", user);
    return user;
  }
}