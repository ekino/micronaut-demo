package com.ekino.micronaut.book.controller

import com.ekino.micronaut.book.exception.NotFoundException
import com.ekino.micronaut.book.service.BookService
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.http.client.exceptions.HttpClientResponseException
import io.micronaut.test.annotation.MicronautTest
import io.micronaut.test.annotation.MockBean
import spock.lang.Specification

import javax.inject.Inject

import static com.ekino.micronaut.book.exception.NotFoundErrorType.BOOK_NOT_FOUND
import static java.util.UUID.randomUUID

@MicronautTest(packages = "com.ekino.micronaut.book")
class BookControllerTest extends Specification {

  @Inject
  @Client("/books")
  HttpClient client

  @Inject
  BookService bookService

  @MockBean(BookService)
  BookService bookService() {
    Mock(BookService)
  }

  void "book controller should return 404"() {
    given: "the book service throw a not found exception for find by id"
    UUID id = randomUUID()
    bookService.findById(id) >> { throw new NotFoundException(BOOK_NOT_FOUND, id) }

    when: "we call the find by id endpoint"
    HttpRequest request = HttpRequest.GET("/books/" + id)
    client.toBlocking().exchange(request)

    then: "the http status is 404 with the corresponding message"
    HttpClientResponseException responseException = thrown HttpClientResponseException
    responseException.status == HttpStatus.NOT_FOUND
  }

}
