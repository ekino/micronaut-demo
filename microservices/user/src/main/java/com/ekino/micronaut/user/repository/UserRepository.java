package com.ekino.micronaut.user.repository;

import com.ekino.micronaut.user.domain.User;

import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.validation.constraints.NotNull;

import io.micronaut.configuration.hibernate.jpa.scope.CurrentSession;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Singleton
public class UserRepository {

    @Inject
    @CurrentSession
    private EntityManager entityManager;

    public Flux<User> findAll() {
        return Flux.fromIterable(entityManager.createQuery("SELECT u FROM User as u", User.class).getResultList());
    }

    public Mono<User> findById(@NotNull UUID id) {
        return Mono.justOrEmpty(entityManager.find(User.class, id));
    }

}
