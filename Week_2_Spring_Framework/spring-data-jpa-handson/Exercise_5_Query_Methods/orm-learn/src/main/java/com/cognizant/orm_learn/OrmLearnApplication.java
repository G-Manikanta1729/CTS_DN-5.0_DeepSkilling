package com.cognizant.orm_learn;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.service.CountryService;
import com.cognizant.orm_learn.service.exception.CountryNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class OrmLearnApplication {

	private static final Logger LOGGER =
			LoggerFactory.getLogger(OrmLearnApplication.class);

	private static CountryService countryService;

	public static void main(String[] args)
			throws CountryNotFoundException {

		ApplicationContext context =
				SpringApplication.run(
						OrmLearnApplication.class,
						args);

		countryService =
				context.getBean(CountryService.class);

		testSearchCountryContaining();

		testSearchCountryContainingSorted();

		testSearchCountryStartingWith();

	}

	private static void testSearchCountryContaining() {

		LOGGER.info("Start");

		List<Country> countries =
				countryService.searchCountries("ou");

		countries.forEach(country ->
				LOGGER.debug("{}", country));

		LOGGER.info("End");

	}

	private static void testSearchCountryContainingSorted() {

		LOGGER.info("Start");

		List<Country> countries =
				countryService.searchCountriesSorted("ou");

		countries.forEach(country ->
				LOGGER.debug("{}", country));

		LOGGER.info("End");

	}

	private static void testSearchCountryStartingWith() {

		LOGGER.info("Start");

		List<Country> countries =
				countryService.searchCountriesStartingWith("Z");

		countries.forEach(country ->
				LOGGER.debug("{}", country));

		LOGGER.info("End");

	}

}