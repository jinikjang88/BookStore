package com.ikjin.adminserver.entity.book;

import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;

@Entity
@Getter
@Setter
@Table(name = "book_rental")
public class BookRentalEntity {

  @Id
  @Type(type = "uuid-char")
  @GeneratedValue
  private UUID id;

  @ManyToOne(targetEntity = BookEntity.class)
  @JoinColumn(name = "book_id")
  private BookEntity bookEntity;

  @Column(nullable = false)
  private String userId;

  @Column(nullable = false)
  private String userName;

  @Column(nullable = false)
  private boolean returned = false;

  @Column(nullable = false, updatable = false)
  @Temporal(TemporalType.TIMESTAMP)
  @CreationTimestamp
  private Date createAt;

  // default and all args constructor...
  // getters and setters...
  // toString...
}
