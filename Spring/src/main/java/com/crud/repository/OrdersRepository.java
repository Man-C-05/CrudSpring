package com.crud.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.crud.entity.Orders;

public interface OrdersRepository extends MongoRepository<Orders, String>{

}
