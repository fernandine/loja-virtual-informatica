package com.jean.ecommerce.services;

import com.jean.ecommerce.dtos.CartDto;
import com.jean.ecommerce.entities.Cart;
import com.jean.ecommerce.repositories.CartRepository;
import com.jean.ecommerce.services.exceptions.DatabaseException;
import com.jean.ecommerce.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Transactional(readOnly = true)
    public List<CartDto> findAll() {
        List<Cart> list = cartRepository.findAll();
        return list.stream().map(x -> new CartDto(x)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public CartDto findById(Long id) {
        Optional<Cart> obj = cartRepository.findById(id);
        Cart cart = obj.orElseThrow(
                () -> new ResourceNotFoundException("Resource not found!"));
        return new CartDto(cart);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        try {
            cartRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Resource not found " + id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Integrity violation");
        }
    }

}
