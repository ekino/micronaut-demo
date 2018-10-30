package com.ekino.micronaut.borrowing.controller;

import com.ekino.micronaut.borrowing.dto.BorrowingOutputDto;

import java.util.Set;

import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpResponse;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.micronaut.http.HttpRequest.GET;
import static java.util.UUID.fromString;
import static java.util.UUID.randomUUID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@MicronautTest(packages = "com.ekino.micronaut.borrowing")
class BorrowingIT extends AbstractIT {

    @DisplayName("Find all should return all borrowings")
    @Test
    void findAllShouldReturnAllBorrowings() {
        // Given
        runSql("BorrowingIT.sql");

        // When
        HttpResponse<Set> response = client.toBlocking().exchange(GET("/borrowings"), Argument.of(Set.class, BorrowingOutputDto.class));

        // Then
        assertThat(response.code()).isEqualTo(200);
        Set<BorrowingOutputDto> borrowings = (Set<BorrowingOutputDto>) response.body();
        assertThat(borrowings).extracting(BorrowingOutputDto::getId)
                .contains(fromString("09ccfe95-0d65-45e7-909f-49e73ba62e19"), fromString("0351a5dd-88d8-4c37-99d4-48c5d28e42b5"));
    }

    @DisplayName("Find by id should return 404")
    @Test
    void findByIdShouldReturnNotFound() {
        assertThatThrownBy(() -> client.toBlocking().retrieve(GET("/borrowings/" + randomUUID())))
                .hasMessage("Not Found");
    }

    @DisplayName("Find by id should return borrowing")
    @Test
    void findByIdShouldReturnUser() {
        // Given
        runSql("BorrowingIT.sql");

        // When
        HttpResponse<BorrowingOutputDto> response =
                client.toBlocking().exchange(GET("/borrowings/" + "09ccfe95-0d65-45e7-909f-49e73ba62e19"), BorrowingOutputDto.class);

        // Then
        assertThat(response.code()).isEqualTo(200);
        BorrowingOutputDto borrowing = response.body();
        assertThat(borrowing).isNotNull();
    }

}
