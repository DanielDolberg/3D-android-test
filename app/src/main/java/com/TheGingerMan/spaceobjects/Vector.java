package com.TheGingerMan.spaceobjects;

public class Vector {

    double x, y, z;

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
        z = 0;
    }

}
