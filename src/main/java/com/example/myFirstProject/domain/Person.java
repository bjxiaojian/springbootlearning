package com.example.myFirstProject.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonValue;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by bjxiaojian on 2016/10/26.
 */
public class Person {
//  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String name;

  private int age;

  private SexEnum sex;

  public enum SexEnum{
    MAN("M", "m"),
    WOMAN("F", "f");

    private String merchantCode;
    private String nativeCode;

    SexEnum(String merchantCode, String nativeCode) {
      this.merchantCode = merchantCode;
      this.nativeCode = nativeCode;
    }

    public String getMerchantCode() {
      return merchantCode;
    }

    public void setMerchantCode(String merchantCode) {
      this.merchantCode = merchantCode;
    }

    public String getNativeCode() {
      return nativeCode;
    }

    public void setNativeCode(String nativeCode) {
      this.nativeCode = nativeCode;
    }

    @Override
    public String toString() {
      return getMerchantCode();
    }

    public static SexEnum getSexEnumByNativeCode(String nativeCode){
      for(SexEnum sexEnum : SexEnum.values()){
        if(StringUtils.equals(nativeCode, sexEnum.getNativeCode())){
          return sexEnum;
        }
      }
      return null;
    }
  }

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
}
