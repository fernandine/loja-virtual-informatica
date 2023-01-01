package com.jean.shop.ecommerce.repositories;

import com.jean.shop.ecommerce.entities.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Long> {
}
