package com.ekino.micronaut.book.IT

import com.ekino.micronaut.book.domain.Book
import io.micronaut.core.type.Argument
import io.micronaut.http.HttpRequest
import io.micronaut.test.annotation.MicronautTest

import static com.ekino.micronaut.book.BookSamples.*

@MicronautTest(packages = "com.ekino.micronaut.book")
class BookIT extends AbstractIT {

  void "If the book id exists the right book should be returned"() {
    given: "the db is populated"
    init()
    runSql('data.sql')

    when: "we do a get request on /books/id with an existing id"
    HttpRequest request = HttpRequest.GET("/books/" + BOOK_ID1)
    Book book = client.toBlocking().retrieve(request, Book.class)

    then: "the book correponding to the id is returned"
    book.id == BOOK_ID1
    book.isbn == BOOK_ISBN1
    book.title == BOOK_TITLE1
    book.author == BOOK_AUTHOR1
    book.year == BOOK_YEAR1
    book.description == BOOK_DESCRIPTION
  }

  void "All existing books should be returned"() {
    given: "the db is populated"
    init()
    runSql('data.sql')

    when: "we do a get request on /books"
    HttpRequest request = HttpRequest.GET("/books")
    Set<Book> books = client.toBlocking().retrieve(request, Argument.of(Set, Book))

    then: "all the books are returned"
    books.size() == 2
    books.id == [BOOK_ID1, BOOK_ID2]
    books.isbn == [BOOK_ISBN1, BOOK_ISBN2]
    books.title == [BOOK_TITLE1, BOOK_TITLE2]
    books.author == [BOOK_AUTHOR1, BOOK_AUTHOR2]
    books.year == [BOOK_YEAR1, BOOK_YEAR2]
    books.description == [BOOK_DESCRIPTION, null]
  }

}
