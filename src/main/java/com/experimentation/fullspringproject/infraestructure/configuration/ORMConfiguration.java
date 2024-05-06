package com.experimentation.fullspringproject.infraestructure.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.experimentation.fullspringproject.infraestructure.repository.JPAAuthorRepository;

@EnableJpaRepositories(basePackageClasses = JPAAuthorRepository.class)
@EntityScan({ "com.experimentation.fullspringproject.domain" })
public class ORMConfiguration {

}
