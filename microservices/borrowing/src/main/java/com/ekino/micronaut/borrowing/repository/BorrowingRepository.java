package com.ekino.micronaut.borrowing.repository;

import java.util.UUID;

import com.ekino.micronaut.borrowing.domain.Borrowing;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.reactive.ReactiveStreamsCrudRepository;

@Repository
public interface BorrowingRepository extends ReactiveStreamsCrudRepository<Borrowing, UUID> {

}
