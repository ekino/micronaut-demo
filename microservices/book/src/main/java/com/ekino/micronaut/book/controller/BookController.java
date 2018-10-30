package com.ekino.micronaut.book.controller;

import java.util.UUID;

import javax.inject.Inject;

import com.ekino.micronaut.book.domain.Book;
import com.ekino.micronaut.book.service.BookService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
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
    public Mono<Book> findById(UUID id) {
        return bookService.findById(id);
    }

}
