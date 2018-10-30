package com.ekino.micronaut.book.exception;

public class NotFoundException extends RestRuntimeException {

    public NotFoundException(NotFoundErrorType errorType, Object... args) {
        super(errorType.getReturnCode(), errorType.getDescription(), errorType.getErrorCode(), args);
    }

}
