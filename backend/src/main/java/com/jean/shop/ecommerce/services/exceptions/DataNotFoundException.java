package com.jean.shop.ecommerce.services.exceptions;

public class DataNotFoundException extends RuntimeException {
    public DataNotFoundException(String msg) {
        super(msg);
    }
}
