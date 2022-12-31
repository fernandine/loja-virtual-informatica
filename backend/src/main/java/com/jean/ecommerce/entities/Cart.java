package com.jean.ecommerce.entities;

import ch.qos.logback.core.net.server.Client;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;

import java.util.Set;

@Entity
@Table(name = "tb_cart")
public class Cart implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private double quantity;

    private double subtotal;

    @OneToMany(mappedBy = "cart")
    private Set<Product> products = new HashSet<>();

    public Cart() {
    }

    public Cart(String id, Client client, double quantity, double subtotal) {
        this.id = id;
        this.quantity = quantity;
        this.subtotal = subtotal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Set<Product> getProducts() {
        return products;
    }
}