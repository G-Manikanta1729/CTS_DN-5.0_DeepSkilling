package com.cognizant.orm_learn.service;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.repository.CountryRepository;
import com.cognizant.orm_learn.service.exception.CountryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Transactional(readOnly = true)
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Country findCountryByCode(String countryCode)
            throws CountryNotFoundException {

        Optional<Country> result =
                countryRepository.findById(countryCode);

        if (!result.isPresent()) {
            throw new CountryNotFoundException(
                    "Country not found : " + countryCode);
        }

        return result.get();
    }

    @Transactional
    public void addCountry(Country country) {

        countryRepository.save(country);

    }

    // ********************************************
    // Query Method 1
    // ********************************************

    @Transactional(readOnly = true)
    public List<Country> searchCountries(String text) {

        return countryRepository.findByNameContaining(text);

    }

    // ********************************************
    // Query Method 2
    // ********************************************

    @Transactional(readOnly = true)
    public List<Country> searchCountriesSorted(String text) {

        return countryRepository
                .findByNameContainingOrderByNameAsc(text);

    }

    // ********************************************
    // Query Method 3
    // ********************************************

    @Transactional(readOnly = true)
    public List<Country> searchCountriesStartingWith(String alphabet) {

        return countryRepository
                .findByNameStartingWith(alphabet);

    }

}