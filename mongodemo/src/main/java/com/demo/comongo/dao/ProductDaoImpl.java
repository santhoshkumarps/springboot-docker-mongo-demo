package com.demo.comongo.dao;

import com.demo.comongo.entity.Product;
import com.demo.comongo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDaoImpl implements ProductDao{

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product insertProductData(Product product) {
        return productRepository.insert(product);
    }
}
