package com.tutorials.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

    @Column(name = "product_name", length = 300, unique = true)
    private String name;

    private String description;

    private String quantity;

    private double price;

    private  String imageName;

    private  boolean stock=true;

    private boolean live;

    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;





}
