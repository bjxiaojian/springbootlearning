package com.example.myFirstProject.enums;

import com.example.myFirstProject.service.EnumMessage;

import org.apache.commons.lang3.StringUtils;

public enum SexEnum implements EnumMessage {
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

  @Override
  public Object getValue() {
    return nativeCode;
  }

}