package com.example.myFirstProject.controller;

import com.example.myFirstProject.domain.Hotel;
import com.example.myFirstProject.service.HotelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Created by bjxiaojian on 2016/11/10.
 */
@RestController
@RequestMapping("/hotel")
@Api("hotelController相关api")
public class HotelController {
  @Autowired
  private HotelService hotelService;

  @ApiOperation("获取酒店信息,测试GETWithQueryParameter")
  @RequestMapping(value="/getHotelWithQueryParameter",method= RequestMethod.GET)
  public Hotel getHotel(@RequestParam("hotelname") String hotelname) {
    return hotelService.getHotelFromMyboot2WithQueryParameter(hotelname);
  }

  @ApiOperation("获取酒店信息,测试POST")
  @RequestMapping(value="/getHotelList",method=RequestMethod.GET)
  public List<Hotel> getHotelList() {
    return hotelService.getHotelFromMyboot2List();
  }

  @ApiOperation("获取酒店信息,测试POST")
  @RequestMapping(value="/getHotelListWithBody",method=RequestMethod.GET)
  public List<Hotel> getHotelListWithBody() {
    return hotelService.getHotelFromMyboot2ListWithBody(new Hotel(888, "武林酒店"));
  }
}
