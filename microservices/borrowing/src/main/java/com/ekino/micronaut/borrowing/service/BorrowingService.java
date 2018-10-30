package com.ekino.micronaut.borrowing.service;

import com.ekino.micronaut.borrowing.client.BookClient;
import com.ekino.micronaut.borrowing.client.UserClient;
import com.ekino.micronaut.borrowing.domain.Borrowing;
import com.ekino.micronaut.borrowing.dto.BookDto;
import com.ekino.micronaut.borrowing.dto.BorrowingOutputDto;
import com.ekino.micronaut.borrowing.dto.UserDto;
import com.ekino.micronaut.borrowing.exception.NotFoundException;
import com.ekino.micronaut.borrowing.mapper.BorrowingMapper;
import com.ekino.micronaut.borrowing.repository.BorrowingRepository;

import java.util.UUID;
import java.util.function.Function;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.micronaut.spring.tx.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.ekino.micronaut.borrowing.exception.NotFoundErrorType.BORROWING_NOT_FOUND;
import static reactor.core.publisher.Mono.defer;
import static reactor.core.publisher.Mono.error;
import static reactor.core.publisher.Mono.zip;

@Singleton
@Slf4j
public class BorrowingService {

    private final BorrowingMapper borrowingMapper = BorrowingMapper.getInstance();

    @Inject
    private BorrowingRepository borrowingRepository;

    @Inject
    private BookClient bookClient;

    @Inject
    private UserClient userClient;

    private Function<Borrowing, Mono<BorrowingOutputDto>> fetchLinkedResources = borrowing -> zip(
            fetchUserById(borrowing.getUserId()),
            fetchBookById(borrowing.getBookId()))
            .map(tuple -> {
                BorrowingOutputDto borrowingOutputDto = borrowingMapper.borrowingToBorrowingDto(borrowing);
                borrowingOutputDto.setUser(tuple.getT1());
                borrowingOutputDto.setBook(tuple.getT2());
                return borrowingOutputDto;
            });

    @Transactional(readOnly = true)
    public Flux<BorrowingOutputDto> findAll() {
        return borrowingRepository.findAll()
                .flatMap(fetchLinkedResources);
    }

    @Transactional(readOnly = true)
    public Mono<BorrowingOutputDto> findById(UUID id) {
        return borrowingRepository.findById(id)
                .switchIfEmpty(defer(() -> error(new NotFoundException(BORROWING_NOT_FOUND, id))))
                .flatMap(fetchLinkedResources);
    }

    private Mono<BookDto> fetchBookById(UUID id) {
        return bookClient.findById(id)
                .doOnError(exception -> log.error(exception.getLocalizedMessage()));
    }

    private Mono<UserDto> fetchUserById(UUID id) {
        return userClient.findById(id)
                .doOnError(exception -> log.error(exception.getLocalizedMessage()));
    }

}
