package com.example.LayerdArchitecture.repository;

import com.example.LayerdArchitecture.entity.Shop;
import org.springframework.data.repository.CrudRepository;

public interface ShopRepo extends CrudRepository<Shop, Long> {
}
