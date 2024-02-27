package com.demo.comongo.mapper;

import com.demo.comongo.dto.ProductDto;
import com.demo.comongo.entity.Product;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MyMapper {
    MyMapper INSTANCE = Mappers.getMapper(MyMapper.class);
    @Mapping(target = "id", ignore = true)
    Product updateProducts(Product productSource, @MappingTarget Product productTarget);

    ProductDto productToProductDto(Product product);

    @IterableMapping(elementTargetType = ProductDto.class)
    List<ProductDto> productsToProductDto(List<Product> productList);
    @IterableMapping(elementTargetType = Product.class)
    List<Product> productsDtoToProduct(List<ProductDto> productList);
}
