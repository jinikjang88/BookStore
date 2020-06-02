package com.ikjin.adminserver.repository.book;

import com.ikjin.adminserver.entity.book.BookRentalEntity;
import com.ikjin.adminserver.entity.book.QBookEntity;
import com.ikjin.adminserver.entity.book.QBookRentalEntity;
import com.querydsl.jpa.impl.JPAQuery;
import java.util.List;
import java.util.UUID;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class BookRentalCustomRepository {

  @PersistenceContext
  private EntityManager entityManager;

  public List<BookRentalEntity> listBookRentalByBookId(UUID bookId) {
    JPAQuery<?> query = new JPAQuery<>(entityManager);

    QBookEntity qBookEntity = QBookEntity.bookEntity;
    QBookRentalEntity qBookRentalEntity = QBookRentalEntity.bookRentalEntity;

    List<BookRentalEntity> fetched = query.select(qBookRentalEntity)
        .from(qBookRentalEntity)
        .leftJoin(qBookEntity)
        .on(qBookRentalEntity.bookEntity.id.eq(qBookEntity.id))
        .where(qBookRentalEntity.bookEntity.id.eq(bookId))
        .fetch();

    return fetched;

  }

}
