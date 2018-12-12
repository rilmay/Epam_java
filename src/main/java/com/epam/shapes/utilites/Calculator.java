package com.epam.shapes.utilites;

import com.epam.shapes.entity.Cube;
import com.epam.shapes.entity.Point;
import com.epam.shapes.exceptions.IllegalShapeArgumentException;
import com.epam.shapes.validator.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Calculator {
    private static final Logger logger = LogManager.getLogger(Calculator.class);
    private Validator validator = Validator.getValidator();
    private ShapesUtility shapesUtility = ShapesUtility.getShapesUtility();
    private final String AXES = "xyz";

    public double getCubeSurfaceArea(Cube cube) throws IllegalArgumentException {
        if (!validator.isValid(cube)) {
            logger.error("Incorrect cube arguments, cube: " + cube);
            throw new IllegalShapeArgumentException("Incorrect cube");
        }
        return shapesUtility.rounding(Math.pow(cube.getHeight(), 2.0) * 6.0);
    }

    public double getCubeVolume(Cube cube) throws IllegalArgumentException {
        if (!validator.isValid(cube)) {
            logger.error("Incorrect cube arguments, cube:" + cube);
            throw new IllegalShapeArgumentException("Incorrect cube arguments, cube: " + cube);
        }
        return shapesUtility.rounding(Math.pow(cube.getHeight(), 3.0));
    }

    public boolean isCube(Cube cube) {
        return validator.isValid(cube);
    }

    public boolean isOnPlane(Cube cube) {
        if (!validator.isValid(cube)) {
            logger.error("Incorrect cube arguments, cube: " + cube);
            throw new IllegalShapeArgumentException("Incorrect cube");
        }

        Point CentrePoint = cube.getCentrePoint();
        for (double i : shapesUtility.toArray(CentrePoint)) {
            if (Math.abs(i) == (cube.getHeight() / 2)) {
                return true;
            }
        }
        return false;
    }

    public String dividedByPlane(Cube cube, String plane) {
        if (!validator.isValid(cube)) {
            logger.error("Incorrect cube arguments, cube: " + cube);
            throw new IllegalShapeArgumentException("Incorrect cube");
        }

        int whichPlane = -1;
        int counter = 0;
        for (int i = 0; i < 3; i++) {
            if (plane.indexOf(AXES.charAt(i)) == -1) {
                whichPlane = i;
                counter++;
            }
        }
        if (plane.length() != 2 || counter != 1) {
            logger.error("Incorrect plane arguments, plane: " + plane);
            throw new IllegalShapeArgumentException("Incorrect plane parameters");
        }

        Point CentrePoint = cube.getCentrePoint();
        double var1 = shapesUtility.toArray(CentrePoint)[whichPlane] - (cube.getHeight() / 2);
        double var2 = var1 + cube.getHeight();

        if (var1 * var2 >= 0.0) {
            return "Not divided by plane";
        }
        double output = Math.abs(var1 / var2);
        return "1.0:" + shapesUtility.rounding((output > 1.0) ? output : 1.0 / output);
    }
}
