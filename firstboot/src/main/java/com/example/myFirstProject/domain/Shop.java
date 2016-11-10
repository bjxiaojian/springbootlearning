package com.example.myFirstProject.domain;

/**
 * Created by bjxiaojian on 2016/11/10.
 */
public class Shop {
  private String id;
  private String shopName;

  public Shop() {
  }

  public Shop(String id, String shopName) {
    this.id = id;
    this.shopName = shopName;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getShopName() {
    return shopName;
  }

  public void setShopName(String shopName) {
    this.shopName = shopName;
  }
}
