package com.ikjin.adminserver.repository.book;

import com.ikjin.adminserver.entity.book.BookRentalEntity;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRentalRepository extends CrudRepository<BookRentalEntity, UUID> {

}
