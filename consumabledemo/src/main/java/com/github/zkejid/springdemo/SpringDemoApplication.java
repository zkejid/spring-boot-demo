package com.github.zkejid.springdemo;

import com.github.zkejid.springdemo.entities.Employee;
import com.github.zkejid.springdemo.service.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
public class SpringDemoApplication {

	@Autowired
	private EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringDemoApplication.class, args);
	}


	// serves as listener on application startup
	@Bean
	public CommandLineRunner bootstrap(ApplicationContext ctx) {
		return args -> {
			employeeRepository.save(new Employee("John Doe", "SEO", new Date(), new Date(), new BigDecimal(1005.1)));
			employeeRepository.save(new Employee("John Doe", "Senior", new Date(), new Date(), new BigDecimal(800.1)));
			employeeRepository.save(new Employee("Jillian Doe", "Middle", new Date(), new Date(), new BigDecimal(500.1)));
			employeeRepository.save(new Employee("John Smith", "Junior", new Date(), new Date(), new BigDecimal(100.1)));
		};
	}
}
