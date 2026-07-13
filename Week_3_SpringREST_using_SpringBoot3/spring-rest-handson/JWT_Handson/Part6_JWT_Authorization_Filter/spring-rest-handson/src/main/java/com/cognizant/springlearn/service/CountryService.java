package com.cognizant.springlearn.service;

import com.cognizant.springlearn.dao.CountryDao;
import com.cognizant.springlearn.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryDao countryDao;

    public Country getCountry(String code) {

        List<Country> countryList = countryDao.getCountryList();

        for (Country country : countryList) {

            if (country.getCode().equalsIgnoreCase(code)) {

                return country;

            }

        }

        return null;

    }

}