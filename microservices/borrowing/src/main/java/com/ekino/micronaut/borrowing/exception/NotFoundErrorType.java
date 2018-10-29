package com.ekino.micronaut.borrowing.exception;

import io.micronaut.http.HttpStatus;

import static io.micronaut.http.HttpStatus.NOT_FOUND;

public enum NotFoundErrorType {

    BOOK_NOT_FOUND("book.not.found", "Book \"{0}\" not found."),
    BORROWING_NOT_FOUND("borrowing.not.found", "Borrowing \"{0}\" not found."),
    USER_NOT_FOUND("user.not.found", "User \"{0}\" not found.");

    private final HttpStatus returnCode;

    private final String errorCode;

    private final String description;

    NotFoundErrorType(String errorCode, String description) {
        this.errorCode = errorCode;
        this.description = description;
        this.returnCode = NOT_FOUND;
    }

    public String getDescription() {
        return description;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public HttpStatus getReturnCode() {
        return returnCode;
    }
}

