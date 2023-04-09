package com.example.LayerdArchitecture.web;

import com.example.LayerdArchitecture.entity.Shop;
import com.example.LayerdArchitecture.service.impl.ShopServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/shops")
public class ShopController {

    @Autowired
    private ShopServiceImpl shopService;

    @PostMapping
    public ResponseEntity<Shop> createShop(@RequestBody Shop shop) {
        try {
            Shop newShop = shopService.createNewShop(shop);
            return new ResponseEntity(newShop, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<Shop>> getAllShops() {
        try {
            List<Shop> shops = shopService.getAllShops();
            return new ResponseEntity(shops, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Shop> getShopById(@PathVariable("id") Long id) {
        try {
            Optional<Shop> shopId = shopService.getShopById(id);
            return new ResponseEntity(shopId, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Shop> updateShopById(@PathVariable("id") Long id, @RequestBody Shop shop) {
        try {
            Shop updateShop = shopService.updateShopById(id, shop);
            return new ResponseEntity(updateShop, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Shop> deleteShopById(@PathVariable("id") Long id) {
        try {
            shopService.deleteShopById(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
