package com.example.myFirstProject.service;

import com.example.myFirstProject.dao.ShopDao;
import com.example.myFirstProject.domain.Shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ShopService {

    @Autowired
    private ShopDao dao;

    public Shop getShop(int id) {
        return dao.getShop(id);
    }
}