package com.experimentation.fullspringproject.domain;

import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "post")
@RequiredArgsConstructor
@NoArgsConstructor
public class Post {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NonNull
  private String title;

  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "post", optional = false)
  private PostDetails details;

  public Post addDetails(PostDetails details) {
    if (details == null) {
      if (this.details != null) {
        this.details.addPost(null);
      }
    } else {
      details.addPost(this);
    }
    this.details = details;
    return this;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!(obj instanceof Post post))
      return false;
    return Objects.equals(id, post.id) &&
        Objects.equals(title, post.title);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title);
  }
}
