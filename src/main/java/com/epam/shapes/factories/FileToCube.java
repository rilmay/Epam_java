package com.epam.shapes.factories;

import com.epam.shapes.exceptions.ParsedFileException;
import com.epam.shapes.utilites.FileParser;
import com.epam.shapes.utilites.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class FileToCube {
    private static final Logger logger = LogManager.getLogger(FileToCube.class);

    public FileToCube() {
    }

    public List<Object> execute(String fileName) throws ParsedFileException {
        FileReader fileReader = new FileReader(fileName);
        FileParser fileParser = new FileParser();
        try {
            return fileParser.parse(fileReader.read());
        } catch (ParsedFileException e) {
            logger.error("Failed file parsing, file: " + fileName + ", cause: " + e.getMessage());
            throw new ParsedFileException(e.getMessage());
        }
    }
}
