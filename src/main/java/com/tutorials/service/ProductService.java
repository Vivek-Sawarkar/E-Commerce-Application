package com.tutorials.service;

import com.tutorials.dtos.ProductDto;

import java.util.List;

public interface ProductService {

    //create product
    public ProductDto createProduct(ProductDto productDto, Integer categoryId);

    //update product
    public ProductDto updateProduct(ProductDto productDto, Integer productId);

    //delete product
    public  String deleteProduct(Integer productId);

    //get product
    public  ProductDto getProduct(Integer productId);

    //get All product
    public List<ProductDto> getAllProduct();

    // get all product by particular categoryId
    public List<ProductDto> getAllProductsByCategory(Integer categoryId);
}
