package com.polovyi.ivan.repository;

import com.polovyi.ivan.entity.CustomerEntity;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<CustomerEntity, String> {

}
