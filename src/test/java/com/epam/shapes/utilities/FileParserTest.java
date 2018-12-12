package com.epam.shapes.utilities;

import com.epam.shapes.entity.Cube;
import com.epam.shapes.exceptions.ParsedFileException;
import com.epam.shapes.utilites.FileParser;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class FileParserTest {
    FileParser fileParser;

    @BeforeTest
    public void init() {
        fileParser = new FileParser();
    }

    @Test
    public void testStringParse() throws ParsedFileException {
        String parsedString = "1.0 1.0 1.0 2.0";
        Cube expectedCube = new Cube(1.0, 1.0, 1.0, 2.0, 2.0, 2.0);
        Assert.assertEquals(expectedCube, fileParser.parse(parsedString));
    }

    @Test
    public void testFailedParse() throws ParsedFileException {
        String parsedString = "1.0 1gh.0 1.0 2.0 2.0";
        Assert.assertEquals(null, fileParser.parse(parsedString));
    }

    @Test
    public void testListParse() throws ParsedFileException {
        List<String> list = new ArrayList<>();
        list.add("1.0 1.0 1.0 2.0");
        list.add("1.0 0.9 1.0 0.01 0.01");
        List<Object> cubes = new ArrayList<>();
        cubes.add(new Cube(1.0,1.0,1.0,2.0,2.0,2.0));
        cubes.add(new Cube(1.0,0.9,1.0,0.01,0.01,0.01));
        Assert.assertEquals(cubes,fileParser.parse(list));
    }
}
