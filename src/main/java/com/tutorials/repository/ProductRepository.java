package com.tutorials.repository;

import com.tutorials.models.Category;
import com.tutorials.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    public List<Product> findByCategory(Category category);
}
