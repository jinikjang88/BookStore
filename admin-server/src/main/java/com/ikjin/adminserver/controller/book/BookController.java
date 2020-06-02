package com.ikjin.adminserver.controller.book;

import com.ikjin.adminserver.entity.book.BookEntity;
import com.ikjin.adminserver.repository.book.BookRepository;
import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

  @GetMapping("")
  public String Index() {
    return "Index html";
  }

  @GetMapping("/hello")
  public String Hello() {
    return "Hello world";
  }

  @Autowired
  private BookRepository bookRepository;

  @PostMapping("/book")
  public BookEntity createBook(@RequestBody BookEntity bookEntity) {
    BookEntity created = bookRepository.save(bookEntity);
    return created;
  }

  @GetMapping("/book")
  public List<BookEntity> listAllBooks() {
    List<BookEntity> list = new ArrayList<>();
    Iterable<BookEntity> iterable = bookRepository.findAll();
    for (BookEntity bookEntity : iterable) {
      list.add(bookEntity);
      System.out.println(bookEntity.getName());
    }
    return list;
  }

  @GetMapping("/book/{bookId}")
  public BookEntity getBook(@PathVariable("bookId") UUID bookId) {
    Optional<BookEntity> bookEntity = bookRepository.findById(bookId);
    return bookEntity.orElse(null);
  }

  @PutMapping("/book/{bookId}")
  public BookEntity updateBook(@PathVariable("bookId") UUID bookId,
      @RequestBody BookEntity bookEntity) {
    bookEntity.setId(bookId);
    BookEntity updated = bookRepository.save(bookEntity);
    return updated;
  }

  @DeleteMapping("/book/{bookId}")
  public void deleteBook(@PathVariable("bookId") UUID bookId) {
    bookRepository.deleteById(bookId);
  }
}
