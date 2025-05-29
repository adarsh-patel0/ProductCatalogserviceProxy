package com.example.ProductCatalogServiceProxy.Repositries;

import com.example.ProductCatalogServiceProxy.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  ProductRepo extends JpaRepository<Product,Long> {

    Product save(Product product);

    Product findProductById(Long id);

    List<Product> findProductByPriceBetween(Double low, Double high);


}
