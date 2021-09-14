package com.sem1colon.buzzer.contest;

public class InvalidContestException extends Exception {
    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public InvalidContestException(String message) {
        super();
        this.message = message;
    }
}
