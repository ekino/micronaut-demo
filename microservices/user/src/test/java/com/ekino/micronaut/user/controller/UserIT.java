package com.ekino.micronaut.user.controller;

import com.ekino.micronaut.user.dto.UserDto;

import java.util.Set;

import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpResponse;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.micronaut.http.HttpRequest.GET;
import static java.util.UUID.randomUUID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@MicronautTest(packages = "com.ekino.micronaut.user")
class UserIT extends AbstractIT {

    @DisplayName("Find all should return all users")
    @Test
    void findAllShouldReturnAllUsers() {
        // Given
        runSql("UserIT.sql");

        // When
        HttpResponse<Set> response = client.toBlocking().exchange(GET("/users"), Argument.of(Set.class, UserDto.class));

        // Then
        assertThat(response.code()).isEqualTo(200);
        Set<UserDto> users = (Set<UserDto>) response.body();
        assertThat(users).extracting(UserDto::getEmailAddress)
                .contains("pierre@ekino.com", "paul@ekino.com", "jacques@ekino.com");
    }

    @DisplayName("Find by id should return 404")
    @Test
    void findByIdShouldReturnNotFound() {
        assertThatThrownBy(() -> client.toBlocking().retrieve(GET("/users/" + randomUUID())))
                .hasMessage("Not Found");
    }

    @DisplayName("Find by id should return user")
    @Test
    void findByIdShouldReturnUser() {
        // Given
        runSql("UserIT.sql");

        // When
        HttpResponse<UserDto> response = client.toBlocking().exchange(GET("/users/" + "2fdf780a-e8c6-4117-8ac9-af79464afe58"), UserDto.class);

        // Then
        assertThat(response.code()).isEqualTo(200);
        UserDto user = response.body();
        assertThat(user.getEmailAddress()).isEqualTo("pierre@ekino.com");
    }

}
