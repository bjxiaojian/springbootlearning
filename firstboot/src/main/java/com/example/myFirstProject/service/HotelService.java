package com.example.myFirstProject.service;

import com.example.myFirstProject.api.HotelAPI;
import com.example.myFirstProject.domain.Hotel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by bjxiaojian on 2016/11/10.
 */
@Service
public class HotelService {
  @Autowired
  private HotelAPI hotelApi;

  public Hotel getHotelFromMyboot2WithQueryParameter(String hotelname){
    return hotelApi.getHotelWithQueryParameter(hotelname);
  }

  public List<Hotel> getHotelFromMyboot2List(){
    return hotelApi.getHotelList();//测试post请求
  }

  public List<Hotel> getHotelFromMyboot2ListWithBody(Hotel hotel){
    return hotelApi.getHotelListWithBody(hotel);//测试post请求
  }
}
