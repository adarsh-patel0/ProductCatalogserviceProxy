package com.example.ProductCatalogServiceProxy.Repositries;

import com.example.ProductCatalogServiceProxy.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Category,Long> {
}
