package com.experimentation.fullspringproject.domain.repository;

import com.experimentation.fullspringproject.domain.Book;

public interface BookRepository {

  Book save(Book book);

  long count();
}
