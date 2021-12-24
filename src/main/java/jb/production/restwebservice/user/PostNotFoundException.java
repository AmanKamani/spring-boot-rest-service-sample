package jb.production.restwebservice.user;

import jb.production.restwebservice.exception.CustomNotFoundException;

public class PostNotFoundException extends CustomNotFoundException{

    public PostNotFoundException(String message) {
        super(message);
    }

    
}
