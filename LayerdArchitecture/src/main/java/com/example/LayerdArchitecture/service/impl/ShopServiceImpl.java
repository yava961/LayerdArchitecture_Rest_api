package com.example.LayerdArchitecture.service.impl;

import com.example.LayerdArchitecture.entity.Shop;
import com.example.LayerdArchitecture.repository.ShopRepo;
import com.example.LayerdArchitecture.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopRepo shopRepo;

    @Override
    public Shop createNewShop(Shop shop) {
        return shopRepo.save(shop);
    }

    @Override
    public List<Shop> getAllShops() {
        List<Shop> shops = new ArrayList<>();
        shopRepo.findAll().forEach(shops::add);
        return shops;
    }

    @Override
    public Optional<Shop> getShopById(Long id) {
        return shopRepo.findById(id);
    }

    @Override
    public Shop updateShopById(Long id, Shop shop) {
        if (shopRepo.findById(id).isEmpty()) {
            return null;
        } else {
            shop.setId(id);
            shopRepo.save(shop);
            return shop;
        }
    }

    @Override
    public void deleteShopById(Long id) {
        if (shopRepo.existsById(id)) {
            shopRepo.deleteById(id);
        } else {
            throw new RuntimeException("Shop with id : " + id + " not exist");
        }
    }
}
