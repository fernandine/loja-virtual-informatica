package com.jean.shop.ecommerce.controllers;

import com.jean.shop.ecommerce.dto.OrderDTO;
import com.jean.shop.ecommerce.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

    @Autowired
    private OrderService service;

    @GetMapping(value = "/search")
    public ResponseEntity<Page<OrderDTO>> findSalesByEmail(
            @RequestParam(value = "email") String email, Pageable pageable) {
        return ResponseEntity.ok().body(service.findByEmail(email, pageable));
    }
}
