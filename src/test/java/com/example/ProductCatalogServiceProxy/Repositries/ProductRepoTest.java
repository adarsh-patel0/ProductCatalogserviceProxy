package com.example.ProductCatalogServiceProxy.Repositries;

import com.example.ProductCatalogServiceProxy.Models.Category;
import com.example.ProductCatalogServiceProxy.Models.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
public class ProductRepoTest {

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ProductRepo productRepo;

    @Test
    @Transactional
    @Rollback(value = false)
    void demonstrateoading(){
        Category category = categoryRepo.findById(100L).get();
        System.out.println(category.getName());
        List<Product> products = category.getProducts();
        for(Product product : products){
            System.out.println(product.getId());
        }
    }

    @Test
    @Transactional
    @Rollback(value = false)
    void demonstrateFetchMode(){
        Category category = categoryRepo.findById(100L).get();
        System.out.println(category.getName());
//        List<Product> products = category.getProducts();
//        for(Product product : products){
//            System.out.println(product.getId());
//        }
    }

    @Test
    @Transactional
    @Rollback(value = false)
    void demonstrateNPlusOnePrblm(){
        List<Category> categories = categoryRepo.findAll();
        for(Category category : categories){
            List<Product> products = category.getProducts();
            if(!products.isEmpty()){
                System.out.println(products.get(0).getPrice());
            }
        }
    }

    void demonstrateJPAGenerateQuery(){

        Product product = productRepo.findProductById(2L);
        List<Product> products = productRepo.findProductByPriceBetween(250D,2500D);
    }


}
