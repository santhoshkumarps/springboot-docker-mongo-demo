package com.demo.comongo.dao;

import com.demo.comongo.dto.ProductDto;
import com.demo.comongo.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductDao {

    Product insertProductData(Product product);

    List<ProductDto> getProducts();
     ProductDto searchProductByName(String productName);
     Product updateProducts(Product product);
     Optional<Product> getProductById(String id);
     void deleteProduct(String id);
     List<ProductDto> insertProductsData(List<Product> productDto);
}
