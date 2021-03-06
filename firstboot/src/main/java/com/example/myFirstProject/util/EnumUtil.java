package com.example.myFirstProject.util;

import com.example.myFirstProject.common.Constant;
import com.example.myFirstProject.service.EnumMessage;

public class EnumUtil {

    /**
     * 获取value返回枚举对象
     * @param value
     * @param clazz
     * */
    public static <T extends EnumMessage>  T getEnumObject(Object value, Class<T> clazz){
        return (T)Constant.ENUM_MAP.get(clazz).get(value);
    }

}