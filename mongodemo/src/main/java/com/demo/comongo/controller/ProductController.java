package com.demo.comongo.controller;

import com.demo.comongo.dao.ProductDao;
import com.demo.comongo.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api")
public class ProductController {

    @Autowired
    private ProductDao productDao;

    @PostMapping("/create")
    public Product setupProductData(@RequestBody Product product){
        return productDao.insertProductData(product);
    }
    @GetMapping("/listProducts")
    public List<Product> getProductsData(){
        return productDao.getProducts();
    }
    @GetMapping("/productsSearch")
    public List<Product> searchProductsWithName(@RequestParam("name") String name){
        return productDao.searchProductByName(name);
    }

}
