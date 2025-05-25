package com.example.ProductCatalogServiceProxy.Controller;

import com.example.ProductCatalogServiceProxy.Dto.ProductDto;
import com.example.ProductCatalogServiceProxy.Models.Product;
import com.example.ProductCatalogServiceProxy.Services.iProductService;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/product")
@RestController
public class ProductController {

    iProductService productService;

    public ProductController(iProductService productService){
        this.productService = productService;
    }


    @GetMapping("")
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    @GetMapping("{id}")
    public Product getProduct(@PathVariable("id") Long productId){
        return productService.getProduct(productId);
    }

    @PostMapping("")
    public Product createProduct(@RequestBody ProductDto productDto){
        return productService.createProduct(productDto);
    }

    @PatchMapping("")
    public String updateProduct(@RequestBody ProductDto productDto){
        return "updating product ..." +productDto;
    }
}
