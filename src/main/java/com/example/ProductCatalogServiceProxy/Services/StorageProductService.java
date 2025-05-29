package com.example.ProductCatalogServiceProxy.Services;

import com.example.ProductCatalogServiceProxy.Models.Product;
import com.example.ProductCatalogServiceProxy.Repositries.ProductRepo;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StorageProductService implements iProductService{

    private ProductRepo productRepo;

    public StorageProductService(ProductRepo productRepo){
        this.productRepo = productRepo;
    }

    @Override
    public List<Product> getProducts() {
        return List.of();
    }

    @Override
    public Product getProduct(Long productId) {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        Product resultProduct = productRepo.save(product);
        return resultProduct;
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }
}
