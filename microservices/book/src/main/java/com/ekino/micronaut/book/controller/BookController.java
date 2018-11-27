package com.ekino.micronaut.book.controller;

import com.ekino.micronaut.book.domain.Book;
import com.ekino.micronaut.book.service.BookService;

import java.util.UUID;

import javax.inject.Inject;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.tracing.annotation.ContinueSpan;
import io.micronaut.tracing.annotation.SpanTag;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller("/books")
public class BookController {

    @Inject
    BookService bookService;

    @Get
    public Flux<Book> findAll() {
        return bookService.findAll();
    }

    @Get("/{id}")
    @ContinueSpan
    public Mono<Book> findById(@SpanTag UUID id) {
        return bookService.findById(id);
    }

}
