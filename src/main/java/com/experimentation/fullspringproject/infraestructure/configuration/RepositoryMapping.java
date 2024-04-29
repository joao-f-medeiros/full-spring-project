package com.experimentation.fullspringproject.infraestructure.configuration;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.experimentation.fullspringproject.infraestructure.repository.h2.H2DBBookRepository;

@EnableJpaRepositories(basePackageClasses = H2DBBookRepository.class)
public class RepositoryMapping {

}
