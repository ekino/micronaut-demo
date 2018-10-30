package com.ekino.micronaut.borrowing.client;

import com.ekino.micronaut.borrowing.dto.UserDto;

import java.util.UUID;

import io.micronaut.http.annotation.Get;
import reactor.core.publisher.Mono;

public interface UserOperations {

    @Get("/{id}")
    Mono<UserDto> findById(UUID id);

}
