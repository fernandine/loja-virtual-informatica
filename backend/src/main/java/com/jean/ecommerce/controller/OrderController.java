package com.jean.ecommerce.controller;

import com.jean.ecommerce.dtos.OrderDto;
import com.jean.ecommerce.dtos.ProductDto;
import com.jean.ecommerce.entities.Order;
import com.jean.ecommerce.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderDto>> findAll(){
        List<OrderDto> list = orderService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> find(@PathVariable Long id) {
        OrderDto obj = orderService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
/*

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        OrderService.delete(id);
        return ResponseEntity.noContent().build();
    }*/
}
