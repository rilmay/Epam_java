package com.epam.shapes.exceptions;

public class IllegalShapeArgumentException extends IllegalArgumentException {
    public IllegalShapeArgumentException() {
    }

    public IllegalShapeArgumentException(String message) {
        super(message);
    }

    public IllegalShapeArgumentException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalShapeArgumentException(Throwable cause) {
        super(cause);
    }
}
