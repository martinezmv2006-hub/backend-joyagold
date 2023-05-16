package com.prueba.joyagold.services;

import com.prueba.joyagold.mapper.ProductMapper;
import com.prueba.joyagold.models.dto.ProductDTO;
import com.prueba.joyagold.models.entity.Product;
import com.prueba.joyagold.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImple implements ProductService{

    private ProductRepository repository;

    private final ProductMapper mapper;

    public ProductServiceImple(ProductRepository repository, ProductMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<ProductDTO> getAllProduct() {
        List<ProductDTO> productDTOs = new ArrayList<>();
        for(Product product : repository.findAllByOrderByNameAsc()){
            productDTOs.add(mapper.toDto(product));
        }
        return productDTOs;
    }

    @Override
    public ProductDTO getById(Long id) {
        Optional<Product> productOp = repository.findById(id);
        if (productOp.isPresent()) {
            return mapper.toDto(productOp.get());
        }
        return null;
    }

    @Override
    public ProductDTO save(ProductDTO product) {
        Product productSave = repository.save(mapper.toEntity(product));
        return mapper.toDto(productSave);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
