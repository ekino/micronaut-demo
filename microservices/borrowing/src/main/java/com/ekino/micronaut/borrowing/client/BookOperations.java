package com.ekino.micronaut.borrowing.client;

import com.ekino.micronaut.borrowing.dto.BookDto;

import java.util.UUID;

import io.micronaut.http.annotation.Get;
import reactor.core.publisher.Mono;

public interface BookOperations {

    @Get("/{id}")
    Mono<BookDto> findById(UUID id);

}
