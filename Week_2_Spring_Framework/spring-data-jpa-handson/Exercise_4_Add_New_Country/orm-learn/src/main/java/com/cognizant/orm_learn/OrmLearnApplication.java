package com.cognizant.orm_learn;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.service.CountryService;
import com.cognizant.orm_learn.service.exception.CountryNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class OrmLearnApplication {

	private static final Logger LOGGER =
			LoggerFactory.getLogger(OrmLearnApplication.class);

	private static CountryService countryService;

	public static void main(String[] args) throws CountryNotFoundException {

		ApplicationContext context =
				SpringApplication.run(
						OrmLearnApplication.class,
						args);

		countryService =
				context.getBean(CountryService.class);

		testAddCountry();

	}

	private static void testAddCountry()
			throws CountryNotFoundException {

		LOGGER.info("Start");

		Country country = new Country();

		country.setCode("NP");

		country.setName("Nepal");

		countryService.addCountry(country);

		Country addedCountry =
				countryService.findCountryByCode("NP");

		LOGGER.debug("Country : {}", addedCountry);

		LOGGER.info("End");

	}

}