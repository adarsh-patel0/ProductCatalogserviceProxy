package com.example.ProductCatalogServiceProxy.Clients.Fakestore.Client;

import com.example.ProductCatalogServiceProxy.Clients.Fakestore.Dtos.FakeStoreProductdto;
import com.example.ProductCatalogServiceProxy.Models.Product;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class FakeStoreAPIClient {

    RestTemplateBuilder restTemplateBuilder;

    public FakeStoreAPIClient(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder = restTemplateBuilder;
    }

    public FakeStoreProductdto getProduct(Long productId){
        RestTemplate restTemplate = restTemplateBuilder.build();
        FakeStoreProductdto fakeStoreProductDto = restTemplate.getForEntity("https://fakestoreapi.com/products/{id}", FakeStoreProductdto.class,productId).getBody();
        return fakeStoreProductDto;
    }
    public FakeStoreProductdto createProduct(FakeStoreProductdto fakeStoreProductdto){
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductdto> FakestoreProductdtoResponseEntity = restTemplate.postForEntity("https://fakestoreapi.com/products",fakeStoreProductdto,FakeStoreProductdto.class);
        return FakestoreProductdtoResponseEntity.getBody();
    }


}
