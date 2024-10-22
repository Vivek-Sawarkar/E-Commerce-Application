package com.tutorials.service.impl;

import com.tutorials.dtos.ProductDto;
import com.tutorials.exception.ResourceNotFoundException;
import com.tutorials.models.Category;
import com.tutorials.models.Product;
import com.tutorials.repository.CategoryRepository;
import com.tutorials.repository.ProductRepository;
import com.tutorials.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProductDto createProduct(ProductDto productDto, Integer categoryId) {

        Category category = this.categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Given category is not found.."));
        Product product = modelMapper.map(productDto, Product.class);
        product.setCategory(category);
        Product savedProduct = this.productRepository.save(product);
        return modelMapper.map(savedProduct,ProductDto.class);
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto, Integer productId) {

        Product product = this.productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("This Product is not available with product id: " + productId));
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setLive(productDto.isLive());
        product.setPrice(productDto.getPrice());
        product.setStock(productDto.isStock());
        product.setImageName(productDto.getImageName());

        Product savedProduct = this.productRepository.save(product);

        return this.modelMapper.map(savedProduct, ProductDto.class);
    }

    @Override
    public String deleteProduct(Integer productId) {
        Product product = this.productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("The product is not available with productId: " + productId));
        this.productRepository.delete(product);
        return "product deleted successfully..!!!";
    }

    @Override
    public ProductDto getProduct(Integer productId) {
        Product product = this.productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("This product is not available with product id : " + productId));
        return this.modelMapper.map(product,ProductDto.class);
    }

    @Override
    public List<ProductDto> getAllProduct() {
        List<Product> allProducts = this.productRepository.findAll();
        List<ProductDto> dtos = allProducts.stream().map(product -> this.modelMapper.map(product, ProductDto.class)).collect(Collectors.toList());
        return dtos;
    }

    @Override
    public List<ProductDto> getAllProductsByCategory(Integer categoryId) {

        Category category = this.categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Given category is not available "));

        List<Product> products = this.productRepository.findByCategory(category);
        List<ProductDto> productDtos = products.stream().map(product -> this.modelMapper.map(product, ProductDto.class)).collect(Collectors.toList());
        return productDtos;
    }
}
