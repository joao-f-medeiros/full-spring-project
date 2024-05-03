package com.experimentation.fullspringproject.domain;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "author")
public class Author {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @NonNull
  private String firstName;
  @NonNull
  private String lastName;
  @ManyToMany(mappedBy = "authors")
  private Set<Book> books = new HashSet<>();

  public void addBook(Book book) {
    if (book != null) {
      book.addAuthor(this);
      books.add(book);
    }
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstName, lastName);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!(obj instanceof Author author))
      return false;
    return Objects.equals(id, author.id)
        && Objects.equals(firstName, author.firstName)
        && Objects.equals(lastName, author.lastName);
  }

}
