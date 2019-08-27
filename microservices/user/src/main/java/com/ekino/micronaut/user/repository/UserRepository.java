package com.ekino.micronaut.user.repository;

import com.ekino.micronaut.user.domain.User;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.reactive.ReactiveStreamsCrudRepository;

import java.util.UUID;

@Repository
public interface UserRepository extends ReactiveStreamsCrudRepository<User, UUID> {

}
