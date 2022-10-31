package com.sem1colon.buzzer.contestant;

//created Custom Exception class
public class ContestantAlreadyExistsException extends Exception {
    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ContestantAlreadyExistsException(String message) {
        super();
        this.message = message;
    }
}
