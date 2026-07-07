package com.cognizant.orm_learn;

import com.cognizant.orm_learn.model.Department;
import com.cognizant.orm_learn.model.Employee;
import com.cognizant.orm_learn.service.DepartmentService;
import com.cognizant.orm_learn.service.EmployeeService;
import com.cognizant.orm_learn.service.SkillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

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

        LOGGER.info("Inside Main");

        employeeService = context.getBean(EmployeeService.class);
        departmentService = context.getBean(DepartmentService.class);
        skillService = context.getBean(SkillService.class);

        /*
         * Uncomment ONLY ONE test method at a time.
         */

        testGetEmployee();

        testAddEmployee();

        testUpdateEmployee();
    }

    /**
     * Fetch Employee along with Department
     */
    private static void testGetEmployee() {

        LOGGER.info("Start");

        Employee employee = employeeService.get(1);

        LOGGER.debug("Employee : {}", employee);

        LOGGER.debug("Department : {}", employee.getDepartment());

        LOGGER.info("End");
    }

    /**
     * Add New Employee
     */
    private static void testAddEmployee() {

        LOGGER.info("Start");

        Employee employee = new Employee();

        employee.setName("David Miller");
        employee.setSalary(65000);
        employee.setPermanent(true);
        employee.setDateOfBirth(LocalDate.of(1998, 5, 20));

        Department department = departmentService.get(1);

        employee.setDepartment(department);

        employeeService.save(employee);

        LOGGER.debug("Employee : {}", employee);

        LOGGER.info("End");
    }

    /**
     * Update Employee Department
     */
    private static void testUpdateEmployee() {

        LOGGER.info("Start");

        Employee employee = employeeService.get(1);

        Department department = departmentService.get(3);

        employee.setDepartment(department);

        employeeService.save(employee);

        LOGGER.debug("Employee : {}", employee);

        LOGGER.info("End");
    }
}