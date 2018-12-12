package com.epam.shapes.exceptions;

import java.io.IOException;

public class ParsedFileException extends IOException {
    public ParsedFileException() {
    }

    public ParsedFileException(String message) {
        super(message);
    }

    public ParsedFileException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParsedFileException(Throwable cause) {
        super(cause);
    }
}
