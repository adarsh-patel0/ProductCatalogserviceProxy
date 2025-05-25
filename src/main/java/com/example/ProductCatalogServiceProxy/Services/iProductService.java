package com.example.ProductCatalogServiceProxy.Services;

import com.example.ProductCatalogServiceProxy.Dto.ProductDto;
import com.example.ProductCatalogServiceProxy.Models.Product;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface iProductService {

    List<Product> getProducts();

    Product getProduct(Long productId);

    Product createProduct(ProductDto productDto);

    String updateProduct( ProductDto productDto);
}
