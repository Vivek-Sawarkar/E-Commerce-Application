package com.tutorials.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderItemId;

    //this is for product_order and orderItem relationship
    @ManyToOne
    private Product_Order product_order;

    @OneToOne
    private  Product product;

    private Integer quantity;

    private double totalProductPrice;

}
