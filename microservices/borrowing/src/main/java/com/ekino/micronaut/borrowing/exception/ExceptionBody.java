package com.ekino.micronaut.borrowing.exception;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Data
@FieldDefaults(level = PRIVATE)
@Builder
class ExceptionBody {

    String code;

    String description;

}
