package com.ekino.micronaut.borrowing.controller;

import com.ekino.micronaut.borrowing.dto.BorrowingOutputDto;
import com.ekino.micronaut.borrowing.service.BorrowingService;

import java.util.UUID;

import javax.inject.Inject;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.annotation.Status;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static io.micronaut.http.HttpStatus.OK;
import static io.micronaut.http.MediaType.APPLICATION_JSON;

@Controller("/borrowings")
public class BorrowingController {

    @Inject
    private BorrowingService borrowingService;

    @Get
    @Produces(APPLICATION_JSON)
    public Flux<BorrowingOutputDto> findAll() {
        return borrowingService.findAll();
    }

    @Get("/{id}")
    @Produces(APPLICATION_JSON)
    @Status(OK)
    public Mono<BorrowingOutputDto> findById(UUID id) {
        return borrowingService.findById(id);
    }

}
