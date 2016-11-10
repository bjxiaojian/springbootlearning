package com.example.myFirstProject.dao;

import com.example.myFirstProject.domain.Shop;
import com.example.myFirstProject.mapper.ShopMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class ShopDao {
    @Autowired
    private ShopMapper mapper;

    /**
     * 获取shop
     */
    public Shop getShop(int id) {
//        DatabaseContextHolder.setDatabaseType(DatabaseType.test);
        return mapper.getShop(id);
    }
}