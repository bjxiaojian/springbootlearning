package com.example.myFirstProject.common;

import com.example.myFirstProject.service.EnumMessage;
import com.example.myFirstProject.util.PackageUtil;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Constant {


  /**
   * 枚举类对应的包路径
   */
  public final static String PACKAGE_NAME = "com.example.myFirstProject.enums";
  /**
   * 枚举接口类全路径
   */
  public final static String ENUM_MESSAGE_PATH = "com.example.myFirstProject.service.EnumMessage";

  /**
   * 枚举类对应的全路径集合
   */
  public static final List<String> ENUM_OBJECT_PATH = PackageUtil.getPackageClasses(PACKAGE_NAME, true);

  /**
   * 存放单个枚举对象 map常量定义
   */
  private static Map<Object, EnumMessage> SINGLE_ENUM_MAP = null;
  /**
   * 所有枚举对象的 map
   */
  public static final Map<Class, Map<Object, EnumMessage>> ENUM_MAP = initialEnumMap(true);


  /**静态初始化块*/
  static {

  }

  /**
   * 加载所有枚举对象数据
   *
   * @param isFouceCheck 是否强制校验枚举是否实现了EnumMessage接口
   */
  private static Map<Class, Map<Object, EnumMessage>> initialEnumMap(boolean isFouceCheck) {
    Map<Class, Map<Object, EnumMessage>> ENUM_MAP = new HashMap<>();
    try {
      for (String classname : ENUM_OBJECT_PATH) {
        Class<?> cls = null;
        cls = Class.forName(classname);
        Class<?>[] iter = cls.getInterfaces();
        boolean flag = false;
        if (isFouceCheck) {
          for (Class cz : iter) {
            if (cz.getName().equals(ENUM_MESSAGE_PATH)) {
              flag = true;
              break;
            }
          }
        }
        if (flag == isFouceCheck) {
          SINGLE_ENUM_MAP = new HashMap<>();
          initialSingleEnumMap(cls);
          ENUM_MAP.put(cls, SINGLE_ENUM_MAP);
        }

      }
    } catch (Exception e) {

    }
    return ENUM_MAP;
  }

  /**
   * 加载每个枚举对象数据
   */
  private static void initialSingleEnumMap(Class<?> cls) throws Exception {
    Method method = cls.getMethod("values");
    EnumMessage inter[] = (EnumMessage[]) method.invoke(null, null);
    for (EnumMessage enumMessage : inter) {
      SINGLE_ENUM_MAP.put(enumMessage.getValue(), enumMessage);
    }
  }


}