package com.experimentation.fullspringproject.domain;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "post_details")
@RequiredArgsConstructor
@NoArgsConstructor
public class PostDetails {

  @Id
  private Long id;

  @Column(name = "created_on")
  private LocalDateTime createdOn = LocalDateTime.now();

  @NonNull
  @Column(name = "created_by")
  private String createdBy;

  @OneToOne(fetch = FetchType.LAZY)
  @MapsId
  @JoinColumn(name = "id")
  private Post post;

  public void addPost(Post post) {
    this.post = post;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!(obj instanceof PostDetails details))
      return false;
    return Objects.equals(id, details.id) &&
        Objects.equals(createdOn, details.createdOn) &&
        Objects.equals(createdBy, details.createdBy) &&
        Objects.equals(post, details.post);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, createdOn, createdBy, post);
  }

}
