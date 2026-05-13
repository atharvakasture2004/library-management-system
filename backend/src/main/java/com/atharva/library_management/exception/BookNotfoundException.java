package com.atharva.library_management.exception;

public class BookNotfoundException extends RuntimeException{
    public BookNotfoundException(String message){
        super(message);
    }
}
