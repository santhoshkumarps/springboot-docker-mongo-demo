package com.demo.comongo.dao;

import com.demo.comongo.dto.ProductDto;
import com.demo.comongo.entity.Product;
import com.demo.comongo.mapper.MyMapper;
import com.demo.comongo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
    public List<ProductDto> getProducts() {
      return myMapper.productsToProductDto(productRepository.findAll());
    }
    @Override
    public ProductDto searchProductByName(String productName) {
         return myMapper.productToProductDto(productRepository.findByName(productName));
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

    @Override
    public List<ProductDto> insertProductsData(List<Product> product) {
        List<Product> nonExistingProducts = new ArrayList<>();
        for (Product tempProduct: product){
            if ((Objects.nonNull(tempProduct.getSku())) && (!productRepository.existsBySku(tempProduct.getSku()))){
                nonExistingProducts.add(tempProduct);
            }
        }
        if (!nonExistingProducts.isEmpty()){
            return myMapper.productsToProductDto(productRepository.saveAll(nonExistingProducts));
        }
        return null;
    }
}
