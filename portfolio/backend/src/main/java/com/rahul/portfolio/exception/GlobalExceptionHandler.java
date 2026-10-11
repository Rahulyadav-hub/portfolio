package com.rahul.portfolio.exception;

import com.rahul.portfolio.dto.ApiError;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> validation(MethodArgumentNotValidException ex) {
        Map<String, String> fields = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(f -> fields.put(f.getField(), f.getDefaultMessage()));
        return build(HttpStatus.BAD_REQUEST, "Validation failed", fields);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ApiError> unreadable(HttpMessageNotReadableException ex) {
        return build(HttpStatus.BAD_REQUEST, "Malformed request body", Map.of());
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiError> notFound(NotFoundException ex) {
        return build(HttpStatus.NOT_FOUND, ex.getMessage(), Map.of());
    }

    @ExceptionHandler(TooManyRequestsException.class)
    public ResponseEntity<ApiError> tooMany(TooManyRequestsException ex) {
        return build(HttpStatus.TOO_MANY_REQUESTS, ex.getMessage(), Map.of());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> other(Exception ex) {
        log.error("Unhandled error", ex);
        return build(HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong", Map.of());
    }

    private ResponseEntity<ApiError> build(HttpStatus s, String msg, Map<String, String> fields) {
        return ResponseEntity.status(s).body(new ApiError(Instant.now(), s.value(), msg, fields));
    }
}
