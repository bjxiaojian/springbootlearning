package com.example.myFirstProject.exception;

import org.springframework.dao.DataAccessException;

/**
 * 自定义异常，用于测试事务
 */
public class UserException extends DataAccessException{

    private static final long serialVersionUID = 8901479830692029025L;

    public UserException(String msg) {
        super(msg);
    }

}