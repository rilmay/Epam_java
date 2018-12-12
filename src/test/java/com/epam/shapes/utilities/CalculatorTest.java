package com.epam.shapes.utilities;

import com.epam.shapes.entity.Cube;
import com.epam.shapes.exceptions.IllegalShapeArgumentException;
import com.epam.shapes.utilites.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CalculatorTest {
    Calculator calculator;
    Cube cube;
    Cube wrongCube;

    @BeforeTest

    public void init() {
        calculator = new Calculator();
        cube = new Cube(1.5, 0.5, 0.0, 2.0, 2.0, 2.0);
        wrongCube = new Cube(1.5, 0.5, 0.0, 2.0, 0.0, 2.1);
    }

    @Test
    public void testGetCubeSurfaceArea() {
        Assert.assertEquals(24.0, calculator.getCubeSurfaceArea(cube), 0.5);
    }

    @Test
    public void testGetCubeVolume() {
        Assert.assertEquals(8.0, calculator.getCubeVolume(cube), 0.5);
    }

    @Test
    public void testIsCube() {
        Assert.assertTrue(calculator.isCube(cube));
    }

    @Test
    public void testIsOnPlane() {
        Assert.assertFalse(calculator.isOnPlane(cube));
    }

    @Test
    public void testDividedByPlane() {
        Assert.assertEquals("1.0:3.0", calculator.dividedByPlane(cube, "xz"));
    }

    @Test
    public void testNotDividedByPlane() {
        Assert.assertEquals("Not divided by plane", calculator.dividedByPlane(cube, "yz"));
    }

    @Test(expectedExceptions = IllegalShapeArgumentException.class)
    public void testWrongCube() throws IllegalArgumentException {
        Assert.assertEquals(false, calculator.isOnPlane(wrongCube));
    }

}
