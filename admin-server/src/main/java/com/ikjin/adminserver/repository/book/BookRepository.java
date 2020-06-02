package com.ikjin.adminserver.repository.book;

import com.ikjin.adminserver.entity.book.BookEntity;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<BookEntity, UUID> {

}
