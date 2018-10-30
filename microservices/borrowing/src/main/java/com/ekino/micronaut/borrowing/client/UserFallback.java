package com.ekino.micronaut.borrowing.client;

import com.ekino.micronaut.borrowing.dto.UserDto;

import java.util.UUID;

import io.micronaut.retry.annotation.Fallback;
import reactor.core.publisher.Mono;

import static reactor.core.publisher.Mono.just;

@Fallback
public class UserFallback implements UserOperations {

    @Override
    public Mono<UserDto> findById(UUID id) {
        return just(UserDto.builder().id(id).build());
    }

}
