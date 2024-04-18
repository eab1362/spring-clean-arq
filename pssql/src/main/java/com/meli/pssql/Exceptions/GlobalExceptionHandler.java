package com.meli.pssql.Exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException e) {
        System.out.println("An error occurreddddddddddddddddddddddddddddddddd: " + e.getMessage());
        log.error("An error occurred: ", e);
        return new ResponseEntity<>("An error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ChangeSetPersister.NotFoundException.class)
    public ResponseEntity<?> handleNotFoundException(ChangeSetPersister.NotFoundException ex, WebRequest request) {
        // Aquí puedes personalizar el mensaje de error y el código de estado según tus necesidades
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}