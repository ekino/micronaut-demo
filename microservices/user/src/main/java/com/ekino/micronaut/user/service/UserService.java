package com.ekino.micronaut.user.service;

import com.ekino.micronaut.user.dto.UserDto;
import com.ekino.micronaut.user.exception.NotFoundException;
import com.ekino.micronaut.user.mapper.UserMapper;
import com.ekino.micronaut.user.repository.UserRepository;

import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.micronaut.spring.tx.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.ekino.micronaut.user.exception.NotFoundErrorType.USER_NOT_FOUND;
import static reactor.core.publisher.Mono.defer;
import static reactor.core.publisher.Mono.error;

@Singleton
public class UserService {

    private final UserMapper userMapper = UserMapper.getInstance();

    @Inject
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public Flux<UserDto> findAll() {
        return userRepository.findAll()
                .map(userMapper::userToUserDto);
    }

    @Transactional(readOnly = true)
    public Mono<UserDto> findById(UUID id) {
        return userRepository.findById(id)
                .map(userMapper::userToUserDto)
                .switchIfEmpty(defer(() -> error(new NotFoundException(USER_NOT_FOUND, id))));
    }

}
