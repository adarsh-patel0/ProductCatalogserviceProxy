package com.example.ProductCatalogServiceProxy.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class product {

    private String title;

    private String description;

    private Double price;

    private String imageUrl;

    private Category category;

}
