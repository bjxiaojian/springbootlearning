package com.example.myFirstProject.controller;

import com.example.myFirstProject.domain.Shop;
import com.example.myFirstProject.service.ShopService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/shop")
@Api("shopController相关api")
public class ShopController {

    @Autowired
    private ShopService service;

    @ApiOperation("获取shop信息,测试多数据源")
    @RequestMapping(value = "/getShop", method = RequestMethod.GET)
    public Shop getShop(@RequestParam("id") int id) {
        return service.getShop(id);
    }

}