package com.experimentation.fullspringproject.infraestructure.repository.h2;

import org.springframework.stereotype.Component;

import com.experimentation.fullspringproject.domain.Book;
import com.experimentation.fullspringproject.domain.repository.BookRepository;
import com.experimentation.fullspringproject.infraestructure.repository.JPABookRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class H2DBBookRepository implements BookRepository {

  private final JPABookRepository bookRepository;

  @Override
  public Book save(Book book) {
    return bookRepository.save(book);
  }

  @Override
  public long count() {
    return bookRepository.count();
  }

}
