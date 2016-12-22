package com.example.myFirstProject.domain;

/**
 * @Author bjxiaojian
 * @Date 2016/12/6
 * @Description
 */
public enum IdTypeEnum {
  IDCARD(1, "idcard"),
  PASSPORT(2, "passport");

  private int value;
  private String name;

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  IdTypeEnum(int value, String name) {
    this.value = value;
    this.name = name;
  }
}
