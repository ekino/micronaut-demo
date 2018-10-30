package com.ekino.micronaut.book.exception;

import javax.inject.Singleton;

import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;

@Produces
@Singleton
@Requires(classes = { RestRuntimeException.class, ExceptionHandler.class })
public class RestRuntimeExceptionHandler implements ExceptionHandler<RestRuntimeException, HttpResponse> {

    @Override
    public HttpResponse handle(HttpRequest request, RestRuntimeException exception) {
        ExceptionBody exceptionBody = ExceptionBody.builder()
                .code(exception.getErrorCode())
                .description(exception.getMessage())
                .build();

        return HttpResponse.status(exception.getHttpStatus())
                .body(exceptionBody);
    }
}
