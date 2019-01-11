package com.ekino.micronaut.borrowing.controller;

import com.ekino.micronaut.borrowing.dto.BorrowingOutputDto;
import com.ekino.micronaut.borrowing.service.BorrowingService;

import java.util.UUID;

import javax.inject.Inject;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Status;
import io.micronaut.tracing.annotation.ContinueSpan;
import io.micronaut.tracing.annotation.SpanTag;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static io.micronaut.http.HttpStatus.OK;

@Controller("/borrowings")
public class BorrowingController {

    @Inject
    private BorrowingService borrowingService;

    @Get
    public Flux<BorrowingOutputDto> findAll() {
        return borrowingService.findAll();
    }

    @Get("/{id}")
    @Status(OK)
    @ContinueSpan
    public Mono<BorrowingOutputDto> findById(@SpanTag("borrowing.id") UUID id) {
        return borrowingService.findById(id);
    }

}
