package com.example.ProductCatalogServiceProxy.Services;

import com.example.ProductCatalogServiceProxy.Models.Product;

import java.util.List;

public interface iProductService {

    List<Product> getProducts();

    Product getProduct(Long productId);

    Product createProduct(Product product);

    Product updateProduct(Long id, Product product);
}
