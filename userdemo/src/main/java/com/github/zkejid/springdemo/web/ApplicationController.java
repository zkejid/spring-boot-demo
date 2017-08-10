package com.github.zkejid.springdemo.web;

import com.github.zkejid.springdemo.entities.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Controller defines web access to application.
 */
@RestController
public class ApplicationController {

    //TODO Panfilov I.V. 10.08.17: move connection string to configuration
    public static final String EMPLOYEE_SERVICE_URL = "http://localhost:8090/employee/list";

    /**
     * Index page handler.
     * <p/>
     * Returns description of application service.
     */
    @RequestMapping("/")
    public String index() {
        return "Employee statistics application";
    }

    /**
     * Statistics page handler.
     * <p/>
     * Prepares simple statistics on Employees Service
     * @return text report
     */
    @RequestMapping("/statistics")
    public String statistics() {
        RestTemplate restTemplate = new RestTemplate();
        // we are using array instead of java collection cause
        // https://stackoverflow.com/questions/23674046/get-list-of-json-objects-with-spring-resttemplate
        ResponseEntity<Employee[]> forEntity
                = restTemplate.getForEntity(EMPLOYEE_SERVICE_URL, Employee[].class);

        Employee[] body = forEntity.getBody();

        int count = 0;

        for (Employee employee : body) {
            count++;
        }

        StringBuilder sb = new StringBuilder("Statistics").append(System.lineSeparator());
        sb.append("\tentity count: ").append(count);

        return sb.toString();
    }
}