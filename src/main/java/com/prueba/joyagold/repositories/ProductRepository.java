package com.prueba.joyagold.repositories;

import com.prueba.joyagold.models.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
    Iterable<Product> findAllByOrderByNameAsc();
}
