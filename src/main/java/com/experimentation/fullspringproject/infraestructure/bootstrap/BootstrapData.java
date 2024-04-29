package com.experimentation.fullspringproject.infraestructure.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.experimentation.fullspringproject.domain.Author;
import com.experimentation.fullspringproject.domain.Book;
import com.experimentation.fullspringproject.domain.Publisher;
import com.experimentation.fullspringproject.infraestructure.repository.h2.H2DBAuthorRepository;
import com.experimentation.fullspringproject.infraestructure.repository.h2.H2DBBookRepository;
import com.experimentation.fullspringproject.infraestructure.repository.h2.H2DBPublisherRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class BootstrapData implements CommandLineRunner {

  private H2DBAuthorRepository authorRepository;
  private H2DBBookRepository bookRepository;
  private H2DBPublisherRepository publisherRepository;

  @Override
  public void run(String... args) throws Exception {
    var publisher = new Publisher("John", "Main St", "New York", "NY", "234324");
    publisherRepository.save(publisher);

    System.out.println("Number of publishers: " + publisherRepository.count());

    var author = new Author("Eric", "Evans");
    var book = new Book("Domain Driven Design", "123323", publisher);
    // Refactor add books and authors
    author.addBook(book);
    book.addAuthor(author);
    publisher.addBook(book);

    authorRepository.save(author);
    bookRepository.save(book);
    publisherRepository.save(publisher);

    var author2 = new Author("Rod", "Johnson");
    var book2 = new Book("J2EE Development without EJB", "3939459459", publisher);
    author2.addBook(book2);
    book2.addAuthor(author2);
    publisher.addBook(book2);

    authorRepository.save(author2);
    bookRepository.save(book2);
    publisherRepository.save(publisher);

    System.out.println("Started in Bootstrap");
    System.out.println("Number of books: " + bookRepository.count());
  }

}
