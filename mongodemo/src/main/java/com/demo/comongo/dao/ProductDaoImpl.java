package com.demo.comongo.dao;

import com.demo.comongo.entity.Product;
import com.demo.comongo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductDaoImpl implements ProductDao{

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product insertProductData(Product product) {
        return productRepository.insert(product);
    }
    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }
    @Override
    public List<Product> searchProductByName(String productName) {
        return productRepository.findByName(productName);
    }
}
