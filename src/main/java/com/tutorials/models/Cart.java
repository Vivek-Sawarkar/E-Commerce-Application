package com.tutorials.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer cartId;


    @OneToOne
    private User user;

    @OneToMany(mappedBy = "cart")
    private Set<CartItems> items=new HashSet<>();
}
