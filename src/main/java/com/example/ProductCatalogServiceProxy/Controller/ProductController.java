package com.example.ProductCatalogServiceProxy.Controller;

import com.example.ProductCatalogServiceProxy.Dto.ProductDto;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @GetMapping("/product")
    public String getProducts(){
        return "returning List of All Products";
    }

    @GetMapping("/product/{id}")
    public String getProduct(@PathVariable("id") String productId){
        return "Returning product with id " +productId;
    }

    @PostMapping("/product")
    public String createProduct(@RequestBody ProductDto productDto){
        return "creating product ..." +productDto;
    }

    @PatchMapping("/product")
    public String updateProduct(@RequestBody ProductDto productDto){
        return "updating product ..." +productDto;
    }
}
