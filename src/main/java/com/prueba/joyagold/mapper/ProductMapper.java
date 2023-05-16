package com.prueba.joyagold.mapper;

import com.prueba.joyagold.models.entity.Product;
import com.prueba.joyagold.models.dto.ProductDTO;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring", uses = {})
public interface ProductMapper extends EntityMapper<ProductDTO, Product> {
    ProductDTO toDto(Product entity);

    Product toEntity(ProductDTO dto);
}
