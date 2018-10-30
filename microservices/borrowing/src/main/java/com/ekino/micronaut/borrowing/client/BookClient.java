package com.ekino.micronaut.borrowing.client;

import com.ekino.micronaut.borrowing.dto.BookDto;

import java.util.UUID;

import io.micronaut.http.client.annotation.Client;
import reactor.core.publisher.Mono;

@Client(id = "book", path = "/books")
public interface BookClient extends BookOperations {

    @Override
    Mono<BookDto> findById(UUID id);

}
