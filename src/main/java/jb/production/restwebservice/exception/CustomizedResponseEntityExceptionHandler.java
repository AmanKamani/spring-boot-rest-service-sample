package jb.production.restwebservice.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jb.production.restwebservice.user.PostNotFoundException;
import jb.production.restwebservice.user.UserNotFoundException;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleExceptions(Exception e, WebRequest request) {
        ExceptionResponse response = new ExceptionResponse(new Date(), e.getMessage(), request.getDescription(false));
        return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<Object> handleExceptions(UserNotFoundException e, WebRequest request) {
        ExceptionResponse response = new ExceptionResponse(new Date(), e.getMessage(), request.getDescription(false));
        return new ResponseEntity(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PostNotFoundException.class)
    public final ResponseEntity<Object> handleExceptions(PostNotFoundException e, WebRequest request) {
        ExceptionResponse response = new ExceptionResponse(new Date(), e.getMessage(), request.getDescription(false));
        return new ResponseEntity(response, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {
        ExceptionResponse response = new ExceptionResponse(new Date(), "Validation Failed",
                ex.getBindingResult().toString());
        return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
    }
}
