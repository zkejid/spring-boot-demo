package com.github.zkejid.springdemo.service;

import java.util.List;

import com.github.zkejid.springdemo.entities.Employee;
import org.springframework.data.repository.CrudRepository;

/**
 * Employee repository. Defines basic CRUD operations on {@link Employee}.
 * <p/>
 * Repository defines custom search operation {@link #findByName(String)}.
 */
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    //TODO Panfilov I.V. 10.08.17: need more code coverage.

    List<Employee> findByName(String lastName);
}