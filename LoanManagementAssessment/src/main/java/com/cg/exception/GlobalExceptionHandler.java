package com.cg.exception;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidLoanAmountException.class)
    public ResponseEntity<ErrorResponse> handleInvalidAmount(InvalidLoanAmountException ex) {
        return new ResponseEntity<>(new ErrorResponse("InvalidLoanAmountException", ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DuplicateLoanApplicationException.class)
    public ResponseEntity<ErrorResponse> handleDuplicate(DuplicateLoanApplicationException ex) {
        ErrorResponse error = new ErrorResponse(
            "DuplicateLoanApplicationException",
            ex.getMessage()
        );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(LoanNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(LoanNotFoundException ex) {
        return new ResponseEntity<>(new ErrorResponse("LoanNotFoundException", ex.getMessage()), HttpStatus.NOT_FOUND);
    }
}