package com.experimentation.fullspringproject.domain.repository;

import com.experimentation.fullspringproject.domain.Publisher;

public interface PublisherRepository {

  Publisher save(Publisher publisher);

  long count();
}
