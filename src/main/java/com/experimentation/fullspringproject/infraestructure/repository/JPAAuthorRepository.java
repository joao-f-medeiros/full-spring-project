package com.experimentation.fullspringproject.infraestructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.experimentation.fullspringproject.domain.Author;

public interface JPAAuthorRepository extends JpaRepository<Author, Long> {

}
