package com.example.ProductCatalogServiceProxy.Controller;

import com.example.ProductCatalogServiceProxy.Dto.ProductDto;
import com.example.ProductCatalogServiceProxy.Models.Category;
import com.example.ProductCatalogServiceProxy.Models.Product;
import com.example.ProductCatalogServiceProxy.Services.iProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
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
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long productId){
        try{
            if(productId<1){
                throw new IllegalArgumentException("product id is incorrect");
            }
            MultiValueMap<String,String> headers = new LinkedMultiValueMap<>();
            headers.add("called by", "pagal");
            Product product = productService.getProduct(productId);
            return new ResponseEntity<>(product,headers, HttpStatus.OK);
        }catch (Exception exception){
            throw exception;
        }
    }

    @PostMapping("")
    public Product createProduct(@RequestBody ProductDto productDto){
        Product product = getProduct(productDto);
        return productService.createProduct(product);
    }

    @PatchMapping("{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody ProductDto productDto){
        Product product = getProduct(productDto);
        return productService.updateProduct(id,product);
    }

    private Product getProduct(ProductDto productDto){
        Product product = new Product();
        product.setTitle(productDto.getTitle());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setImageUrl(productDto.getImageUrl());
        Category category = new Category();
        category.setName(productDto.getCategory());
        product.setCategory(category);
        product.setId(productDto.getId());
        return product;
    }
}
