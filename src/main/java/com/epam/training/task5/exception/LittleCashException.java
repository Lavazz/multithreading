package com.epam.training.task5.exception;

public class LittleCashException extends  RuntimeException{
    public LittleCashException() {
    }

    public LittleCashException(String message) {
        super(message);
    }
}
