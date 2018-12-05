package com.ekino.micronaut.borrowing.client;

import com.ekino.micronaut.borrowing.dto.UserDto;

import java.util.UUID;

import io.micronaut.http.client.annotation.Client;
import io.micronaut.retry.annotation.CircuitBreaker;
import reactor.core.publisher.Mono;

@Client(id = "user", path = "/users")
@CircuitBreaker(delay = "5ms")
public interface UserClient extends UserOperations {

    @Override
    Mono<UserDto> findById(UUID id);

}
