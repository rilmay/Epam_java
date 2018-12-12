package com.epam.shapes.entity;

public class Point {
    private Double x = null;
    private Double y = null;
    private Double z = null;

    public Double getZ() {
        return z;
    }

    public Double getX() {
        return x;
    }

    public Double getY() {
        return y;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public void setZ(Double z) {
        this.z = z;
    }

    public Point() {
    }

    public Point(Double x, Double y, Double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString() {
        return x + " " + y + " " + z;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Point point = (Point) obj;
        return this.x.equals(point.x) &&
                this.y.equals(point.y) &&
                this.z.equals(point.z);
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + ((this.x == null) ? 0 : x.hashCode());
        result = PRIME * result + ((this.y == null) ? 0 : y.hashCode());
        result = PRIME * result + ((this.z == null) ? 0 : z.hashCode());
        return result;
    }
}
