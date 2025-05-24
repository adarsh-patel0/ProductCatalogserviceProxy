package com.example.ProductCatalogServiceProxy.Dto;

import com.example.ProductCatalogServiceProxy.Models.Category;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductDto {

    private String title;

    private String description;

    private Double price;

    private String imageUrl;

    private Category category;
}
