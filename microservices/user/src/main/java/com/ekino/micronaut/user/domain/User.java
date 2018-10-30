package com.ekino.micronaut.user.domain;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Entity
@Table(name = "\"user\"")
public class User {

    @Id
    @GeneratedValue
    UUID id;

    String emailAddress;

    String firstName;

    String lastName;

    Integer age;

}
