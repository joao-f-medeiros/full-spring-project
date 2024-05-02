package com.experimentation.fullspringproject.infraestructure.repository.h2;

import org.springframework.stereotype.Component;

import com.experimentation.fullspringproject.domain.Publisher;
import com.experimentation.fullspringproject.domain.repository.PublisherRepository;
import com.experimentation.fullspringproject.infraestructure.repository.JPAPublisherRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class H2DBPublisherRepository implements PublisherRepository {

  private final JPAPublisherRepository publisherRepository;

  @Override
  public Publisher save(Publisher publisher) {
    return publisherRepository.save(publisher);
  }

  @Override
  public long count() {
    return publisherRepository.count();
  }

}
