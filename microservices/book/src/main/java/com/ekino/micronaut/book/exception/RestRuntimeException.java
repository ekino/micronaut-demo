package com.ekino.micronaut.book.exception;

import io.micronaut.http.HttpStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;

import static java.text.MessageFormat.format;
import static lombok.AccessLevel.PRIVATE;

@Data
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = PRIVATE)
abstract class RestRuntimeException extends RuntimeException {

    final HttpStatus httpStatus;
    final String errorCode;

    RestRuntimeException(HttpStatus returnCode, String message, String errorCode, Object... args) {
        super(format(message, (Object[]) args));
        this.httpStatus = returnCode;
        this.errorCode = errorCode;
    }

}
