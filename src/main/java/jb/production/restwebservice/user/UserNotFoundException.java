package jb.production.restwebservice.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import jb.production.restwebservice.exception.CustomNotFoundException;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends CustomNotFoundException {

    public UserNotFoundException(String message){
        super(message);
    }
    
}
