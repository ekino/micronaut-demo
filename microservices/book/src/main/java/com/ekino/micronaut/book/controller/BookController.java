package com.ekino.micronaut.book.controller;

import java.util.UUID;
import javax.inject.Inject;

import com.ekino.micronaut.book.dto.BookDTO;
import com.ekino.micronaut.book.mapper.BookMapper;
import com.ekino.micronaut.book.service.BookService;
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
    public Flux<BookDTO> findAll() {
        return bookService.findAll().map(BookMapper.getInstance()::booToBookDto);
    }

    @Get("/{id}")
    @ContinueSpan
    public Mono<BookDTO> findById(@SpanTag UUID id) {
        return bookService.findById(id).map(BookMapper.getInstance()::booToBookDto);
    }

}
