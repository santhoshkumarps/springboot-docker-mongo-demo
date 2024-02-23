package com.demo.comongo.dao;

import com.demo.comongo.entity.Product;

import java.util.List;

public interface ProductDao {

    Product insertProductData(Product product);

    List<Product> getProducts();
     Product searchProductByName(String productName);
}
