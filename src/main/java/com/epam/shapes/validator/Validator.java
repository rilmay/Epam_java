package com.epam.shapes.validator;

import com.epam.shapes.entity.Cube;
import com.epam.shapes.entity.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Validator {
    private static final Logger logger = LogManager.getLogger(Validator.class);
    private static Validator validator = null;

    public static Validator getValidator() {
        if (Validator.validator == null) {
            new Validator();
        }
        return Validator.validator;
    }

    private Validator() {
        Validator.validator = this;
    }

    public boolean isValid(Double var) {
        return var != null && !var.isNaN() && !var.isInfinite();
    }

    public boolean isValid(Point point) {
        return isValid(point.getX()) &&
                isValid(point.getY()) &&
                isValid(point.getZ());
    }

    public boolean isValid(Cube cube) {
        return isValid(cube.getCentrePoint()) &&
                cube.getHeight() > 0.0 &&
                cube.getHeight().equals(cube.getWidth()) &&
                cube.getHeight().equals(cube.getLength());
    }
}
