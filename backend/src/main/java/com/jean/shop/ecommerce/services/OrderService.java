package com.jean.shop.ecommerce.services;

import com.jean.shop.ecommerce.dto.OrderDTO;
import com.jean.shop.ecommerce.entities.Order;
import com.jean.shop.ecommerce.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public Page<OrderDTO> findByEmail(String email, Pageable pageable) {
        Page<Order> orders = repository.findByCustomerEmailOrderByDateCreatedDesc(email, pageable);
        Page<OrderDTO> dto = orders.map(x -> new OrderDTO(x));
        return dto;
    }
}
