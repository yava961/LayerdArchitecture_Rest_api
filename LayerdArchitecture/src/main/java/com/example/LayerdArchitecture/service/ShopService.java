package com.example.LayerdArchitecture.service;

import com.example.LayerdArchitecture.entity.Shop;

import java.util.List;
import java.util.Optional;

public interface ShopService {
    Shop createNewShop(Shop shop);

    List<Shop> getAllShops();

    Optional<Shop> getShopById(Long id);

    Shop updateShopById(Long id, Shop shop);

    void deleteShopById(Long id);
}
