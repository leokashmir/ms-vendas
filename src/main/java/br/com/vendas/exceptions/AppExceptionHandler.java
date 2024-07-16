package br.com.vendas.exceptions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class AppExceptionHandler {

    @Autowired
    private ExceptionHandleResponseBuilder exceptionHandleResponseBuilder;

    @ExceptionHandler(value = {HttpClientErrorException.BadRequest.class})
    public ResponseEntity<ExceptionHandleResponse> handleConflictBadRequest(HttpClientErrorException exception, WebRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionHandleResponseBuilder.getExceptionHandleResponse(exception.getStatusCode().value(), exception.getMessage()));
    }

    @ExceptionHandler(value = {HttpClientErrorException.Unauthorized.class})
    public ResponseEntity<ExceptionHandleResponse> handleConflictUnauthorized(HttpClientErrorException exception, WebRequest request) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(exceptionHandleResponseBuilder.getExceptionHandleResponse(exception.getStatusCode().value(), exception.getMessage()));
    }

    @ExceptionHandler(value = {HttpClientErrorException.NotFound.class})
    public ResponseEntity<ExceptionHandleResponse> handleConflictNotFound(HttpClientErrorException exception, WebRequest request) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionHandleResponseBuilder.getExceptionHandleResponse(exception.getStatusCode().value(), exception.getMessage()));
    }

    @ExceptionHandler(value = {Exception.class })
    public ResponseEntity<ExceptionHandleResponse> handleExceptionHandleResponse(Exception exception, WebRequest request) {
        return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).body(exceptionHandleResponseBuilder.getExceptionHandleResponse(HttpStatus.INTERNAL_SERVER_ERROR.ordinal(), exception.getMessage()));
    }



}