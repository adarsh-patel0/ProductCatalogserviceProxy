package com.example.ProductCatalogServiceProxy.Clients.Fakestore.Dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FakestoreRatingDto {

    private double rate;

    private Long count;
}
