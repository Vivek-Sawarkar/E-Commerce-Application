package com.tutorials.repository;


import com.tutorials.models.Product_Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Product_Order,Integer> {
}
