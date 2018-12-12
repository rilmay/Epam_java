package com.epam.shapes.utilities;

import com.epam.shapes.exceptions.ParsedFileException;
import com.epam.shapes.utilites.FileReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class FileReaderTest {
    FileReader fileReader;
    List<String> list;

    @Test
    public void testSuccessRead() throws ParsedFileException {
        fileReader = new FileReader("FilesToParse/GoodCube.txt");
        list = new ArrayList<>();
        list.add("1.0 1.0 1.0 3.0");
        Assert.assertEquals(list, fileReader.read());
    }

    @Test(expectedExceptions = ParsedFileException.class)
    public void testFailedRead() throws ParsedFileException {
        fileReader = new FileReader("lol.txt");
        fileReader.read();
    }
}
