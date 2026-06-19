package com.abhinav.ecom_project.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(name = "description")
    @JsonProperty("description")
    private String desc;

    private String brand;

    private BigDecimal price;

    private String category;

    private LocalDate releaseDate;

    private Boolean available;

    private Integer quantity;

    private String imageName;

    private String imageType;

    @Lob
    @Column(columnDefinition = "BLOB")
    private byte[] imageData;
}