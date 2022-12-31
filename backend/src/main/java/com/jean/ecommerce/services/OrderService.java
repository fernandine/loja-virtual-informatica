package com.jean.ecommerce.services;

import com.jean.ecommerce.dtos.OrderDto;
import com.jean.ecommerce.entities.Order;
import com.jean.ecommerce.repositories.OrderRepository;
import com.jean.ecommerce.services.exceptions.DatabaseException;
import com.jean.ecommerce.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Transactional(readOnly = true)
    public List<OrderDto> findAll() {
        List<Order> list = orderRepository.findAll();
        return list.stream().map(x -> new OrderDto(x)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public OrderDto findById(Long id) {
        Optional<Order> obj = orderRepository.findById(id);
        Order order = obj.orElseThrow(
                () -> new ResourceNotFoundException("Resource not found!"));
        return new OrderDto(order);
    }

    public void delete(Long id) {
        try {
            orderRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Resource not found " + id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Integrity violation");
        }
    }
}
