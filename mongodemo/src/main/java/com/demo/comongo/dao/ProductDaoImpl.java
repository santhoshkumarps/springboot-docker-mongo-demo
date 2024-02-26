package com.demo.comongo.dao;

import com.demo.comongo.entity.Product;
import com.demo.comongo.mapper.MyMapper;
import com.demo.comongo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductDaoImpl implements ProductDao{

    @Autowired
    MyMapper myMapper;
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
    public Product searchProductByName(String productName) {
        return productRepository.findByName(productName);
    }
    @Override
    public Product updateProducts(Product product) {
        var existingOptionalProduct = getProductById(product.getId());
        return existingOptionalProduct.map(value -> productRepository.save(myMapper.updateProducts(product, value))).orElse(null);
    }
    @Override
    public Optional<Product> getProductById(String id) {
        return productRepository.findById(id);
    }
    @Override
    public void deleteProduct(String id) {
        var product = getProductById(id);
        product.ifPresent(value -> productRepository.deleteById(value.getId()));
    }


}
