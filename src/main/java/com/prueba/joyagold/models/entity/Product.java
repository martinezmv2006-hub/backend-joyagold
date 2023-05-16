package com.prueba.joyagold.models.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "PRODUCT")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", length = 20)
    private String name;

    @Column(name = "MATERIAL", length = 20)
    private String material;

    @Column(name = "TYPE", length = 20)
    private String type;

    @Column(name = "PRICE")
    private BigDecimal price;

    @Column(name = "OTHER", length = 200)
    private String other;

}
