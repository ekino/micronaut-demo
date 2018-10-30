package com.ekino.micronaut.borrowing.client;

import com.ekino.micronaut.borrowing.dto.BookDto;

import java.util.UUID;

import io.micronaut.retry.annotation.Fallback;
import reactor.core.publisher.Mono;

import static reactor.core.publisher.Mono.just;

@Fallback
public class BookFallback implements BookOperations {

    @Override
    public Mono<BookDto> findById(UUID id) {
        return just(BookDto.builder().id(id).build());
    }
}
