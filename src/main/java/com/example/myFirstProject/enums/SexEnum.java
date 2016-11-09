package com.example.myFirstProject.enums;

import com.example.myFirstProject.service.EnumMessage;
import org.apache.commons.lang3.StringUtils;

public enum SexEnum implements EnumMessage {
  MAN("M", "男"),
  WOMAN("F", "女");

  private String code;
  private String desc;

  SexEnum(String code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

//  @Override
//  public String toString() {
//    return getDesc();
//  }  @Override
//  public String toString() {
//    return getDesc();
//  }

  @Override
  public Object getValue() {
    return code;
  }

  public static SexEnum getSexEnumByCode(String code){
    for(SexEnum sexEnum : SexEnum.values()){
      if(StringUtils.equals(code, sexEnum.getCode())){
        return sexEnum;
      }
    }
    return null;
  }
}