package com.github.zkejid.springdemo;

import com.github.zkejid.springdemo.service.TextEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * CRUD service application for {@link com.github.zkejid.springdemo.entities.TextEntity} entites.
 * Actually doesn't provide fully CRUD set of operations. More info in README file.
 */
@SpringBootApplication
public class SpringDemoApplication {

	@SuppressWarnings("unused")	//cause autowired
	@Autowired
	private TextEntityRepository textEntityRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringDemoApplication.class, args);
	}

}
