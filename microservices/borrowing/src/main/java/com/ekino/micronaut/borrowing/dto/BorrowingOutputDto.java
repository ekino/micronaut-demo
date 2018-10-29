package com.ekino.micronaut.borrowing.dto;

import java.time.LocalDate;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
@EqualsAndHashCode(of = { "user", "book", "startDate" })
public class BorrowingOutputDto {

    UUID id;

    UserDto user;

    BookDto book;

    LocalDate startDate;

    LocalDate endDate;

    Boolean exceeded;

}