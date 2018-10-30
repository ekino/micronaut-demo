package com.ekino.micronaut.book.service;

import java.util.UUID;

import javax.inject.Inject;

import com.ekino.micronaut.book.domain.Book;
import com.ekino.micronaut.book.exception.NotFoundException;
import com.ekino.micronaut.book.repository.BookRepository;
import io.micronaut.spring.tx.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.ekino.micronaut.book.exception.NotFoundErrorType.BOOK_NOT_FOUND;
import static reactor.core.publisher.Mono.defer;
import static reactor.core.publisher.Mono.error;

public class BookService {

    @Inject
    BookRepository bookRepository;

    @Transactional(readOnly = true)
    public Flux<Book> findAll() {
        return bookRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Mono<Book> findById(UUID id) {
        return bookRepository.findById(id)
                .switchIfEmpty(defer(() -> error(new NotFoundException(BOOK_NOT_FOUND, id))));
    }

}
