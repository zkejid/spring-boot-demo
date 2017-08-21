package com.github.zkejid.springdemo.web;

import com.github.zkejid.springdemo.entities.Employee;
import com.github.zkejid.springdemo.service.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Controller defines web access to application.
 *
 * TODO Panfilov I.V. 10.08.17: add 'list all' handler, 'get by id' handler.
 */
@RestController
public class ApplicationController {

    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * Index page handler.
     * <p/>
     * Returns description of application service.
     */
    @RequestMapping("/")
    public String index() {
        return "Employee CRUD application";
    }

    /**
     * Custom search handler
     * <p/>
     * Returns all employee instances matching given name string.
     * <p/>
     * TODO Panfilov I.V. 10.08.17: test it. check corner cases of 'name' argument.
     * @param name search argument - {@link Employee#name}.
     * @return list of employees, which name equals to given name argument
     */
    @RequestMapping("/employee/byname")
    public List<Employee> byName(@RequestParam(value="name") String name) {
        return employeeRepository.findByName(name);
    }

    /**
     * Employee creation handler.
     * <p/>
     * Places new employee instance with given attribute values into DB.
     * <p/>
     * TODO Panfilov I.V. 10.08.17: test it. check corner cases of arguments.
     * @param name {@link Employee#name}
     * @param grade {@link Employee#grade}
     * @param hiredDate {@link Employee#hiredDate}
     * @param firedDate {@link Employee#firedDate}
     * @return newly created and persisted instance of Employee
     */
    @RequestMapping("/employee/create")
    public Employee create(
            @RequestParam(value="name") String name,
            @RequestParam(value="grade") String grade,
            @RequestParam(value="hiredDate") Date hiredDate,
            @RequestParam(value="firedDate") Date firedDate,
            @RequestParam(value="salary") BigDecimal salary
    ) {
        return employeeRepository.save(new Employee(name, grade, hiredDate, firedDate, salary));
    }

    /**
     * Employee list handler.
     * <p/>
     * lists available employee instances
     * <p/>
     * TODO Panfilov I.V. 10.08.17: test it.
     * TODO Panfilov I.V. 10.08.17: avoid OOME on large dataset. add restrictions
     * @return lis of employee instances
     */
    @RequestMapping("/employee/list")
    public Iterable<Employee> list() {
        return employeeRepository.findAll();
    }
}