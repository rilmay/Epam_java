package com.epam.shapes.entity;

public class Cube {
    private Point centrePoint = null;
    private Double width = null;
    private Double height = null;
    private Double length = null;

    public Point getCentrePoint() {
        return centrePoint;
    }

    public Double getWidth() {
        return width;
    }

    public Double getHeight() {
        return height;
    }

    public Double getLength() {
        return length;
    }

    public void setCentrePoint(Point centrePoint) {
        this.centrePoint = centrePoint;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Cube() {
    }

    public Cube(Double x, Double y, Double z, Double width, Double height, Double length) {
        centrePoint = new Point(x, y, z);
        this.width = width;
        this.height = height;
        this.length = length;
    }

    @Override
    public String toString() {
        return centrePoint + " " + width + " " + height + " " + length;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Cube cube = (Cube) obj;
        return this.centrePoint.equals(cube.centrePoint) &&
                this.height.equals(cube.height) &&
                this.width.equals(cube.width) &&
                this.length.equals(cube.length);
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + ((this.centrePoint == null) ? 0 : this.centrePoint.hashCode());
        result = PRIME * result + ((this.width == null) ? 0 : this.width.hashCode());
        result = PRIME * result + ((this.height == null) ? 0 : this.height.hashCode());
        result = PRIME * result + ((this.length == null) ? 0 : this.length.hashCode());
        return result;
    }
}
