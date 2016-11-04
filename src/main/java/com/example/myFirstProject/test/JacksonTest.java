package com.example.myFirstProject.test;

import com.alibaba.fastjson.JSONObject;
import com.example.myFirstProject.domain.Person;
import com.example.myFirstProject.enums.SexEnum;
import com.example.myFirstProject.util.EnumUtil;
import com.example.myFirstProject.util.JacksonUtil;

import org.joda.time.DateTime;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * Created by bjxiaojian on 2016/10/26.
 */
public class JacksonTest {

  public static void main(String[] args) {

//    Person person = new Person();
//
//    Person person1 = new Person("xiaojian", 1);
//    person1.setSex(MAN);
//    person1.setBirthDay(new Date());
//    List personList = new ArrayList();
//    personList.add(person);
//    personList.add(person1);
//    System.out.println(JacksonUtil.encode(person));
//    System.out.println(JacksonUtil.encode(person1));
//    System.out.println(JacksonUtil.encode(personList));

//    String str = "{\"age\":1,\"birthDay\":1477661674628,\"name\":\"xiaojian\",\"sex\":\"M\"}}";
//    System.out.println(JacksonUtil.decode(str, Person.class).getSex());

    Person person = new Person();
    person.setSex(EnumUtil.getEnumObject("m", SexEnum.class));
    System.out.println(JacksonUtil.encode(person));
  }
}
