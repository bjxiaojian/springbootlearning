package com.example.myFirstProject.test;

import com.example.myFirstProject.domain.Person;
import com.example.myFirstProject.util.JacksonUtil;

import java.util.ArrayList;
import java.util.List;

import static com.example.myFirstProject.domain.Person.SexEnum;
import static com.example.myFirstProject.domain.Person.SexEnum.MAN;


/**
 * Created by bjxiaojian on 2016/10/26.
 */
public class JacksonTest {

  public static void main(String[] args) {

    Person person = new Person();

    Person person1 = new Person("xiaojian", 1);
    person1.setSex(MAN);
    List personList = new ArrayList();
    personList.add(person);
    personList.add(person1);
    System.out.println(SexEnum.getSexEnumByNativeCode("m"));
//    System.out.println(JacksonUtil.encode(person));
//    System.out.println(JacksonUtil.encode(person1));
//    System.out.println(JacksonUtil.encode(personList));
  }
}
