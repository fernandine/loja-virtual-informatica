package com.jean.ecommerce.repositories;

import com.jean.ecommerce.entities.Cart;
import com.jean.ecommerce.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

}
