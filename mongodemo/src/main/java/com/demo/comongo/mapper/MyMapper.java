package com.demo.comongo.mapper;

import com.demo.comongo.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MyMapper {
    MyMapper INSTANCE = Mappers.getMapper(MyMapper.class);
    @Mapping(target = "id", ignore = true)
    Product updateProducts(Product productSource, @MappingTarget Product productTarget);

}
