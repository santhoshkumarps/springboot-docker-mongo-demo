package com.demo.comongo.controller;

import com.demo.comongo.dao.ProductDao;
import com.demo.comongo.dto.ProductDto;
import com.demo.comongo.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping(path="/api")
public class ProductController {

    @Autowired
    private ProductDao productDao;

    @PostMapping("/create")
    public ResponseEntity<String> setupProductData(@RequestBody Product product){

        var existingData = productDao.searchProductByName(product.getName());
        if (Objects.nonNull(existingData)){
            return ResponseEntity
                    .status(CONFLICT)
                    .body("Product already exists...!!!");
        }
        var insertedData = productDao.insertProductData(product);
        return ResponseEntity.status(CREATED).body("Data Inserted Successfully: Generated ID:"+insertedData.getId());
    }
    @PostMapping("/createProducts")
    public ResponseEntity<String> setupProductsData(@RequestBody List<Product> product){
        if (Objects.nonNull(product) && !product.isEmpty()){
            var productData = productDao.insertProductsData(product);
            if (Objects.nonNull(productData)) {
             return ResponseEntity.status(OK).body("Products inserted successfully");
            }
            return ResponseEntity.status(CONFLICT).body("Products cannot be added already existed");
        }
        return ResponseEntity.status(NOT_FOUND).body("Please enter relevant details");
    }
    @GetMapping("/listProducts")
    public ResponseEntity<List<ProductDto>> getAllProductsData(){
        var products = productDao.getProducts();
        if (Objects.nonNull(products) && !products.isEmpty()){
            return ResponseEntity.status(OK).body(products);
        }
            return ResponseEntity.status(NOT_FOUND).body(null);
    }
    @GetMapping("/productsSearch")
    public ResponseEntity<ProductDto> searchProductsWithName(@RequestParam("name") String name){
        var product = productDao.searchProductByName(name);
        if (Objects.isNull(product)){
            return ResponseEntity.status(NOT_FOUND).body(null);
        }
        return ResponseEntity.status(OK).body(product);
    }

    @PutMapping("/update")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){
        if (Objects.nonNull(product))
            return ResponseEntity.status(OK).body(productDao.updateProducts(product));
        return ResponseEntity.status(NOT_FOUND).body(null);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteProduct(@RequestParam("id") String id){
        if (Objects.isNull(id)){
            return ResponseEntity.status(NOT_FOUND).body("please check details");
        }
        productDao.deleteProduct(id);
        return ResponseEntity.status(OK).body("Product with ID "+id+" is deleted successfully");
    }
}
