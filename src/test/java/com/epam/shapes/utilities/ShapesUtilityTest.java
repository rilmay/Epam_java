package com.epam.shapes.utilities;

import com.epam.shapes.entity.Point;
import com.epam.shapes.utilites.ShapesUtility;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ShapesUtilityTest {
    ShapesUtility shapesUtility;
    Point point;

    @BeforeTest
    public void init() {
        point = new Point(1.5, 0.5, 0.0);
        shapesUtility = ShapesUtility.getShapesUtility();
    }

    @Test
    public void testToArray() {
        Assert.assertEquals(1.5, shapesUtility.toArray(point)[0], 0.5);
    }

    @Test
    public void testRounding() {
        Assert.assertEquals(1.1, shapesUtility.rounding(1.00001), 0.0);
    }
}
