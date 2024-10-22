package com.tutorials.controller;


import com.tutorials.dtos.ProductDto;
import com.tutorials.service.ProductService;
import com.tutorials.utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/")
public class ProductController {

    @Autowired
    private ProductService productService;

    //create product

    @PostMapping("/category/{categoryId}/product")
    public ResponseEntity<ProductDto> createProduct(@Valid @RequestBody ProductDto productDto, @PathVariable Integer categoryId){
        ProductDto product = this.productService.createProduct(productDto, categoryId);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }
    //update product
    @PutMapping("product/{productId}")
    public ResponseEntity<ProductDto> updateProduct(@Valid @RequestBody ProductDto productDto, @PathVariable Integer productId){
        ProductDto productDto1 = this.productService.updateProduct(productDto, productId);
        return new ResponseEntity<>(productDto1,HttpStatus.OK);
    }

    // get Product
    @GetMapping("product/{productId}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable Integer productId){
        ProductDto product = this.productService.getProduct(productId);
        return new ResponseEntity<>(product,HttpStatus.OK);
    }

    //get all product
    @GetMapping("product/")
    public ResponseEntity<List<ProductDto>> getAllProduct(){
        List<ProductDto> allProduct = this.productService.getAllProduct();
        return new ResponseEntity<>(allProduct,HttpStatus.OK);
    }

    //delete product
    @DeleteMapping("product/{productId}")
    public ResponseEntity<ApiResponse> deleteProduct(@PathVariable Integer productId){
        String message = this.productService.deleteProduct(productId);
        return new ResponseEntity<>(new ApiResponse(message,true),HttpStatus.OK);
    }

    // I got error here please check once..
    @GetMapping("category/{categoryId}/product/")
    public ResponseEntity<List<ProductDto>> getAllProductsByCategory(@PathVariable Integer categoryId){
        List<ProductDto> allProduct = this.productService.getAllProductsByCategory(categoryId);
        return new ResponseEntity<>(allProduct,HttpStatus.OK);
    }

}
