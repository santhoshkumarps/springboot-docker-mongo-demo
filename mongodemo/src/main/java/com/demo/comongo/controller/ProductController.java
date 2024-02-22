package com.demo.comongo.controller;

import com.demo.comongo.dao.ProductDao;
import com.demo.comongo.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api")
public class ProductController {

    @Autowired
    private ProductDao productDao;

    @PostMapping("/create")
    public Product setupProductData(@RequestBody Product product){
        return productDao.insertProductData(product);
    }

}
