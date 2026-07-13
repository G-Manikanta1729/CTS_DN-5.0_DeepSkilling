package com.cognizant.springlearn.dao;

import com.cognizant.springlearn.model.Country;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CountryDao {

    @SuppressWarnings("unchecked")
    public List<Country> getCountryList() {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("country.xml");

        return (List<Country>) context.getBean("countryList");

    }

}