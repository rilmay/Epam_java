package com.epam.shapes.utilites;

import com.epam.shapes.entity.Point;
import com.epam.shapes.exceptions.IllegalShapeArgumentException;
import com.epam.shapes.validator.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ShapesUtility {
    private static final Logger logger = LogManager.getLogger(ShapesUtility.class);
    private static ShapesUtility shapesUtility = null;
    private Validator validator = Validator.getValidator();

    public static ShapesUtility getShapesUtility() {
        if (ShapesUtility.shapesUtility == null) {
            new ShapesUtility();
        }
        return ShapesUtility.shapesUtility;
    }

    private ShapesUtility() {
        ShapesUtility.shapesUtility = this;
    }


    public double[] toArray(Point point) throws IllegalShapeArgumentException {
        if (!validator.isValid(point)) {
            logger.error("Incorrect point arguments, point: "+point);
            throw new IllegalShapeArgumentException("Incorrect point");
        }
        double[] coordinates = new double[3];
        coordinates[0] = point.getX();
        coordinates[1] = point.getY();
        coordinates[2] = point.getZ();
        return coordinates;
    }

    public double rounding(double d) throws IllegalShapeArgumentException {
        if (!validator.isValid(d)) {
            logger.error("Incorrect double argument, double: "+d);
            throw new IllegalShapeArgumentException("Incorrect double");
        }
        return Math.ceil(d * 10) / 10;
    }
}
