package com.prueba.joyagold.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prueba.joyagold.models.dto.ProductDTO;
import com.prueba.joyagold.services.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    private final Logger log = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService service;

    @CrossOrigin(origins = "*")
    @GetMapping("/get")
    public ResponseEntity<String> getProduct(){
        try {
            List<ProductDTO> productDTOS = service.getAllProduct();
            return ResponseEntity.status(200).body(new ObjectMapper().writeValueAsString(productDTOS));
        } catch (Exception e) {
            log.error("Error while trying to get productDTOS, with message: {}", e.getMessage());

            return ResponseEntity.status(500).body("Product not found");
        }
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/get/{id}")
    public ResponseEntity<String> getProductById(@PathVariable Long id){
        try {
            ProductDTO productDTO = service.getById(id);
            return ResponseEntity.status(200).body(new ObjectMapper().writeValueAsString(productDTO));
        } catch (Exception e) {
            log.error("Error while trying to get productDTO, with message: {}", e.getMessage());

            return ResponseEntity.status(500).body("Product not found");
        }
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/save", consumes = "application/json; charset=utf-8")
    public ResponseEntity<String> saveProduct(@Valid @RequestBody ProductDTO product) {

        try {
            log.info("Create accountDTO: {}", product);

            ProductDTO productDTO = service.save(product);

            return ResponseEntity.status(200).body(new ObjectMapper().writeValueAsString(productDTO));
        } catch (Exception e) {
            log.error("Error while trying to create new product: {}, with message: {}", e.getMessage(), product);

            return ResponseEntity.status(500).body("Could not create Product");
        }
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteProduct(@RequestParam Long id) {

        try {
            log.info("Delete Product: {}", id);

            service.delete(id);

            return ResponseEntity.status(200).body("Delete delete");
        } catch (Exception e) {
            log.error("Error while trying to delete Product: {}, with message: {}", e.getMessage(), id);

            return ResponseEntity.status(500).body("Product not deleted");
        }
    }


}
