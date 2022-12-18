package com.jean.ecommerce.services;

import com.jean.ecommerce.dtos.CategoryDto;
import com.jean.ecommerce.entities.Category;
import com.jean.ecommerce.repositories.CategoryRepository;
import com.jean.ecommerce.services.exceptions.DatabaseException;
import com.jean.ecommerce.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public Page<CategoryDto> findAllPaged(Pageable pageable) {
        Page<Category> list = categoryRepository.findAll(pageable);
        return list.map(x -> new CategoryDto(x));
    }

    @Transactional(readOnly = true)
    public CategoryDto findById(Long id) {
        Optional<Category> obj = categoryRepository.findById(id);
        Category entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new CategoryDto(entity);
    }

    @Transactional
    public CategoryDto insert(CategoryDto dto) {
        Category entity = new Category();
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setImgUri(dto.getImgUri());
        entity = categoryRepository.save(entity);
        return new CategoryDto(entity);
    }

    public CategoryDto update(Long id, CategoryDto dto) {
        try {
            Category entity = categoryRepository.getReferenceById(id);
            entity.setName(dto.getName());
            entity.setDescription(dto.getDescription());
            entity.setPrice(dto.getPrice());
            entity.setImgUri(dto.getImgUri());
            entity = categoryRepository.save(entity);
            return new CategoryDto(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        }
    }

    public void delete(Long id) {
        try {
            categoryRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Integrity violation");
        }
    }
}
