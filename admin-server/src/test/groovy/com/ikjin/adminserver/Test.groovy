package com.ikjin.adminserver

import com.ikjin.adminserver.entity.book.BookEntity
import com.ikjin.adminserver.repository.book.BookRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import spock.lang.Specification

import java.awt.print.Book
import java.math.RoundingMode

//해당 어노테이션에 대한 설명 하기
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class Test extends Specification {

    @Autowired
    private BookRepository bookRepository


    //setup, given, when, then, 기타 블럭에 대한 설명하기
    def "test"() {
        given:
        RoundingMode 소수점버림 = RoundingMode.DOWN;

        when:
        def calculate = CalculateTest.calculate(10000L, 0.1f, 소수점버림);

        then:
        calculate == 10L
    }

    def "새로운 책을 만들어 보기"() {
        given:
        BookEntity bookEntity = new BookEntity()
        bookEntity.with {
            name = "익지니와 함께하는 TDD"
            category = "IT"
            sellCount = 10000L
        }
        BookEntity savedEntity = bookRepository.save(bookEntity)

        when:
        Optional<BookEntity> getBook = bookRepository.findById(savedEntity.getId())
        getBook.orElse(null)

        then:
        if (getBook != null) {
            getBook.get().getName() == "익지니와 함께하는 TDD"
        } else {
            getBook == null
        }
    }

    def "책의 리스트를 가져와 보기"() {
        given:
        Iterable<BookEntity> bookEntityList = bookRepository.findAll()

        when:
        List<BookEntity> list = new ArrayList<>();
        for (BookEntity bookEntity : bookEntityList) {
            list.add(bookEntity);
        }
        print("Book size" + list.size())

        then:
        list.size() == 10
    }

    def "특정 책의 제목을 변경해보기"() {
        given:
        BookEntity savingBook = new BookEntity()
        savingBook.with {
            name =  "책 제목을 변경할 거야"
            category = "인문"
            sellCount = 20000L
        }
        BookEntity savedBook = bookRepository.save(savingBook)
        println("저장 된 책의 식별자 " + savedBook.getId())
        println("저장 된 책의 제목 " + savedBook.getName())
        Iterable<BookEntity> bookEntityList = bookRepository.findAll()

        when:
        BookEntity changeBook = null
        for (BookEntity bookEntity : bookEntityList) {
            if (bookEntity.getId() == savedBook.getId()) {
                changeBook = bookEntity;
            }
        }
        changeBook.setName("제목은 이렇게 변경할거야")
        BookEntity changedBook = bookRepository.save(changeBook)

        println("변경 후 책의 식별자 " + changedBook.getId())
        println("변경 후 책의 제목 " + changedBook.getName())

        then:
        changedBook.getName().equals("제목은 이렇게 변경할거야")
    }

}
