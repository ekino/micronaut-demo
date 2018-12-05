package com.ekino.micronaut.borrowing.client;

import com.ekino.micronaut.borrowing.dto.UserDto;

import java.util.UUID;

import io.micronaut.http.client.annotation.Client;
import io.micronaut.retry.annotation.Retryable;
import reactor.core.publisher.Mono;

@Client(id = "user", path = "/users")
@Retryable(delay = "5ms")
public interface UserClient extends UserOperations {

    @Override
    Mono<UserDto> findById(UUID id);

}
