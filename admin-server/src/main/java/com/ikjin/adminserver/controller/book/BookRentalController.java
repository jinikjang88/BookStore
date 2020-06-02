package com.ikjin.adminserver.controller.book;

import com.ikjin.adminserver.entity.book.BookEntity;
import com.ikjin.adminserver.entity.book.BookRentalEntity;
import com.ikjin.adminserver.repository.book.BookRentalCustomRepository;
import com.ikjin.adminserver.repository.book.BookRentalRepository;
import com.ikjin.adminserver.repository.book.BookRepository;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookRentalController {

  @Autowired
  private BookRepository bookRepository;

  @Autowired
  private BookRentalRepository bookRentalRepository;

  @Autowired
  private BookRentalCustomRepository bookRentalCustomRepository;

  @PostMapping("/book/{bookId}/rental")
  public BookRentalEntity createBookRental(
      @PathVariable("bookId") UUID bookId,
      @RequestBody BookRentalEntity bookRentalEntity) {

    BookRentalEntity created = null;

    BookEntity bookEntity = bookRepository.findById(bookId).orElse(null);
    if (bookEntity != null) {
      bookRentalEntity.setBookEntity(bookEntity);
      created = bookRentalRepository.save(bookRentalEntity);
    }

    return created;
  }

  @GetMapping("/book/{bookId}/rental")
  public List<BookRentalEntity> listBookRentalByBookId(
      @PathVariable("bookId") UUID bookId
  ) {
    return bookRentalCustomRepository.listBookRentalByBookId(bookId);
  }

  @PutMapping("/book/{bookId}/rental/{rentalId}/return")
  public BookRentalEntity returnBookRental(
      @PathVariable("bookId") UUID bookId,
      @PathVariable("rentalId") UUID rentalId
  ) {
    BookRentalEntity updated = null;

    BookRentalEntity bookRentalEntity = bookRentalRepository.findById(rentalId).orElse(null);
    if (bookRentalEntity != null) {
      bookRentalEntity.setReturned(true);
      updated = bookRentalRepository.save(bookRentalEntity);
    }

    return updated;
  }
}
