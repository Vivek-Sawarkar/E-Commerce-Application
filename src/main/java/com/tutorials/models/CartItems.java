package com.tutorials.models;


import javax.persistence.*;

@Entity
public class CartItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cartItemId;

    @OneToOne
    private  Product product;

    private Integer quantity;

    private double totalProductPrice;

    //cart and cartItem relationship
    @ManyToOne
    private Cart cart;

    //getter and setters
    public Integer getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(Integer cartItemId) {
        this.cartItemId = cartItemId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public double getTotalProductPrice() {
        return totalProductPrice;
    }


    //here we set the total price of items using formula
    public void setTotalProductPrice(double totalProductPrice) {
        this.totalProductPrice = this.product.getPrice() * this.getQuantity();
    }
}
