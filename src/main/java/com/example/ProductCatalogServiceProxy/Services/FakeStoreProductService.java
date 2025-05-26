package com.example.ProductCatalogServiceProxy.Services;

import com.example.ProductCatalogServiceProxy.Clients.Fakestore.Client.FakeStoreAPIClient;
import com.example.ProductCatalogServiceProxy.Clients.Fakestore.Dtos.FakeStoreProductdto;
import com.example.ProductCatalogServiceProxy.Models.Category;
import com.example.ProductCatalogServiceProxy.Models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class FakeStoreProductService implements iProductService {

    private RestTemplateBuilder restTemplateBuilder;

    private FakeStoreAPIClient fakeStoreAPIClient;

    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder,FakeStoreAPIClient fakeStoreAPIClient){
        this.restTemplateBuilder = restTemplateBuilder;
        this.fakeStoreAPIClient = fakeStoreAPIClient;
    }

    @Override
    public List<Product> getProducts(){
        RestTemplate restTemplate = restTemplateBuilder.build();
        FakeStoreProductdto[] FakeStoreProductDtos = restTemplate.getForEntity("https://fakestoreapi.com/products",FakeStoreProductdto[].class).getBody();
        List<Product> products = new ArrayList<>();
        for(FakeStoreProductdto productDto : FakeStoreProductDtos){
            products.add(getProduct(productDto));
        }
        return products;
    }

    @Override
    public Product getProduct(Long productId){
        return getProduct(fakeStoreAPIClient.getProduct(productId));
    }

    @Override
    public Product createProduct( Product product){
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductdto> FakestoreProductdtoResponseEntity = restTemplate.postForEntity("https://fakestoreapi.com/products",product,FakeStoreProductdto.class);
        FakeStoreProductdto fakeStoreProductdto= getFakeStoreProductDto(product);
        FakeStoreProductdto responeFakeStoreProductDto = fakeStoreAPIClient.createProduct(fakeStoreProductdto);
        return getProduct(responeFakeStoreProductDto);
    }

    @Override
    public Product updateProduct(Long id, Product product){
        RestTemplate restTemplate = restTemplateBuilder.build();
//        FakeStoreProductdto fakeStoreProductdto = restTemplate.patchForObject("https://fakestoreapi.com/products",product,FakeStoreProductdto.class,id);
//        ResponseEntity<FakeStoreProductdto> fakeStoreProductdtoResponseEntity = requestForEntity(HttpMethod.PATCH,"https://fakestoreapi.com/{id}",product,FakeStoreProductdto.class,id);
//        Product resultantProduct = getProduct(fakeStoreProductdtoResponseEntity.getBody());
//        return resultantProduct;
        return null;
    }

    private <T> ResponseEntity<T> requestForEntity(HttpMethod httpMethod, String url, @Nullable Object request, Class<T> responseType, Map<String, ?> uriVariables) throws RestClientException {
//        RestTemplate restTemplate = restTemplateBuilder.build();
        RestTemplate restTemplate = restTemplateBuilder.requestFactory(
                HttpComponentsClientHttpRequestFactory.class
        ).build();
        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return restTemplate.execute(url, httpMethod, requestCallback, responseExtractor, uriVariables);
    }

    private Product getProduct(FakeStoreProductdto productDto){
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

    private FakeStoreProductdto getFakeStoreProductDto(Product product){
        FakeStoreProductdto fakeStoreProductdto = new FakeStoreProductdto();
        fakeStoreProductdto.setId(product.getId());
        fakeStoreProductdto.setCategory(product.getCategory().getName());
        fakeStoreProductdto.setImageUrl(product.getImageUrl());
        fakeStoreProductdto.setDescription(product.getDescription());
        fakeStoreProductdto.setPrice(product.getPrice());
        fakeStoreProductdto.setTitle(product.getTitle());
        return fakeStoreProductdto;

    }

}
