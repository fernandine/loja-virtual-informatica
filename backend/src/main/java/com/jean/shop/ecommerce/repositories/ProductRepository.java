package com.jean.shop.ecommerce.repositories;

import com.jean.shop.ecommerce.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findByCategoryId(@Param("id") Long id, Pageable pageable);

    Page<Product> findByNameContainingIgnoreCase(@Param("name") String name, Pageable pageable);

    Optional<Product> findById(Long id);
}
