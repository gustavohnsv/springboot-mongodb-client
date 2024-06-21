package com.gustavohnsv.clients.repository;

import com.gustavohnsv.clients.model.ShoppingCart;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartsRepository extends MongoRepository<ShoppingCart, String> {}
