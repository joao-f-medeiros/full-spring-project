package com.experimentation.fullspringproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.experimentation.fullspringproject.infraestructure.repository.JPAAuthorRepository;

@EnableJpaRepositories(basePackageClasses = JPAAuthorRepository.class)
@EntityScan({ "com.experimentation.fullspringproject.domain" })
@SpringBootApplication
public class FullSpringProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FullSpringProjectApplication.class, args);
	}

}
