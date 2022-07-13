package br.com.coffeeandit.transactionbff.exception;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class ApplicationExceptionHandler {

    @ExceptionHandler(UnauthorizedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseEntity<ErrorResponse> unauthorized(UnauthorizedException exception){
        log.error("Unauthorized error", exception);
        return response(exception.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> notFound(Exception exception){
        log.error("Not found", exception);
        return response(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorResponse> internal(Exception exception){
        log.error("Internal Error", exception);
        return response(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<ErrorResponse> response(String message, HttpStatus httpStatus){
        return ResponseEntity.status(httpStatus).body(new ErrorResponse(message, httpStatus.value()));
    }
}
