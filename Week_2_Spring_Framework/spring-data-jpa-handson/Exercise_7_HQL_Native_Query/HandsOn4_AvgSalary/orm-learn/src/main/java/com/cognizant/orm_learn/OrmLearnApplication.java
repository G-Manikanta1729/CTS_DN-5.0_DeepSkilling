package com.cognizant.orm_learn;

import com.cognizant.orm_learn.service.DepartmentService;
import com.cognizant.orm_learn.service.EmployeeService;
import com.cognizant.orm_learn.service.SkillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(OrmLearnApplication.class);

    private static EmployeeService employeeService;
    private static DepartmentService departmentService;
    private static SkillService skillService;

    public static void main(String[] args) {

        ApplicationContext context =
                SpringApplication.run(
                        OrmLearnApplication.class,
                        args);

        employeeService = context.getBean(EmployeeService.class);
        departmentService = context.getBean(DepartmentService.class);
        skillService = context.getBean(SkillService.class);

        testGetAverageSalary();
    }

    private static void testGetAverageSalary() {

        LOGGER.info("Start");

        int departmentId = 2;

        double averageSalary =
                employeeService.getAverageSalary(departmentId);

        LOGGER.debug("Average Salary of Department {} : {}",
                departmentId,
                averageSalary);

        LOGGER.info("End");
    }
}