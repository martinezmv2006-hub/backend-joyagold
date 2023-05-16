package com.prueba.joyagold.services;

import com.prueba.joyagold.models.dto.ProductDTO;
import com.prueba.joyagold.models.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductDTO> getAllProduct();
    ProductDTO getById(Long id);
    ProductDTO save(ProductDTO product);
    void delete(Long id);

}
