package com.epam.shapes.factories;

import com.epam.shapes.entity.Cube;
import com.epam.shapes.exceptions.ParsedFileException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class FilesToCubeTest {
    FileToCube fileToCube;
    List<Object> list;
    Cube expectedCube;

    @BeforeTest
    public void init() {
        fileToCube = new FileToCube();
    }

    @Test
    public void goodCubeExecute() {
        list = new ArrayList<>();
        expectedCube = new Cube(1.0, 1.0, 1.0, 3.0, 3.0, 3.0);
        list.add(expectedCube);
        try {
            Assert.assertEquals(list, fileToCube.execute("FilesToParse/GoodCube.txt"));
        } catch (ParsedFileException e) {
        }
    }

    @Test
    public void multipleCubeExecute() throws ParsedFileException{
        list = new ArrayList<>();
        list.add(new Cube(1.0, 1.0, 1.0, 3.0, 3.0, 3.0));
        list.add(new Cube(1.5, 1.5, -1.0, 4.0, 4.0, 4.0));
        list.add(new Cube(1.3, 1.3, -0.1, 3.3, 3.3, 3.3));
        Assert.assertEquals(list, fileToCube.execute("FilesToParse/MultipleCubes.txt"));
    }

    @Test(expectedExceptions = ParsedFileException.class)
    public void wrongCubeExecute() throws ParsedFileException {
        list = new ArrayList<>();
        list.add(new Cube(1.0, 0.0, 1.0, 0.01, 0.01, 0.01));
        Assert.assertEquals(list,fileToCube.execute("FilesToParse/WrongCube.txt"));
    }

}
