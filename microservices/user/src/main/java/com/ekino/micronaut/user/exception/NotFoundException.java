package com.ekino.micronaut.user.exception;

public class NotFoundException extends RestRuntimeException {

    public NotFoundException(NotFoundErrorType errorType, Object... args) {
        super(errorType.getReturnCode(), errorType.getDescription(), errorType.getErrorCode(), args);
    }

}
