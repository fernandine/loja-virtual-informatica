package com.jean.shop.ecommerce.services;

import com.jean.shop.ecommerce.dto.CountryDTO;
import com.jean.shop.ecommerce.entities.Country;
import com.jean.shop.ecommerce.repositories.CountryRepository;
import com.jean.shop.ecommerce.services.exceptions.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository repository;

    @Transactional(readOnly = true)
    public Page<CountryDTO> findAllPaged(Pageable pageable) {
        Page<Country> found = repository.findAll(pageable);
        return found.map(x -> new CountryDTO(x));
    }

    @Transactional(readOnly = true)
    public CountryDTO findOneById(Long id) {
        Optional<Country> obj = repository.findById(id);
        Country country = obj.orElseThrow(() -> new DataNotFoundException("Country not founded."));
        return new CountryDTO(country);
    }
}
