package com.ekino.micronaut.borrowing.dto;

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
@EqualsAndHashCode(of = { "emailAddress" })
public class UserDto {

    UUID id;

    String emailAddress;

    String firstName;

    String lastName;

    Integer age;

}
