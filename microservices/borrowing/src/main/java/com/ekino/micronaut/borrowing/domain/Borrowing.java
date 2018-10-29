package com.ekino.micronaut.borrowing.domain;

import java.time.LocalDate;
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

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
@EqualsAndHashCode(of = { "userId", "bookId", "startDate" })
@Entity
public class Borrowing {

    @Id
    @GeneratedValue
    UUID id;

    UUID userId;

    UUID bookId;

    LocalDate startDate;

    LocalDate endDate;

    Boolean exceeded;

}
