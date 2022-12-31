package com.jean.ecommerce.dtos;

import com.jean.ecommerce.entities.Cart;

import java.util.HashSet;
import java.util.Set;

public class CartDto {

    private String id;

    private double quantity;

    private double subtotal;

    private Set<ProductDto> products = new HashSet<ProductDto>();

    public CartDto() {
    }

    public CartDto(String id, double quantity, double subtotal) {
        this.id = id;
        this.quantity = quantity;
        this.subtotal = subtotal;
    }

    public CartDto(Cart entity) {
        id = entity.getId();
        quantity = entity.getQuantity();
        subtotal = entity.getSubtotal();
        entity.getProducts().forEach(product -> this.products.add(new ProductDto(product)));
    }

}
