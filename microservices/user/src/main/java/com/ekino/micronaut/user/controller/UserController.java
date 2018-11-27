package com.ekino.micronaut.user.controller;

import com.ekino.micronaut.user.dto.UserDto;
import com.ekino.micronaut.user.service.UserService;

import java.util.UUID;

import javax.inject.Inject;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import io.micronaut.tracing.annotation.ContinueSpan;
import io.micronaut.tracing.annotation.SpanTag;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static io.micronaut.http.MediaType.APPLICATION_JSON;

@Controller("/users")
public class UserController {

    @Inject
    private UserService userService;

    @Get
    @Produces
    public Flux<UserDto> findAll() {
        return userService.findAll();
    }

    @Get("/{id}")
    @Produces(APPLICATION_JSON)
    @ContinueSpan
    public Mono<UserDto> findById(@SpanTag("user.id") UUID id) {
        return userService.findById(id);
    }

}
