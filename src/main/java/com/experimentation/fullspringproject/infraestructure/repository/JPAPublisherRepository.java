package com.experimentation.fullspringproject.infraestructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.experimentation.fullspringproject.domain.Publisher;

public interface JPAPublisherRepository extends JpaRepository<Publisher, Long> {

}
