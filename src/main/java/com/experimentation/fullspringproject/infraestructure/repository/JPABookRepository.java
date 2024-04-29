package com.experimentation.fullspringproject.infraestructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.experimentation.fullspringproject.domain.Book;

public interface JPABookRepository extends JpaRepository<Book, Long> {

}
