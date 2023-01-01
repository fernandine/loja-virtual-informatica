package com.jean.shop.ecommerce.services;

import com.jean.shop.ecommerce.dto.ProductCategoryDTO;
import com.jean.shop.ecommerce.entities.ProductCategory;
import com.jean.shop.ecommerce.repositories.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductCategoryService {

    @Autowired
    private ProductCategoryRepository repository;

    public Page<ProductCategoryDTO> findAllPaged(Pageable pageable) {
        Page<ProductCategory> entity = repository.findAll(pageable);
        return entity.map(x -> new ProductCategoryDTO(x));
    }
}
