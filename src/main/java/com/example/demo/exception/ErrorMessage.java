package com.example.demo.exception;

public class ErrorMessage {
    private String duplicate;

    public ErrorMessage() {
    }

    public ErrorMessage(String duplicate) {
        this.duplicate = duplicate;
    }

    public String getDuplicate() {
        return duplicate;
    }

    public void setDuplicate(String duplicate) {
        this.duplicate = duplicate;
    }
}
