package com.ekino.micronaut.borrowing.repository;

import com.ekino.micronaut.borrowing.domain.Borrowing;

import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.validation.constraints.NotNull;

import io.micronaut.configuration.hibernate.jpa.scope.CurrentSession;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Singleton
public class BorrowingRepository {

    @Inject
    @CurrentSession
    private EntityManager entityManager;

    public Flux<Borrowing> findAll() {
        return Flux.fromIterable(entityManager.createQuery("SELECT u FROM Borrowing as u", Borrowing.class).getResultList());
    }

    public Mono<Borrowing> findById(@NotNull UUID id) {
        return Mono.justOrEmpty(entityManager.find(Borrowing.class, id));
    }

}
