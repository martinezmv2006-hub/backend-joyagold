package com.prueba.joyagold.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    @JsonProperty("id")
    private Long id;

    @NotBlank(message = "The name is required.")
    @JsonProperty("name")
    private String name;

    @NotBlank(message = "The material is required.")
    @JsonProperty("material")
    private String material;

    @NotBlank(message = "The type is required.")
    @JsonProperty("type")
    private String type;

    @JsonProperty("price")
    private BigDecimal price;

    @JsonProperty("other")
    private String other;
}
