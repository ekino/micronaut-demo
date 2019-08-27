package com.ekino.micronaut.book.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = PRIVATE)
@Data
@EqualsAndHashCode(of = { "isbn", "copyNumber" })
public class BookDTO {

    UUID id;

    String isbn;

    Integer copyNumber;

    String title;

    String author;

    Integer year;

    String description;
}
