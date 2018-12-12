package com.epam.shapes.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.StringTokenizer;

public class FileValidator {
    private static final Logger logger = LogManager.getLogger(FileValidator.class);
    private static FileValidator fileValidator = null;

    public static FileValidator getFileValidator() {
        if (FileValidator.fileValidator == null) {
            new FileValidator();
        }
        return FileValidator.fileValidator;
    }

    private FileValidator() {
        FileValidator.fileValidator = this;
    }

    public boolean isDouble(String line) {
        try {
            Double.parseDouble(line);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public boolean isValid(String line) {
        if (line == null || line.length() < 6) {
            return false;
        }
        int doubleCounter = 0;
        StringTokenizer stringTokenizer = new StringTokenizer(line);

        while (stringTokenizer.hasMoreElements()) {
            if (isDouble(stringTokenizer.nextToken())) {
                doubleCounter++;
            } else {
                return false;
            }
        }
        return (doubleCounter >= 4 && doubleCounter <= 6);
    }
}