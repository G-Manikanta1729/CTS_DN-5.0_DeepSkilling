package com.cognizant.orm_learn;

import com.cognizant.orm_learn.model.Department;
import com.cognizant.orm_learn.model.Employee;
import com.cognizant.orm_learn.model.Skill;
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

        /*
         * Run ONLY ONE test at a time
         */

        //testGetEmployee();

        testAddSkillToEmployee();

    }

    /**
     * Fetch Employee along with Department and Skills
     */
    private static void testGetEmployee() {

        LOGGER.info("Start");

        Employee employee = employeeService.get(1);

        LOGGER.debug("Employee : {}", employee);

        LOGGER.debug("Department : {}", employee.getDepartment());

        LOGGER.debug("Skills : {}", employee.getSkillList());

        LOGGER.info("End");

    }

    /**
     * Add Skill to Employee
     */
    private static void testAddSkillToEmployee() {

        LOGGER.info("Start");

        /*
         * Choose employee and skill which are
         * not already mapped.
         */

        Employee employee = employeeService.get(2);

        Skill skill = skillService.get(3);

        employee.getSkillList().add(skill);

        employeeService.save(employee);

        LOGGER.debug("Employee : {}", employee);

        LOGGER.info("End");

    }

}