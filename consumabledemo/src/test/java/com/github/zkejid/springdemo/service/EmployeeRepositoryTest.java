package com.github.zkejid.springdemo.service;

import com.github.zkejid.springdemo.entities.Employee;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeRepositoryTest {
    @Autowired EmployeeRepository employeeRepository;

    @Before
    public void setUp() throws Exception {
        //TODO Panfilov I.V. 10.08.17: avoid influence between test calls
        // without delete all there is bootstrap data visible:
        // com.github.zkejid.springdemo.SpringDemoApplication.bootstrap()
        employeeRepository.deleteAll();
        employeeRepository.save(new Employee("John Doe", "SEO", new Date(), new Date(), new BigDecimal(1005.1)));
        employeeRepository.save(new Employee("John Doe", "Senior", new Date(), new Date(), new BigDecimal(800.1)));
        employeeRepository.save(new Employee("Jillian Doe", "Middle", new Date(), new Date(), new BigDecimal(500.1)));
        employeeRepository.save(new Employee("John Smith", "Junior", new Date(), new Date(), new BigDecimal(100.1)));
    }

    @After
    public void tearDown() throws Exception {
        employeeRepository.deleteAll();
    }

    /**
     * Scenario: Looking for Employee instances with given name.
     * Data: valid name, represented in DB
     * Expected: service should return employee instances with given name
     */
    @Test
    public void findByNamePositive() {
        List<Employee> list = employeeRepository.findByName("John Doe");

        Assert.assertNotNull("Null list instance", list);
        Assert.assertEquals("Wrong instance count", 2, list.size());
    }

    /**
     * Scenario: Looking for Employee instances with given name.
     * Data: DB doesn't contain given name
     * Expected: service should return empty list
     */
    @Test
    public void findByNameNegative() {
        List<Employee> list = employeeRepository.findByName("Mike Wallberg");

        Assert.assertNotNull("Null list instance", list);
        Assert.assertEquals("Wrong instance count", 0, list.size());
    }

}