package com.demo.comongo.repository;

import com.demo.comongo.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product,String> {
    @Query("{'name': {$regex: ?0, $options: 'i'}}")
    Product findByName(String name);
    Boolean existsBySku(String sku);
}
