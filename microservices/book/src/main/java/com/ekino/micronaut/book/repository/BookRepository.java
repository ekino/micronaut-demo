package com.ekino.micronaut.book.repository;

import java.util.UUID;

import com.ekino.micronaut.book.domain.Book;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.reactive.ReactiveStreamsCrudRepository;

@Repository
public interface BookRepository extends ReactiveStreamsCrudRepository<Book, UUID> {

}
