package com.example.ProductCatalogServiceProxy.Clients.Fakestore.Dtos;

import com.example.ProductCatalogServiceProxy.Dto.RatingDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class FakeStoreProductdto {

    private Long id;

    private String title;

    private String description;

    private Double price;

    private String imageUrl;

    private String category;

    private FakestoreRatingDto ratingDto;
}
