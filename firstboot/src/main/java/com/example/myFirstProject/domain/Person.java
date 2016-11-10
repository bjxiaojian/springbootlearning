package com.example.myFirstProject.domain;

import com.example.myFirstProject.enums.SexEnum;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.Date;

/**
 * Created by bjxiaojian on 2016/10/26.
 */
@JsonRootName("Test")
//@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Person {
//  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String name;

  private int age;

  private SexEnum sex;

  private Date birthDay;

  public Person() {
  }

  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public SexEnum getSex() {
    return sex;
  }

  public void setSex(SexEnum sex) {
    this.sex = sex;
  }

  public Date getBirthDay() {
    return birthDay;
  }

  public void setBirthDay(Date birthDay) {
    this.birthDay = birthDay;
  }
}
