package com.demo.comongo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Product {

    @Id
    private String id;
    private String name;
    private String description;
    private Double productPrice;
    private Integer noOfAvailableProducts;
    private Boolean isAvailable;
}
