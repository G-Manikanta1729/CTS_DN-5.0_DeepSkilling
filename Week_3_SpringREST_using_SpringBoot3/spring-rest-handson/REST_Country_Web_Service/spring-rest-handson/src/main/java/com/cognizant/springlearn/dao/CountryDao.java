package com.cognizant.springlearn.dao;

import com.cognizant.springlearn.model.Country;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

@Repository
public class CountryDao {

    public Country getCountry() {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("country.xml");

        return context.getBean("country", Country.class);
    }
}