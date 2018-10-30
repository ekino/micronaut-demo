package com.ekino.micronaut.book.domain;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = PRIVATE)
@Data
@EqualsAndHashCode(of = { "isbn", "copyNumber" })
public class Book {

    @Id
    @GeneratedValue
    UUID id;

    String isbn;

    Integer copyNumber;

    String title;

    String author;

    Integer year;

    String description;

}
