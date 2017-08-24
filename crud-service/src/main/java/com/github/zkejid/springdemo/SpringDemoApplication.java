package com.github.zkejid.springdemo;

import com.github.zkejid.springdemo.entities.TextEntity;
import com.github.zkejid.springdemo.service.TextEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class SpringDemoApplication {

	@Autowired
	private TextEntityRepository textEntityRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringDemoApplication.class, args);
	}


	// serves as listener on application startup
	@Bean
	public CommandLineRunner bootstrap(ApplicationContext ctx) {
		return args -> {
			textEntityRepository.save(new TextEntity("John Doe", "SEO", new Date()));
			textEntityRepository.save(new TextEntity("John Doe", "Senior", new Date()));
			textEntityRepository.save(new TextEntity("Jillian Doe", "Middle", new Date()));
			textEntityRepository.save(new TextEntity("John Smith", "Junior", new Date()));
		};
	}
}
