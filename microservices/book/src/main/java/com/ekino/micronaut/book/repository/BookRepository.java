package com.ekino.micronaut.book.repository;

import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;

import com.ekino.micronaut.book.domain.Book;
import io.micronaut.configuration.hibernate.jpa.scope.CurrentSession;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static reactor.core.publisher.Flux.fromIterable;
import static reactor.core.publisher.Mono.justOrEmpty;

@Singleton
public class BookRepository {

    @Inject
    @CurrentSession
    private EntityManager entityManager;

    public Flux<Book> findAll() {
        return fromIterable(entityManager.createQuery("SELECT b FROM Book as b", Book.class).getResultList());
    }

    public Mono<Book> findById(UUID id) {
        return justOrEmpty(entityManager.find(Book.class, id));
    }

}
