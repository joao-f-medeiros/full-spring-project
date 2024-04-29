package com.experimentation.fullspringproject.infraestructure.repository.h2;

import org.springframework.stereotype.Component;

import com.experimentation.fullspringproject.domain.Author;
import com.experimentation.fullspringproject.domain.repository.AuthorRepository;
import com.experimentation.fullspringproject.infraestructure.repository.JPAAuthorRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class H2DBAuthorRepository implements AuthorRepository {

  private JPAAuthorRepository authorRepository;

  @Override
  public Author save(Author book) {
    return authorRepository.save(book);
  }

}
